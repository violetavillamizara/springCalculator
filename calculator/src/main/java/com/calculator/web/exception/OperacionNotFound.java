package com.calculator.web.exception;

public class OperacionNotFound extends RuntimeException{
    public OperacionNotFound() {
    }

    public OperacionNotFound(String message) {
        super(message);
    }

    public OperacionNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
