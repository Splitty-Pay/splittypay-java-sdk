package com.splittypay.core.auth.impl;

import com.splittypay.core.auth.util.Base64Encoder;
import com.splittypay.model.SplittyPayConfig;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static java.lang.String.format;


public class HashInterceptor implements Interceptor {

    private final SplittyPayConfig splittyPayConfig;

    HashInterceptor(SplittyPayConfig splittyPayConfig) {
        this.splittyPayConfig = splittyPayConfig;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", format("Basic %s", Base64Encoder.encodeCredentials(splittyPayConfig.getClientId(), splittyPayConfig.getClientSecret())))
                .build();
        return chain.proceed(request);
    }
}
