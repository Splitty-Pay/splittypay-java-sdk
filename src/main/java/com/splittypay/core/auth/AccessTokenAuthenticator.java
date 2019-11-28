package com.splittypay.core.auth;

import com.squareup.moshi.Moshi;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

import java.io.IOException;

//public class AccessTokenAuthenticator extends
//        BaseRefreshableAuthenticator implements Authenticator {

//    private static final String HEADER_BEARER_ACCESS_VALUE = "Bearer %s";
//    private static final String TOKEN_URL = "%s/oauth/v2/mobile/";
//
//    private final SessionConfiguration sessionConfiguration;
//    private final AccessTokenStorage tokenStorage;
//    private final OAuth2Service auth2Service;
//
//    public AccessTokenAuthenticator(SessionConfiguration sessionConfiguration,
//                                    AccessTokenStorage tokenStorage) {
//        this(sessionConfiguration,
//                tokenStorage,
//                createOAuthService(String.format(TOKEN_URL, sessionConfiguration.getLoginHost())));
//    }
//
//    AccessTokenAuthenticator(SessionConfiguration sessionConfiguration,
//                             AccessTokenStorage tokenStorage,
//                             OAuth2Service auth2Service) {
//        this.sessionConfiguration = sessionConfiguration;
//        this.tokenStorage = tokenStorage;
//        this.auth2Service = auth2Service;
//    }
//
//    @Override
//    public void signRequest(Request.Builder builder) {
//        if(tokenStorage.getAccessToken() != null && tokenStorage.getAccessToken().getToken() !=
//                null) {
//            setBearerToken(builder, tokenStorage.getAccessToken());
//        }
//    }
//
//    @Override
//    public boolean isRefreshable() {
//        return tokenStorage.getAccessToken() != null && tokenStorage.getAccessToken().getRefreshToken() != null;
//    }
//
//    /**
//     * Get SessionConfiguration used for authentication
//     */
//    @Override
//    public SessionConfiguration getSessionConfiguration() {
//        return sessionConfiguration;
//    }
//
//    /**
//     * Get AccessTokenStorage used for authentication
//     */
//    public AccessTokenStorage getTokenStorage() {
//        return tokenStorage;
//    }
//
//    protected synchronized Request doRefresh(Response response) throws IOException {
//        final AccessToken token = tokenStorage.getAccessToken();
//
//        if (signedByOldToken(response, token)) {
//            return resign(response, token);
//        } else {
//            return refreshAndSign(response, token);
//        }
//    }
//
//    Request resign(Response response, AccessToken auth2Token) {
//        Request.Builder builder = response.request().newBuilder();
//        setBearerToken(builder, auth2Token);
//
//        return builder.build();
//    }
//
//    Request refreshAndSign(Response response, AccessToken auth2Token) throws IOException {
//        AccessToken token = refreshToken(auth2Token);
//        return resign(response, token);
//    }
//
//    AccessToken refreshToken(AccessToken auth2Token) throws IOException {
//        AccessToken newToken = auth2Service.refresh(auth2Token.getRefreshToken(),
//                sessionConfiguration.getClientId())
//                .execute().body();
//        tokenStorage.setAccessToken(newToken);
//        return newToken;
//    }
//
//    boolean signedByOldToken(Response response, AccessToken oAuth2Token) {
//        String value = ApiInterceptor.getAuthorizationHeader(response.request());
//
//        String accessToken = createBearerToken(oAuth2Token);
//
//        return value != null && !value.equals(accessToken);
//    }
//
//    void setBearerToken(Request.Builder builder, AccessToken OAuth2Token) {
//        ApiInterceptor.setAuthorizationHeader(builder, createBearerToken(OAuth2Token));
//    }
//
//    String createBearerToken(AccessToken oAuth2Token) {
//        return String.format(HEADER_BEARER_ACCESS_VALUE, oAuth2Token.getToken());
//    }
//
//    static OAuth2Service createOAuthService(String baseUrl) {
//        final Moshi moshi = new Moshi.Builder().add(new OAuthScopesAdapter()).build();
//
//        return new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(MoshiConverterFactory.create(moshi))
//                .build()
//                .create(OAuth2Service.class);
//    }
//}

