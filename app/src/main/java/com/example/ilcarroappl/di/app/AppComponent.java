package com.example.ilcarroappl.di.app;

import com.example.ilcarroappl.di.main.MainComponent;
import com.example.ilcarroappl.di.main.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    MainComponent plus(MainModule module);
}
