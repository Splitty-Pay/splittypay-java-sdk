package com.splittypay.impl;

import com.splittypay.core.auth.AccessToken;
import com.splittypay.core.auth.AccessTokenStorage;
import com.splittypay.core.auth.RefreshTokenClient;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

import java.io.IOException;

public class AccessTokenAuthenticator implements Authenticator {

    private final AccessTokenStorage tokenStorage;

    private final RefreshTokenClient refreshTokenClient;

    public AccessTokenAuthenticator(AccessTokenStorage tokenStorage, RefreshTokenClient refreshTokenClient) {
        this.tokenStorage = tokenStorage;
        this.refreshTokenClient = refreshTokenClient;
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        AccessToken newAccessToken = refreshTokenClient.login();
        tokenStorage.setAccessToken(newAccessToken);
        return newRequestWithAccessToken(response.request(), newAccessToken.getAccessToken());
    }

    private Request newRequestWithAccessToken(Request request, String accessToken) {
        return request.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .build();
    }
}
