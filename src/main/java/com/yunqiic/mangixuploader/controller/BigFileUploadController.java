package com.yunqiic.mangixuploader.controller;

import com.yunqiic.mangixuploader.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 大文件上传
 */
@RestController
@RequestMapping("/BigFile")
@CrossOrigin
public class BigFileUploadController {
    @Autowired
    private FileService fileService;

    @PostMapping("/")
    public void upload(String appId, String appFileId, String fileName,
                       String md5,
                       Long size,
                       Integer chunks,
                       Integer chunk,
                       MultipartFile file) throws IOException {
        if (chunks != null && chunks != 0) {
            fileService.uploadWithBlock(appId, appFileId, fileName, md5,size,chunks,chunk,file);
        } else {
            fileService.upload(appId, appFileId, fileName, md5,file);
        }
    }
}
