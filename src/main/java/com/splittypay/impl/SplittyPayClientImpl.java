package com.splittypay.impl;

import com.splittypay.SplittyPayClient;
import com.splittypay.api.SplittyPayApi;
import com.splittypay.model.Page;
import com.splittypay.model.SplittyPayEnvironment;
import com.splittypay.model.request.PayOutRequest;
import com.splittypay.model.request.PaymentRequest;
import com.splittypay.model.response.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SplittyPayClientImpl implements SplittyPayClient {

    private final SplittyPayApi splittyPayApi;

    static SplittyPayClientImpl createNewClientFor(final String baseUrl, final String accessToken) {
        final OkHttpClient okHttpClient = SplittyPayClientFactory.INSTANCE.getOkHttpClient(accessToken, log::debug);
        final SplittyPayApi splittyPayApi = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                //.addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(SplittyPayApi.class);
        return new SplittyPayClientImpl(splittyPayApi);
    }

    public static SplittyPayClientImpl createNewClientFor(final SplittyPayEnvironment environment, final String accessToken) {
        return createNewClientFor(environment.getBaseUrl(), accessToken);
    }

    /*public static SplittyPayClientImpl createNewClientFor(final SplittyPayConfig splittyPayConfig) {
        RefreshTokenClient refreshTokenClient = new Oauth2RefreshToken(splittyPayConfig);
        final SplittyPayApi splittyPayApi = new Retrofit.Builder()
                .baseUrl(splittyPayConfig.getEnv().getBaseUrl())
                //.addConverterFactory(StringConverterFactory.of(LightSelector.class, new LightSelectorConverter()))
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(SplittyPayApi.class);
        return new SplittyPayClientImpl(splittyPayApi);
         }
     */

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        return SplittyPayCallExecutor.of(splittyPayApi.createPayment(paymentRequest)).getResponse();
    }

    @Override
    public PaymentMerchantResponse getPayment(int id) {
        return SplittyPayCallExecutor.of(splittyPayApi.getPayment(id)).getResponse();
    }


    @Override
    public PaymentMerchantResponse getPayment(String ref) {
        return SplittyPayCallExecutor.of(splittyPayApi.getPaymentByRef(ref)).getResponse();
    }

    @Override
    public Page<PaymentMerchantResponse> getPayments() {
        return SplittyPayCallExecutor.of(splittyPayApi.getPayments()).getResponse();
    }

    @Override
    public BalanceResponse getBalance() {
        return SplittyPayCallExecutor.of(splittyPayApi.getBalance()).getResponse();
    }

    @Override
    public PayOutResponse createPayOut(PayOutRequest payOutRequest) {
        return SplittyPayCallExecutor.of(splittyPayApi.createPayOut(payOutRequest)).getResponse();
    }

    @Override
    public PayOutResponse getPayOut(long id) {
        return SplittyPayCallExecutor.of(splittyPayApi.getPayOut(id)).getResponse();
    }

    @Override
    public Page<PayOutResponse> getPayOuts() {
        return SplittyPayCallExecutor.of(splittyPayApi.getPayOuts()).getResponse();
    }

    public Page<InteractionResponse> getInteractions(int id) {
        return SplittyPayCallExecutor.of(splittyPayApi.getInteractions(id)).getResponse();
    }

    @Override
    public Page<InteractionResponse> getInteractions(String ref) {
        return SplittyPayCallExecutor.of(splittyPayApi.getInteractionsByRef(ref)).getResponse();
    }
}
