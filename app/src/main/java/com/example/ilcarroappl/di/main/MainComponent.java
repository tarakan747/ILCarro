package com.example.ilcarroappl.di.main;

import com.example.ilcarroappl.business.main.MainInteractor;
import com.example.ilcarroappl.presentation.main.presenter.MainFragPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {MainModule.class})
@MainScope
public interface MainComponent {
    void inject(MainFragPresenter presenter);
}
