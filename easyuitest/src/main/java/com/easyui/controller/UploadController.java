package com.easyui.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("upload.json")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:/upload/", file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success.jsp";
    }
}