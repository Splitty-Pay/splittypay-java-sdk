package com.splittypay.core.auth.impl;

import com.splittypay.core.auth.AccessToken;
import com.splittypay.core.auth.RefreshTokenClient;
import com.splittypay.core.auth.internal.Oauth2Service;
import com.splittypay.model.SplittyPayConfig;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@Slf4j
public class Oauth2RefreshToken implements RefreshTokenClient {

    private Oauth2Service oauth2Service;

    private SplittyPayConfig splittyPayConfig;

    public Oauth2RefreshToken(SplittyPayConfig splittyPayConfig) {
        final OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new HashInterceptor(splittyPayConfig))
                .addInterceptor(loggingInterceptor(log::debug))
                .build();
        final Oauth2Service oauth2Service = new Retrofit.Builder()
                .baseUrl(splittyPayConfig.getEnv().getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(Oauth2Service.class);
        this.splittyPayConfig = splittyPayConfig;
        this.oauth2Service = oauth2Service;
    }

    @Override
    public AccessToken login() throws IOException {
        return oauth2Service.login(this.splittyPayConfig.getUsername(), this.splittyPayConfig.getPassword()).execute().body();
    }

    private static Interceptor loggingInterceptor(final HttpLoggingInterceptor.Logger logger) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
