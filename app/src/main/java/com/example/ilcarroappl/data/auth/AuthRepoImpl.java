package com.example.ilcarroappl.data.auth;


import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.ilcarroappl.data.dto.RegistrationDto;
import com.example.ilcarroappl.data.dto.UserDtoForUser;
import com.example.ilcarroappl.data.provider.store.StoreProvider;
import com.example.ilcarroappl.data.provider.web.Api;

import java.io.IOException;
import java.util.Base64;

import io.reactivex.Completable;
import retrofit2.Response;

public class AuthRepoImpl implements AuthRepo {
    private Api api;
    private StoreProvider storeProvider;
    public UserDtoForUser user;


    public AuthRepoImpl(Api api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Completable onLogin(String email, String password) {
        String token = Base64.getEncoder().encodeToString((email + ":" + password).getBytes());
        storeProvider.saveToken(token);
        Log.d("MY_TAG", "onLogin: " + token);
        return Completable.fromSingle(
                api.login(token).doOnSuccess(this::onLoginSuccess)
        );
    }

    private void onLoginSuccess(Response<UserDtoForUser> response) {
        Log.d("MY_TAG", "onLoginSuccess: " + response.body());
        if (response.isSuccessful()) {
            this.user = response.body();
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            storeProvider.clearToken();
            throw new RuntimeException(response.message());
        } else {
            storeProvider.clearToken();
            throw new RuntimeException("Server error! Call to support!");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Completable onRegistration(String name, String lastName, String email, String password) {
        RegistrationDto dto = new RegistrationDto(name, lastName);
        String token = Base64.getEncoder().encodeToString((email + ":" + password).getBytes());
        storeProvider.saveToken(token);
        return Completable.fromSingle(
                api.registration(token, dto).doOnSuccess(this::onRegistrationSuccess)
        );
    }


    private void onRegistrationSuccess(Response<UserDtoForUser> response) {
        if (response.isSuccessful()) {
            this.user = response.body();
        } else if (response.code() == 400 || response.code() == 403 || response.code() == 409) {
            storeProvider.clearToken();
            throw new RuntimeException(response.message());
        } else {
            storeProvider.clearToken();
            throw new RuntimeException("Server error! Call to support!");
        }
    }

    public UserDtoForUser getUser() {
        return this.user;
    }
}
