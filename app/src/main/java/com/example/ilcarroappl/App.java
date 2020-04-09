package com.example.ilcarroappl;

import android.app.Application;

import com.example.ilcarroappl.di.app.AppComponent;
import com.example.ilcarroappl.di.app.AppModule;
import com.example.ilcarroappl.di.app.DaggerAppComponent;
import com.example.ilcarroappl.di.auth.AuthComponent;
import com.example.ilcarroappl.di.auth.AuthModule;
import com.example.ilcarroappl.di.main.MainComponent;
import com.example.ilcarroappl.di.main.MainModule;
import com.example.ilcarroappl.di.mainAct.MainActComponent;
import com.example.ilcarroappl.di.mainAct.MainActModule;

public class App extends Application {
    private static App app;
    private AppComponent appComponent;
    private MainComponent mainComponent;
    private AuthComponent authComponent;
    private MainActComponent mainActComponent;

    public App() {
        app = this;
    }

    public static App get() {
        return app;
    }

    @Override
    public void onCreate() {
        /*StoreProvider.getInstance().setContext(this);*/
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        super.onCreate();
    }

    public AuthComponent plus(AuthModule module) {
        if (authComponent == null) {
            authComponent = appComponent.plus(module);
        }
        return authComponent;
    }

    public MainComponent plus(MainModule module) {
        if (mainComponent == null) {
            mainComponent = appComponent.plus(module);
        }
        return mainComponent;
    }

    public MainActComponent plus(MainActModule module) {
        if (mainActComponent == null) {
            mainActComponent = appComponent.plus(module);
        }
        return mainActComponent;
    }

    public void clearMainActComponent() {
        mainActComponent = null; }

    public void clearMainComponent() {
        mainComponent = null;
    }

    public void clearAuthComponent() {
        authComponent = null;
    }
}
