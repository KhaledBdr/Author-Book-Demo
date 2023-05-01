package com.book.Book.exception;

public class DuplicatedFieldException extends RuntimeException{
    public DuplicatedFieldException() {
        super();
    }

    public DuplicatedFieldException(String message) {
        super(message);
    }
}
