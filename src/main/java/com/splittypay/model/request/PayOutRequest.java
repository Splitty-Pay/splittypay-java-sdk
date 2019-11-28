package com.splittypay.model.request;

import com.splittypay.model.MoneyAmount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PayOutRequest extends MoneyAmount {
}
