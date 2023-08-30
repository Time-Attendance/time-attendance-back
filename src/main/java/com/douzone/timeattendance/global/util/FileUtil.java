package com.douzone.timeattendance.global.util;

import com.douzone.timeattendance.exception.FileUploadException;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    public static final String UPLOAD_PATH = System.getProperty("user.dir") + File.separator +
            "src" + File.separator +
            "main" + File.separator +
            "resources" + File.separator +
            "upload" + File.separator;

    public static final String URL_PATH = "file:" +
            System.getProperty("user.dir") + File.separator +
            "src" + File.separator +
            "main" + File.separator +
            "resources" + File.separator +
            "upload" + File.separator;

    public static String saveFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return "";
        }

        String storeFilename = FileUtil.createStoreFilename(file.getOriginalFilename());
        String fullPath = FileUtil.UPLOAD_PATH + storeFilename;

        try {
            //파일 저장
            file.transferTo(new File(fullPath));
        } catch (IOException e) {
            throw new FileUploadException();
        }

        return storeFilename;
    }

    public static void removeFile(String filename) {
        String fullPath = UPLOAD_PATH + filename;
        File file = new File(fullPath);
        if (file.exists()) {
            if (!file.delete()) {
                throw new RuntimeException("Failed to delete file: " + fullPath);
            }
        } else {
            throw new RuntimeException("Failed to delete file: " + fullPath);
        }
    }

    public static String createStoreFilename(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public static String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
