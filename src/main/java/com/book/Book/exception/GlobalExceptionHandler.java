package com.book.Book.exception;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> errors = new ArrayList<String>();

        for (FieldError f: ex.getBindingResult().getFieldErrors()   ) {
            errors.add(f.getDefaultMessage());
        }

        for (ObjectError f: ex.getBindingResult().getGlobalErrors()) {
            errors.add(f.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse(ex.toString() , errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
