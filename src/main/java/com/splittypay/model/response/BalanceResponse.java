package com.splittypay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splittypay.model.Balance;
import com.splittypay.model.MoneyAmount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalanceResponse {

    @JsonProperty("available")
    private Balance available;

    @JsonProperty("pending")
    private Balance pending;
}
