package com.teotas.plex.client.api.endpoints;

import com.teotas.plex.client.api.models.PlexResponse;
import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginEndpoints {

    @POST("users/sign_in")
    Call<PlexResponse> login();
}
