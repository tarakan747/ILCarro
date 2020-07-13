package com.example.ilcarroappl.business.auth;

public class PasswordValidException extends RuntimeException {
    public PasswordValidException(String message) {
        super(message);
    }
}
