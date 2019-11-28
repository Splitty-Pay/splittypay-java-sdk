package com.splittypay.impl;

import com.splittypay.core.auth.AccessTokenStorage;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static java.lang.String.format;

public class AccessTokenInterceptor implements Interceptor {

    private final AccessTokenStorage tokenStorage;

    public AccessTokenInterceptor(AccessTokenStorage tokenStorage) {
        this.tokenStorage = tokenStorage;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String accessToken = tokenStorage.getAccessToken().getAccessToken();
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", format("Bearer %s", accessToken))
                .build();
        return chain.proceed(request);
    }

}
