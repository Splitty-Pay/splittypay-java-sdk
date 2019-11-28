package com.splittypay.model.request;

import com.splittypay.model.BasePayment;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
public class PaymentRequest extends BasePayment {

    private String cart;

    private String type;

    private Details details;

}
