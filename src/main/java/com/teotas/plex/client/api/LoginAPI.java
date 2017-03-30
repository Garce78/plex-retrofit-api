package com.teotas.plex.client.api;

import com.teotas.plex.APICall;
import com.teotas.plex.PlexAPIConnection;
import com.teotas.plex.PlexRetrofitFactory;
import com.teotas.plex.RetrofitClient;
import com.teotas.plex.client.api.endpoints.LoginEndpoints;
import com.teotas.plex.client.api.models.LoginResponse;
import retrofit2.Retrofit;

public class LoginAPI {
    private LoginEndpoints endpoints;

    public LoginAPI(PlexAPIConnection connection){
        Retrofit retrofit = PlexRetrofitFactory.createJsonBuilder()
                .client(RetrofitClient.basicAuthClient(connection))
                .build();
        endpoints = retrofit.create(LoginEndpoints.class);
    }

    public LoginResponse login(){
        return new APICall<>(
                endpoints.login()
        ).makeRequest().getLoginInfo();
    }
}
