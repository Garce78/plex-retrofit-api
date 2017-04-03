package com.teotas.plex.client.api;

import com.teotas.plex.APICall;
import com.teotas.plex.PlexAPIConnection;
import com.teotas.plex.PlexRetrofitFactory;
import com.teotas.plex.RetrofitClient;
import com.teotas.plex.client.api.endpoints.MediaServerEndpoints;
import com.teotas.plex.client.api.models.plexobjects.User;
import retrofit2.Retrofit;
import java.util.ArrayList;

public class MediaServerAPI {
    private MediaServerEndpoints endpoints;

    public MediaServerAPI(PlexAPIConnection connection){
        Retrofit retrofit = PlexRetrofitFactory.createJsonBuilder()
                .client(RetrofitClient.oAuthClient(connection))
                .build();
        endpoints = retrofit.create(MediaServerEndpoints.class);
    }

    public ArrayList<User> getFriendsList(){
        return new APICall<>(
                endpoints.getAllFriends()
        ).makeRequest().getMediaContainer().getUsers();
    }
}
