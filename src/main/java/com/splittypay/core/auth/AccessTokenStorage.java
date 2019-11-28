package com.splittypay.core.auth;

public interface AccessTokenStorage {
    /**
     * Returned currently stored token.
     *
     * @return
     */
    AccessToken getAccessToken();

    /**
     * Replace token with new one.
     *
     * @param token
     */
    void setAccessToken(AccessToken token);

    /**
     * Remove current token.
     */
    void removeAccessToken();
}
