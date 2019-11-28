package com.splittypay.core.auth.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base64EncoderTest {

    @Test
    void encodeCredentials() {
        Assertions.assertEquals(Base64Encoder.encodeCredentials("Q4EKnaCz", "elffTNejO5EZxR6PI2eUE5IC"), "UTRFS25hQ3o6ZWxmZlROZWpPNUVaeFI2UEkyZVVFNUlD");
    }
}
