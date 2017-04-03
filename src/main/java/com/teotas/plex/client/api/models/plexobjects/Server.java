package com.teotas.plex.client.api.models.plexobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.simpleframework.xml.Attribute;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class Server {
    private long id;
    private long serverId;
    private String machineIdentifier;
    private String name;
    private long lastSeenAt;
    private byte numLibraries;
    private byte owned;
}
