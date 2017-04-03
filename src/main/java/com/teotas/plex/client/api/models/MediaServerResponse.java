package com.teotas.plex.client.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teotas.plex.client.api.models.plexobjects.User;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaServerResponse {
    String identifier;
    int totalSize;
    int size;
    String machineIdentifier;
    String friendlyName;
    @JsonProperty("User")
    ArrayList<User> users;
}
