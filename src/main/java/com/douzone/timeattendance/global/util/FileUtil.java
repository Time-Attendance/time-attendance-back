package com.douzone.timeattendance.global.util;

import com.douzone.timeattendance.exception.FileUploadException;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
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

        //이미지 파일 검증
        String contentType = file.getContentType();
        if(!"image/png".equals(contentType) && !"image/jpeg".equals(contentType) && !"image/svg+xml".equals(contentType)) {
            throw new FileUploadException("이미지 파일만 업로드 가능합니다.");
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
                log.info("파일 삭제에 실패했습니다. 파일경로: {}", fullPath);
            }
        } else {
            log.info("해당 파일이 존재하지 않습니다. 파일경로: {}", fullPath);
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
