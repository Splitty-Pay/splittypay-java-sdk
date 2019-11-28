package com.splittypay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
public abstract class MoneyAmount {

    @JsonProperty("amount")
    private long amount;

    @JsonProperty("currency")
    private Currency currency;

    protected MoneyAmount() {
    }
}
