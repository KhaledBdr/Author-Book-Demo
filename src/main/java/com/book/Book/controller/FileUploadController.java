package com.book.Book.controller;

import com.book.Book.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping("/upload")
    public ResponseEntity<Object> uploadImage(@RequestParam String pathType, @RequestParam Long id
            , @RequestParam MultipartFile file) throws IOException {
        String uploadedFile = fileUploadService.uploadFile(pathType,
                id, file);
        return ResponseEntity.ok(uploadedFile);
    }
}
