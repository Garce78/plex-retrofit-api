package com.teotas.plex;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlexAPIConnection extends RetrofitFactory {
    private PlexUser user;
    private String authToken;
}
