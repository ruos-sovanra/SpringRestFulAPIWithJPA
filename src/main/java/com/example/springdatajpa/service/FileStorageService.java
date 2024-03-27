package com.example.springdatajpa.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileStorageService {
    String uploadSingleFile(MultipartFile file) throws IOException;
    List<String> uploadMultipleFiles(MultipartFile[] files);
}
