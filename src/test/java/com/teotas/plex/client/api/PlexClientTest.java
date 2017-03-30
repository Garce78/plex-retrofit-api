package com.teotas.plex.client.api;

import com.teotas.plex.PlexAPIConnection;
import com.teotas.plex.PlexUser;
import com.teotas.plex.client.api.models.LoginResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class PlexClientTest {
    private static PlexUser testUser;
    private static LoginAPI plexAuthAPI;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void beforeClass(){
        testUser = PlexUser.builder()
                .login(System.getenv("LOGIN"))
                .password(System.getenv("PASSWORD")).build();

        PlexAPIConnection testConnection = PlexAPIConnection.builder()
                .user(testUser).build();

        plexAuthAPI = new LoginAPI(testConnection);
    }

    @Test
    public void login(){
        LoginResponse loginInfo = plexAuthAPI.login();
        Assert.assertEquals(loginInfo.getUsername(), System.getenv("LOGIN"));
    }

}
