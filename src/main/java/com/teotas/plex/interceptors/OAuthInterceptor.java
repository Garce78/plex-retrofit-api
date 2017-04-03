package com.teotas.plex.interceptors;

import com.teotas.plex.PlexAPIConnection;
import com.teotas.plex.client.api.LoginAPI;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@Slf4j
public class OAuthInterceptor implements Interceptor {
    private PlexAPIConnection connection;

    public OAuthInterceptor(PlexAPIConnection connection){
        this.connection = connection;
    }

    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Content-Type", "application/json")
                .header(RequiredPlexHeader.PLEX_TOKEN.header(), getAuthToken())
                .header(RequiredPlexHeader.PLEX_CLIENT_ID.header(), "PLEXRETROFITAPIV1" )
                .header(RequiredPlexHeader.PLEX_PRODUCT.header(),"Plex Retrofit API" )
                .header(RequiredPlexHeader.PLEX_VERSION.header(),"V1")
                .header("Accept", "application/json")
                .method(original.method(), original.body());

        Request updatedRequest = requestBuilder.build();

        return chain.proceed(updatedRequest);
    }

    private String getAuthToken(){
        //TODO implement session check if necessary
        if(connection.getAuthToken() == null){
            connection.setAuthToken(new LoginAPI(connection).login().getAuthToken());
        }
        return connection.getAuthToken();
    }
}
