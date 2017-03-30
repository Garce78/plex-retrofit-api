package com.teotas.plex;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlexUser {
    private String login;
    private String password;
}
