package com.splittypay.core.auth;

public class AuthException extends RuntimeException {

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthException(String message) {
        super(message);
    }
}
