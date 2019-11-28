package com.splittypay.core.auth;

import com.splittypay.core.auth.impl.Oauth2RefreshToken;
import com.splittypay.model.SplittyPayEnvironment;
import com.splittypay.model.SplittyPayConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RefreshTokenClientIntegrationTest {

    private static RefreshTokenClient refreshTokenClient;


    @BeforeAll
    static void initRefreshTokenClient() {
        refreshTokenClient = new Oauth2RefreshToken(new SplittyPayConfig(
                "youkoala",
                "password",
                "Q4EKnaCz",
                "elffTNejO5EZxR6PI2eUE5IC",
                SplittyPayEnvironment.LOCAL
        ));
    }

    @Test
    void loginShouldSuccess() throws IOException {
        AccessToken accessToken = refreshTokenClient.login();
        Assertions.assertNotNull(accessToken.getAccessToken());
    }
}
