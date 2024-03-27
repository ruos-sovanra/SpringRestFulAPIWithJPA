package com.example.springdatajpa.service.serviceImpl;

import com.example.springdatajpa.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {
    @Value("${file_storage.image_location}")
    String fileLocation;
    @Override
    public String uploadSingleFile(MultipartFile file) throws IOException {
            try{
                Path imageStorageLocation = Path.of(fileLocation);
                if (!Files.exists(imageStorageLocation)) {
                    Files.createDirectories(imageStorageLocation);
                }
                String newFileName = UUID.randomUUID()+"."+file.getOriginalFilename().split("\\.")[1];
                Path targetLocation = imageStorageLocation.resolve(newFileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                return newFileName;
            }catch (Exception e){
                e.printStackTrace();
            }

        return null;
    }

    @Override
    public List<String> uploadMultipleFiles(MultipartFile[] files) {
        return null;
    }
}
