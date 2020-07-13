package com.example.ilcarroappl.data.auth;

import io.reactivex.Completable;

public interface AuthRepo {

    Completable onLogin(String email, String password);
    Completable onRegistration(String name,String lastName,String email, String password);
}
