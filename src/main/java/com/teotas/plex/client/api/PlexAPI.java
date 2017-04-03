package com.teotas.plex.client.api;

import com.teotas.plex.PlexAPIConnection;

public class PlexAPI {
    private PlexAPIConnection connection;
    private LoginAPI loginAPI;
    private MediaServerAPI mediaServerAPI;

    public PlexAPI (PlexAPIConnection connection) {
        this.connection = connection;
    }

    public LoginAPI loginAPI(){
        if(loginAPI == null){
            loginAPI = new LoginAPI(connection);
        }
        return loginAPI;
    }

    public MediaServerAPI mediaServerAPI(){
        if(mediaServerAPI == null){
            mediaServerAPI = new MediaServerAPI(connection);
        }
        return mediaServerAPI;
    }
}
