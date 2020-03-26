package com.example.ilcarroappl.business.auth;


import io.reactivex.Completable;

public interface AuthInteractor {

    Completable onLogin(String email, String password);

    Completable onRegistration(String name, String lastName, String email, String password);
}
