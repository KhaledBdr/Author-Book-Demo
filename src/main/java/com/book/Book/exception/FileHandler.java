package com.book.Book.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Array;
import java.util.Arrays;

@ControllerAdvice
public class FileHandler {
    @ExceptionHandler(FileException.class)
    public ResponseEntity<?> fileHandler(FileException fileException){
        ErrorResponse response = new ErrorResponse(
                fileException.getLocalizedMessage(),
                Arrays.asList(fileException.getMessage())
        );
        return ResponseEntity.badRequest().body(response);
    }
}
