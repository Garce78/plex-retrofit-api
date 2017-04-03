package com.teotas.plex.client.api.endpoints;

import com.teotas.plex.client.api.models.MediaServerResponse;
import com.teotas.plex.client.api.models.PlexResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MediaServerEndpoints {

    @GET("pms/friends/all")
    Call<PlexResponse<MediaServerResponse>> getAllFriends();

    @GET("pms/friends/requests")
    Call<PlexResponse<MediaServerResponse>> getPendingFriends();

    @GET("pms/playlists/queue/unwatched")
    Call<PlexResponse<MediaServerResponse>> getUnwatchedPlaylist();

    @GET("pms/playlists/recommendations/unwatched")
    Call<PlexResponse<MediaServerResponse>> getRecommendedUnwatchedPlaylist();

}
