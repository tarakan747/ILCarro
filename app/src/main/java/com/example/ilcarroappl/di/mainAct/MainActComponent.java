package com.example.ilcarroappl.di.mainAct;

import com.example.ilcarroappl.presentation.mainAct.presentation.MainActivityPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {MainActModule.class})
@MainActScope
public interface MainActComponent {
    void inject(MainActivityPresenter presenter);
}
