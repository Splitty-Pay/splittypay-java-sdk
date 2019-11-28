package com.splittypay.impl;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.splittypay.SplittyPayClient;
import com.splittypay.model.SplittyPayEnvironment;
import com.splittypay.model.response.PaymentMerchantResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.splittypay.testutil.TestUtils.loadJsonFromFile;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SplittyPayClientImplTest {

    private static final int PORT = 9999;
    private static final String BASE_URL = format("http://localhost:%d/splitty-pay/api/", PORT);
    private static final String VALID_ACCESS_TOKEN = "validAccessToken";
    private static final SplittyPayClient AUTHORIZED_CLIENT = authorizedClient();

    private WireMockServer wireMockServer;

    @BeforeEach
    void setup() {
        wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
    }

    @AfterEach
    void teardown() {
        wireMockServer.stop();
    }

    @Test
    void getPayment() throws IOException {
        final String response = loadJsonFromFile("/json/response_body/merchant_payment.json");

        wireMockServer.stubFor(get(urlEqualTo("/splitty-pay/api/payments/1"))
                .withHeader("Authorization", equalTo("Bearer " + VALID_ACCESS_TOKEN))
                .willReturn(aResponse().withBody(response)));

        final PaymentMerchantResponse payment = AUTHORIZED_CLIENT.getPayment(1);

        Assertions.assertEquals(10000, payment.getAmount());
    }

    @Test
    void createNewSplittyPayClientImplShouldSuccess() {
        SplittyPayClient splittyPayClient = SplittyPayClientImpl.createNewClientFor(SplittyPayEnvironment.SANDBOX, "accessToken");
        assertNotNull(splittyPayClient);
    }

    private static SplittyPayClient authorizedClient() {
        return SplittyPayClientImpl.createNewClientFor(BASE_URL, VALID_ACCESS_TOKEN);
    }
}
