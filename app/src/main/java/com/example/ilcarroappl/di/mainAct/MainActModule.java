package com.example.ilcarroappl.di.mainAct;

import com.example.ilcarroappl.business.mainAct.MainActInteractor;
import com.example.ilcarroappl.business.mainAct.MainActInteractorImpl;
import com.example.ilcarroappl.data.mainAct.MainActRepo;
import com.example.ilcarroappl.data.mainAct.MainActRepoImpl;
import com.example.ilcarroappl.data.provider.store.StoreProvider;
import com.example.ilcarroappl.data.provider.web.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActModule {

    @Provides
    @MainActScope
    MainActRepo provideMainActRepo(Api api, StoreProvider provider) {
        return new MainActRepoImpl(api, provider);
    }

    @Provides
    @MainActScope
    MainActInteractor provideMainActInteractor(MainActRepo repo) {
        return new MainActInteractorImpl(repo);
    }
}
