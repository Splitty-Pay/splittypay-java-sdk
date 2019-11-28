package com.splittypay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SplittyPayConfig {

    private final String username;

    private final String password;

    private final String clientId;

    private final String clientSecret;

    private final SplittyPayEnvironment env;

}
