package com.splittypay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splittypay.model.BasePayment;
import com.splittypay.model.PaymentStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentResponse extends BasePayment {

    @JsonProperty("id")
    private int id;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    @JsonProperty("ref")
    private String ref;

    @JsonProperty("status")
    private PaymentStatus status;

    @JsonProperty("redirectUrl")
    private String redirectUrl;

    @JsonProperty("clientSecret")
    private String clientSecret;

    @JsonProperty("publicKey")
    private String publicKey;
}
