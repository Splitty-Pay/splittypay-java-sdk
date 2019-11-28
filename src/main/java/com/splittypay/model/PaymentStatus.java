package com.splittypay.model;

public enum PaymentStatus {

    PENDING("PENDING"),
    COMPLETED("COMPLETED"),
    DELETED("DELETED"),
    REFUND("REFUND");

    private String name;

    PaymentStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
