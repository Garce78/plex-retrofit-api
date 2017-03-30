package com.teotas.plex.client.api.models.plexobjects;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Subscription {
    private boolean active;
    private String status;
    private String plan;
    private ArrayList<String> features;
}
