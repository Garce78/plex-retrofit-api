package com.teotas.plex.client.api;

import com.teotas.plex.PlexAPIConnection;
import com.teotas.plex.PlexUser;
import com.teotas.plex.client.api.models.LoginResponse;
import com.teotas.plex.client.api.models.plexobjects.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;


public class PlexClientTest {
    private static PlexUser testUser;
    private static PlexAPI plex;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void beforeClass(){
        testUser = PlexUser.builder()
                .login(System.getenv("LOGIN"))
                .password(System.getenv("PASSWORD")).build();

        PlexAPIConnection testConnection = PlexAPIConnection.builder()
                .user(testUser).build();

        plex = new PlexAPI(testConnection);
    }

    @Test
    public void login(){
        LoginResponse loginInfo = plex.loginAPI().login();
        Assert.assertEquals(loginInfo.getUsername(), System.getenv("LOGIN"));
    }

    @Test
    public void getAllFriends(){
        ArrayList<User> friends = plex.mediaServerAPI().getFriendsList();
        Assert.assertTrue(!friends.isEmpty());
    }

}
