package com.teotas.plex.client.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teotas.plex.client.api.models.plexobjects.User;
import lombok.Getter;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import retrofit2.http.Path;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class PlexResponse<V> {

    //JSON Elements
    @JsonProperty("user")
    private LoginResponse loginInfo;

    @JsonProperty("MediaContainer")
    private V mediaContainer;
}
