package com.splittypay.core.auth;

import okhttp3.OkHttpClient;

import java.io.IOException;

public interface RefreshTokenClient {


    AccessToken login() throws IOException;
}
