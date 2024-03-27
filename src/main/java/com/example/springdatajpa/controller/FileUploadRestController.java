package com.example.springdatajpa.controller;

import com.example.springdatajpa.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileUploadRestController {
    private final FileStorageService fileStorageService;

    public HashMap<String, Object> responseMessage(Object data, String message, int status){
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload", data);
        response.put("message", message);
        response.put("status",status);
        return response;
    }

    @PostMapping(value = "",consumes = "multipart/form-data")
    public HashMap<String, Object> uploadFile(@RequestBody MultipartFile file) throws IOException {
        return responseMessage(fileStorageService.uploadSingleFile(file), "File Uploaded Successfully", 200);
    }
}
