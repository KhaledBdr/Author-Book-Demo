package com.book.Book.controller;

import com.book.Book.service.TestIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/integration")
@RestController
public class TestIntegrationController {
    @Autowired
    private TestIntegration testIntegration;
    @GetMapping("/posts")
    public ResponseEntity<List>  getAllPosts() {
        return testIntegration.getAllPosts();

    }
}
