package com.splittypay.core.auth;

import com.splittypay.model.SplittyPayConfig;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public interface Authenticator {

    /**
     * Indicates whether this authenticator can be refreshed.
     *
     * @return
     */
    boolean isRefreshable();

    /**
     * Add authentication header required to the request.
     *
     * @param builder
     */
    void signRequest(Request.Builder builder);

    /**
     * Refresh authentication token that is used to {@link #signRequest(Request.Builder)}
     *
     * @param response
     * @throws IOException
     */
    Request refresh(Response response) throws IOException;


    SplittyPayConfig getSessionConfiguration();
}
