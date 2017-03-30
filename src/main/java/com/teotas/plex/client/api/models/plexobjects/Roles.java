package com.teotas.plex.client.api.models.plexobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Roles {
    @JsonProperty("roles")
    private ArrayList<String> all;
}
