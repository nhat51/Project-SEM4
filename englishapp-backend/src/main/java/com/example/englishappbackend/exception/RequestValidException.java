package com.example.englishappbackend.exception;

public class RequestValidException extends RuntimeException{
    public RequestValidException(String message) {
        super(message);
    }
}
