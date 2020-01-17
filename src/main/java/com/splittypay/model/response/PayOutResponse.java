package com.splittypay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splittypay.model.MoneyAmount;

public class PayOutResponse extends MoneyAmount {

    @JsonProperty("id")
    private int id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("creation")
    private String creation;

    @JsonProperty("resultMessage")
    private String resultMessage;
}
