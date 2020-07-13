package com.example.ilcarroappl.di.auth;

import com.example.ilcarroappl.business.auth.AuthInteractor;
import com.example.ilcarroappl.business.auth.AuthInteractorImpl;
import com.example.ilcarroappl.data.auth.AuthRepo;
import com.example.ilcarroappl.data.auth.AuthRepoImpl;
import com.example.ilcarroappl.data.provider.store.StoreProvider;
import com.example.ilcarroappl.data.provider.web.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {
    @Provides
    @AuthScope
    AuthRepo provideRepo(Api api, StoreProvider store) {
        return new AuthRepoImpl(api, store);
    }

    @Provides
    @AuthScope
    AuthInteractor provideAuthInteractor(AuthRepo repo) {
        return new AuthInteractorImpl(repo);
    }
}
