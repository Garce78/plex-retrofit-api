package com.teotas.plex;

import retrofit2.Retrofit;

public class PlexRetrofitFactory {
    public static Retrofit.Builder createJsonBuilder() {
        return initializePlexConnection(RetrofitFactory.createJsonBuilder());
    }

    private static Retrofit.Builder initializePlexConnection(Retrofit.Builder builder) {
        return builder.baseUrl("https://plex.tv/");
    }
}
