package com.splittypay.core.auth;

public interface AccessTokenStorage {

    AccessToken getAccessToken();

    void setAccessToken(AccessToken token);

    void removeAccessToken();
}
