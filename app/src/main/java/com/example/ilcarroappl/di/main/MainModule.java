package com.example.ilcarroappl.di.main;

import com.example.ilcarroappl.business.main.MainInteractor;
import com.example.ilcarroappl.business.main.MainInteractorImpl;
import com.example.ilcarroappl.data.main.MainRepo;
import com.example.ilcarroappl.data.main.MainRepoImpl;
import com.example.ilcarroappl.data.provider.web.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    @MainScope
    MainRepo provideMainRepo(Api api) {
        return new MainRepoImpl(api);
    }

    @Provides
    @MainScope
    MainInteractor provideMainIteractor(MainRepo repo) {
        return new MainInteractorImpl(repo);
    }
}
