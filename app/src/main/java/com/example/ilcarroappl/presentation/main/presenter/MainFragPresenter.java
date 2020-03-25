package com.example.ilcarroappl.presentation.main.presenter;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ilcarroappl.App;
import com.example.ilcarroappl.business.main.MainInteractor;
import com.example.ilcarroappl.data.provider.web.Api;
import com.example.ilcarroappl.di.main.MainModule;
import com.example.ilcarroappl.presentation.main.view.MainView;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainFragPresenter extends MvpPresenter<MainView> {
    Disposable disposable;

    @Inject
    MainInteractor interactor;

    public MainFragPresenter() {
        App.get().plus(new MainModule()).inject(this);
    }

    public void showViewPager() {

        if (interactor.getList() != null) {
            onSuccessVP();
            return;
        }
        getViewState().showProgressVP();
        disposable = interactor.onViewPager()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessVP, throwable -> {
                    this.onErrorVP(throwable.getMessage());
                });
    }

    private void onSuccessVP() {
        getViewState().hideProgressVP();
        getViewState().showViewPager(interactor.getList());
    }

    private void onErrorVP(String error) {
        getViewState().hideProgressVP();
        getViewState().showError(error);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null) {
            disposable.dispose();
        }
        App.get().clearMainComponent();
    }

}
