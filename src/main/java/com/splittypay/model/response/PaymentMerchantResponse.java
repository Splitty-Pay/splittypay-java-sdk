package com.splittypay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splittypay.model.BasePayment;
import com.splittypay.model.PaymentStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentMerchantResponse extends BasePayment {

    @JsonProperty("id")
    private int id;

    @JsonProperty("cart")
    private String cart;

    @JsonProperty("description")
    private String description;

    @JsonProperty("creation")
    private String creation;

    @JsonProperty("expiration")
    private String expiration;

    @JsonProperty("language")
    private String language;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private PaymentStatus status;

    @JsonProperty("emailStatus")
    private String emailStatus;

    @JsonProperty("notificationStatus")
    private String notificationStatus;

    @JsonProperty("notificationAttempts")
    private int notificationAttempts;

    @JsonProperty("type")
    private String type;

    @JsonProperty("ref")
    private String ref;
}
