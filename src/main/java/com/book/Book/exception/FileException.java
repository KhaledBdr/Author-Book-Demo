package com.book.Book.exception;

import java.io.IOException;

public class FileException extends RuntimeException {
    public FileException(String s, IOException e) {
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
