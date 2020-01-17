package com.splittypay.api;

import com.splittypay.model.Page;
import com.splittypay.model.request.PayOutRequest;
import com.splittypay.model.request.PaymentRequest;
import com.splittypay.model.response.BalanceResponse;
import com.splittypay.model.response.InteractionResponse;
import com.splittypay.model.response.PayOutResponse;
import com.splittypay.model.response.PaymentMerchantResponse;
import com.splittypay.model.response.PaymentResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface SplittyPayApi {

    @POST("register-payment")
    Call<PaymentResponse> createPayment(final @Body PaymentRequest paymentRequest);

    @GET("payments/{id}")
    Call<PaymentMerchantResponse> getPayment(@Path("id") int id);

    @GET("payments/getsByRandomId/{randomId}")
    Call<PaymentMerchantResponse> getPaymentByRef(@Path("randomId") String randomId);

    @GET("payments")
    Call<Page<PaymentMerchantResponse>> getPayments();

    @GET("balance")
    Call<BalanceResponse> getBalance();

    @POST("payouts")
    Call<PayOutResponse> createPayOut(final @Body PayOutRequest payOutRequest);

    @GET("payouts/{id}")
    Call<PayOutResponse> getPayOut(@Path("id") long id);

    @GET("payouts")
    Call<Page<PayOutResponse>> getPayOuts();

    @GET("payments/{id}/interactions")
    Call<Page<InteractionResponse>> getInteractions(@Path("id") int id);

    @GET("payments/getsByRandomId/{randomId}/interactions")
    Call<Page<InteractionResponse>> getInteractionsByRef(@Path("randomId") String randomId);

}
