package com.book.Book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Arrays;

@ControllerAdvice
public class DuplicatedFieldHandler {
    @ExceptionHandler(DuplicatedFieldException.class)
    public ResponseEntity<?> handle(DuplicatedFieldException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage(), Arrays.asList(exception.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}
