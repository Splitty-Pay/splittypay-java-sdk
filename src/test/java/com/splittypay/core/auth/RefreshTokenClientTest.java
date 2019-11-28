package com.splittypay.core.auth;

import com.splittypay.core.auth.impl.Oauth2RefreshToken;
import com.splittypay.model.SplittyPayEnvironment;
import com.splittypay.model.SplittyPayConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RefreshTokenClientTest {

    @Test
    void newRefreshTokenClientShouldSuccess() {
        RefreshTokenClient refreshTokenClient = new Oauth2RefreshToken(new SplittyPayConfig("username", "password", "clientId", "secret", SplittyPayEnvironment.SANDBOX));
        Assertions.assertNotNull(refreshTokenClient);
    }

}
