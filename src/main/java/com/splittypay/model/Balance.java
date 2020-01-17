package com.splittypay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Balance extends MoneyAmount {

    @JsonProperty("timestamp")
    private String timestamp;
}
