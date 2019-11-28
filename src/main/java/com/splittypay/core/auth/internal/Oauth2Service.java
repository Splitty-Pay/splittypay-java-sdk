package com.splittypay.core.auth.internal;

import com.splittypay.core.auth.AccessToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Oauth2Service {

    @FormUrlEncoded
    @POST("/splitty-pay/oauth/token")
    Call<AccessToken> login(@Field("username") String username,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("/splitty-pay/oauth/token")
    Call<AccessToken> refresh(@Field("refresh_token") String refreshToken,
                              @Field("client_id") String clientId);
}
