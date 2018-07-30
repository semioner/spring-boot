package com.semion.example.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Slf4j
@RestController
public class FileUploadController {


    public String singleUpload(@RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            Path path = Paths.get("./" + filename);
            Files.write(path, bytes);

        } catch (IOException e) {
            log.error("文件上传失败");
        }
        return "success";
    }

}
