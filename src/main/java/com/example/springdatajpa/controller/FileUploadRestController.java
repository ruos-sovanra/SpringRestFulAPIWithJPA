package com.example.springdatajpa.controller;

import com.example.springdatajpa.service.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileUploadRestController {
    private final FileStorageService fileStorageService;

    private String generateImageUrl(String fileName, HttpServletRequest request){
        return String.format("%s://%s:%d/images/%s",request.getScheme(), request.getServerName(), request.getServerPort(), fileName);
    }

    public HashMap<String, Object> responseMessage(Object data, String message, int status){
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload", data);
        response.put("message", message);
        response.put("status",status);
        return response;
    }

    @PostMapping(value = "",consumes = "multipart/form-data")
    public HashMap<String, Object> uploadFile(@RequestBody MultipartFile file ,HttpServletRequest request) throws IOException {
        generateImageUrl("fileName",request);
        return responseMessage(generateImageUrl(fileStorageService.uploadSingleFile(file),request), "File Uploaded Successfully", HttpStatus.CREATED.value());
    }
    @PostMapping(value = "/multiple",consumes = "multipart/form-data")
    public HashMap<String, Object> uploadMultipleFiles(@RequestBody MultipartFile[] files) {

        return responseMessage(fileStorageService.uploadMultipleFiles(files), "Files Uploaded Successfully", HttpStatus.CREATED.value());
    }
    @DeleteMapping("/{fileName}")
    public HashMap<String, Object> deleteFile(@PathVariable String fileName){
        fileStorageService.deleteFile(fileName);
        return responseMessage(null, "File Deleted Successfully", HttpStatus.OK.value());
    }
}
