package com.splittypay.core.auth;

public enum Scope {

    READ("read"),

    WRITE("write");

    private String description;

    Scope(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
