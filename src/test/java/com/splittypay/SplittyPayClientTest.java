package com.splittypay;

import com.splittypay.model.SplittyPayConfig;
import com.splittypay.model.SplittyPayEnvironment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SplittyPayClientTest {

    @Test
    void newSplittyPayClientWithAccessTokenShouldSuccess() {
        SplittyPayClient lifxClient = SplittyPayClient.newSplittyPayClientFor(SplittyPayEnvironment.SANDBOX, "accessToken");
        assertNotNull(lifxClient);
    }

    @Test
    void newSplittyPayClientWithCOnfigShouldSuccess() {
        SplittyPayClient lifxClient = SplittyPayClient.newSplittyPayClientFor(
                new SplittyPayConfig(
                "username",
                "password",
                "clientId",
                "clientSecret",
                SplittyPayEnvironment.SANDBOX

        ));
        assertNotNull(lifxClient);
    }
}
