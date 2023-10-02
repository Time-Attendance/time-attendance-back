package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.global.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceLoader resourceLoader;


    @GetMapping("/images/{fileName}")
    public ResponseEntity<Resource> serveImage(@PathVariable String fileName) {
        Resource image = resourceLoader.getResource(FileUtil.URL_PATH + fileName);

        HttpHeaders headers = new HttpHeaders();
        if (fileName.endsWith(".svg")) {
            headers.setContentType(MediaType.valueOf("image/svg+xml"));
        }

        return ResponseEntity.ok().headers(headers).body(image);
    }
}
