package com.splittypay.core.auth;

import com.splittypay.model.SplittyPayConfig;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public interface Authenticator {

    boolean isRefreshable();

    void signRequest(Request.Builder builder);

    Request refresh(Response response) throws IOException;

    SplittyPayConfig getSessionConfiguration();
}
