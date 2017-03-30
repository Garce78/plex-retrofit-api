package com.teotas.plex.interceptors;

import com.teotas.plex.PlexAPIConnection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

public class BasicAuthInterceptor implements Interceptor {
    private String encoding;


    public BasicAuthInterceptor(PlexAPIConnection connection){
        String credentials = connection.getUser().getLogin() + ":" + connection.getUser().getPassword();
        encoding = "Basic " + Base64.encodeBase64String(credentials.getBytes());
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Content-Type", "application/json")
                .header(RequiredPlexHeader.PLEX_BASIC_AUTH.header(), encoding)
                .header(RequiredPlexHeader.PLEX_CLIENT_ID.header(), "PLEXRETROFITAPIV1" )
                .header(RequiredPlexHeader.PLEX_PRODUCT.header(),"Plex Retrofit API" )
                .header(RequiredPlexHeader.PLEX_VERSION.header(),"V1")
                .header("Accept", "application/json")
                .method(original.method(), original.body());

        Request updatedRequest = requestBuilder.build();

        return chain.proceed(updatedRequest);
    }
}
