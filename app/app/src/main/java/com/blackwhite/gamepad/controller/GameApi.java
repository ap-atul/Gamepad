package com.blackwhite.gamepad.controller;

import com.blackwhite.gamepad.networking.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GameApi {

    @GET(API.KEY_PRESS)
    Call<String> keyPressed(@Query("key") String key);

    @GET(API.KEY_RELEASE)
    Call<String> keyReleased(@Query("key") String key);

}
