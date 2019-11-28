package com.splittypay.model;

public enum SplittyPayEnvironment {

    LOCAL("http://localhost:8080/splitty-pay/api/"),
    SANDBOX("https://sandbox.splittypay.it/splitty-pay/api/"),
    PROD("https://secure.splittypay.it/splitty-pay/api/");

    private String baseUrl;

    SplittyPayEnvironment(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
