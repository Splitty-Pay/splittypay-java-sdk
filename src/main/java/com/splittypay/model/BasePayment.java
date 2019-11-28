package com.splittypay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
public abstract class BasePayment {

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("notificationUrl")
    private String notificationUrl;

    @JsonProperty("successUrl")
    private String successUrl;

    @JsonProperty("cancelUrl")
    private String cancelUrl;

    @JsonProperty("preAuthTypology")
    private String preAuthTypology;

    protected BasePayment() {
    }
}
