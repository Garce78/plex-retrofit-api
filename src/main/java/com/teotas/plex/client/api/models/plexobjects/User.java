package com.teotas.plex.client.api.models.plexobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private long id;
    private String title;
    private String username;
    private String email;
    private String recommendationsPlaylistId;
    @JsonProperty("thumb")
    private String thumbnail;
    @JsonProperty("Server")
    private Server server;

}
