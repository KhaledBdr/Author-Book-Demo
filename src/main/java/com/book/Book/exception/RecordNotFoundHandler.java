package com.book.Book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Arrays;

@ControllerAdvice
public class RecordNotFoundHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleNotFound(RecordNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getLocalizedMessage(),
                Arrays.asList(exception.getMessage()));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
