package com.example.ilcarroappl.di.auth;

import com.example.ilcarroappl.presentation.auth.presentation.AuthPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {AuthModule.class})
@AuthScope
public interface AuthComponent {
    void inject(AuthPresenter presenter);
}
