package com.teotas.plex.interceptors;

public enum RequiredPlexHeader {
    PLEX_BASIC_AUTH("Authorization"),
    PLEX_TOKEN("X-Plex-Token"),
    PLEX_CLIENT_ID("X-Plex-Client-Identifier"),
    PLEX_PRODUCT("X-Plex-Product"),
    PLEX_VERSION("X-Plex-Version");

    private String header;

    RequiredPlexHeader(String header){
        this.header = header;
    }

    public String header(){
        return header;
    }

}
