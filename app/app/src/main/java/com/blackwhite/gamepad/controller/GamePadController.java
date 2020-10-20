package com.blackwhite.gamepad.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.blackwhite.gamepad.networking.RetroClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamePadController {
    private GameApi gameApi = RetroClient.getClient().create(GameApi.class);


    public void keyPressed(String key){
        Call<String> call = gameApi.keyPressed(key);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if(response.isSuccessful())
                    Log.d("CLASS", response.toString());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

            }
        });
    }

    public void keyReleased(String key){
        Call<String> call = gameApi.keyReleased(key);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if(response.isSuccessful())
                    Log.d("CLASS", response.toString());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

            }
        });
    }
}
