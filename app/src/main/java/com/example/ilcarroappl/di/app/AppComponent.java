package com.example.ilcarroappl.di.app;

import com.example.ilcarroappl.di.auth.AuthComponent;
import com.example.ilcarroappl.di.auth.AuthModule;
import com.example.ilcarroappl.di.main.MainComponent;
import com.example.ilcarroappl.di.main.MainModule;
import com.example.ilcarroappl.di.mainAct.MainActComponent;
import com.example.ilcarroappl.di.mainAct.MainActModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    MainComponent plus(MainModule module);

    AuthComponent plus(AuthModule module);

    MainActComponent plus(MainActModule module);
}
