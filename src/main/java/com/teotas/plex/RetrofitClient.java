package com.teotas.plex;

import com.google.common.base.Preconditions;
import com.teotas.plex.interceptors.BasicAuthInterceptor;
import com.teotas.plex.interceptors.OAuthInterceptor;
import com.teotas.plex.interceptors.ResponseInterceptor;
import lombok.Getter;
import okhttp3.OkHttpClient;

public class RetrofitClient {
    @Getter
    private static String defaultLogLevel = "NONE";

    public static OkHttpClient basicAuthClient(PlexAPIConnection connection){
        return getBasicAuthClientBuilder(connection).build();
    }

    private static OkHttpClient.Builder getBasicAuthClientBuilder(PlexAPIConnection connection){
        PlexUser user = connection.getUser();
        Preconditions.checkNotNull(user, user.getLogin(), user.getPassword());

        BasicAuthInterceptor basicAuthInterceptor = new BasicAuthInterceptor(connection);
        ResponseInterceptor responseInterceptor = new ResponseInterceptor(connection);
        return new OkHttpClient.Builder()
                .addInterceptor(basicAuthInterceptor)
                .addInterceptor(responseInterceptor);
    }

    public static OkHttpClient oAuthClient(PlexAPIConnection connection){
        return getOAuthClientBuilder(connection).build();
    }

    private static OkHttpClient.Builder getOAuthClientBuilder(PlexAPIConnection connection){
        PlexUser user = connection.getUser();
        Preconditions.checkNotNull(user, user.getLogin(), user.getPassword());

        OAuthInterceptor oAuthInterceptor = new OAuthInterceptor(connection);
        ResponseInterceptor responseInterceptor = new ResponseInterceptor(connection);
        return new OkHttpClient.Builder()
                .addInterceptor(oAuthInterceptor)
                .addInterceptor(responseInterceptor);

    }
}
