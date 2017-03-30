package com.teotas.plex.client.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teotas.plex.client.api.models.plexobjects.Roles;
import com.teotas.plex.client.api.models.plexobjects.Subscription;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class LoginResponse {
    private int id;
    private String uuid;
    private String email;
    @JsonProperty("joined_at")
    private String joinedAt;
    private String username;
    private String title;
    private String thumb;
    private String authToken;
    @JsonProperty("authentication_token")
    private String authenticationToken;
    private Subscription subscription;
    private Roles roles;
    private ArrayList<String> entitlements;
    private String confirmedAt;
    private int forumId;
    private boolean rememberMe;
}
