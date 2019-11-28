package com.splittypay;

import com.splittypay.impl.SplittyPayClientImpl;
import com.splittypay.model.Page;
import com.splittypay.model.SplittyPayConfig;
import com.splittypay.model.SplittyPayEnvironment;
import com.splittypay.model.request.PayOutRequest;
import com.splittypay.model.request.PaymentRequest;
import com.splittypay.model.response.*;


public interface SplittyPayClient {

    static SplittyPayClient newSplittyPayClientFor(final SplittyPayEnvironment environment, final String accessToken) {
        return SplittyPayClientImpl.createNewClientFor(environment, accessToken);
    }

    static SplittyPayClient newSplittyPayClientFor(final SplittyPayConfig splittyPayConfig) {
        return SplittyPayClientImpl.createNewClientFor(splittyPayConfig.getEnv(), "not-authorized-token");
    }

    PaymentResponse createPayment(PaymentRequest paymentRequest);

    PaymentMerchantResponse getPayment(int id);

    PaymentMerchantResponse getPayment(String ref);

    Page<PaymentMerchantResponse> getPayments();

    BalanceResponse getBalance();

    PayOutResponse createPayOut(PayOutRequest payOutRequest);

    PayOutResponse getPayOut(long id);

    Page<PayOutResponse> getPayOuts();

    Page<InteractionResponse> getInteractions(int id);

    Page<InteractionResponse> getInteractions(String ref);

}
