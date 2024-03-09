package com.calculator.web.exception;

public class ArgumentoInvalido extends RuntimeException{
    public ArgumentoInvalido() {
    }

    public ArgumentoInvalido(String message) {
        super(message);
    }

    public ArgumentoInvalido(String message, Throwable cause) {
        super(message, cause);
    }
}
