package com.splittypay;

import com.splittypay.exception.SplittyPayErrorException;
import com.splittypay.model.Page;
import com.splittypay.model.PaymentStatus;
import com.splittypay.model.SplittyPayEnvironment;
import com.splittypay.model.request.Details;
import com.splittypay.model.request.PaymentRequest;
import com.splittypay.model.response.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(OrderAnnotation.class)
class SplittyPayClientIntegrationTest {

    private static SplittyPayClient splittyPayClient;

    @BeforeAll
    static void initSplittyPayClient() {
        //String accessToken = Optional.ofNullable(System.getenv("IT_ACCESS_TOKEN")).filter(StringUtils::isNotBlank).get();
        splittyPayClient = SplittyPayClient.newSplittyPayClientFor(SplittyPayEnvironment.SANDBOX, "edf61de8-2756-4186-9ab7-ae6c30ba0675");
    }

    @Test
    @Order(1)
    void createPayment() {
        PaymentResponse paymentResponse = splittyPayClient.createPayment(PaymentRequest.builder()
                .cart("123")
                .currency("EUR")
                .notificationUrl("https://splittypay.com")
                .cancelUrl("https://errorUrl")
                .successUrl("https://successUrl")
                .amount(10000)
                .details(Details.builder()
                        .email("example@splittypay.com")
                        .language("IT")
                        .build()
                ).build());

        Assertions.assertNotNull(paymentResponse);
        Assertions.assertEquals(paymentResponse.getStatus(), PaymentStatus.PENDING);
        this.getPayment(paymentResponse.getId());

    }

    void getPayment(int id) {
        PaymentMerchantResponse paymentResponse = splittyPayClient.getPayment(id);
        Assertions.assertNotNull(paymentResponse);
        Assertions.assertEquals(paymentResponse.getStatus(), PaymentStatus.PENDING);
    }

    @Test
    @Order(2)
    void createPaymentSingleCard() {
        PaymentResponse paymentResponse = splittyPayClient.createPayment(PaymentRequest.builder()
                .cart("123")
                .currency("EUR")
                .notificationUrl("https://splittypay.com")
                .cancelUrl("https://errorUrl")
                .successUrl("https://successUrl")
                .amount(10000)
                .type("MONO")
                .details(Details.builder()
                        .email("example@splittypay.com")
                        .language("IT")
                        .build()
                ).build());

        Assertions.assertNotNull(paymentResponse);
        Assertions.assertNotNull(paymentResponse.getClientSecret());
        Assertions.assertNotNull(paymentResponse.getPublicKey());
        Assertions.assertEquals(paymentResponse.getStatus(), PaymentStatus.PENDING);
    }

    @Test
    void getPaymentByRandomId() {
        PaymentMerchantResponse paymentResponse = splittyPayClient.getPayment("9yz6uvMo2iCHggxjXg8jGFtVHsCTnUBduDyMBEicraK9DUhuCu");
        Assertions.assertNotNull(paymentResponse);
        Assertions.assertEquals(paymentResponse.getRef(), "9yz6uvMo2iCHggxjXg8jGFtVHsCTnUBduDyMBEicraK9DUhuCu");
    }

    @Test
    void getPaymentPage() {
        Page<PaymentMerchantResponse> paymentResponse = splittyPayClient.getPayments();
        Assertions.assertNotNull(paymentResponse);
    }

    @Test
    void getBalance() {
        BalanceResponse balance = splittyPayClient.getBalance();
        Assertions.assertNotNull(balance);
    }

    @Test
    void getPayOut() {
        PayOutResponse payOut = splittyPayClient.getPayOut(1);
        Assertions.assertNotNull(payOut);
    }

    @Test
    void getPayOutPage() {
        Page<PayOutResponse> payOuts = splittyPayClient.getPayOuts();
        Assertions.assertNotNull(payOuts);
    }

    @Test
    void getInteractionsPage() {
        Page<InteractionResponse> interactions = splittyPayClient.getInteractions(410);
        Assertions.assertNotNull(interactions);
    }

    @Test
    void getInteractionsPageByRef() {
        Page<InteractionResponse> interactions = splittyPayClient.getInteractions("9yz6uvMo2iCHggxjXg8jGFtVHsCTnUBduDyMBEicraK9DUhuCu");
        Assertions.assertNotNull(interactions);
    }


    @Test
    void unauthorizedException() {
        SplittyPayClient splittyPayClient = SplittyPayClient.newSplittyPayClientFor(SplittyPayEnvironment.SANDBOX, "not-authorized-token");
        Assertions.assertThrows(SplittyPayErrorException.class, () -> splittyPayClient.getPayment(1));
    }
}
