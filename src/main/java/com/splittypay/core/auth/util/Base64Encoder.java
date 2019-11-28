package com.splittypay.core.auth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Base64Encoder {

    public static String encodeCredentials(final String clientId, final String clientSecret) {
        byte[] toEncode = clientId.concat(":").concat(clientSecret).getBytes();
        return Base64.getEncoder()
                .encodeToString(toEncode);
    }
}
