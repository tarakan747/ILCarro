package com.example.ilcarroappl.presentation.auth.presentation;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ilcarroappl.App;
import com.example.ilcarroappl.business.auth.AuthInteractor;
import com.example.ilcarroappl.di.auth.AuthModule;
import com.example.ilcarroappl.presentation.auth.view.AuthView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthView> {
    Disposable disposable;

    @Inject
    AuthInteractor interactor;

    public AuthPresenter() {
        App.get().plus(new AuthModule()).inject(this);
    }

    public void onLogin(String email, String password) {
        getViewState().showProgress();
        disposable = interactor.onLogin(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessLogin, throwable -> {
                    this.onError(throwable.getMessage());
                });
    }

    public void onRegistration(String name, String lastName, String email, String password) {
        getViewState().showProgress();
        disposable = interactor.onRegistration(name, lastName, email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, throwable -> {
                    Log.d("AuthPresenter", "onRegistration: " + throwable.getMessage());
                    this.onError(throwable.getMessage());
                });
    }

    private void onSuccessLogin() {
        getViewState().showNextView();
    }

    private void onSuccess() {
        getViewState().hideProgress();
        getViewState().onClickSwapBtn();
    }

    public void onDialogClicked() {
        getViewState().hideError();
    }

    public void onError(String error) {
        Log.d("MY_TAG", "onError: " + error);
        getViewState().hideProgress();
        getViewState().showError(error);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null) {
            disposable.dispose();
        }
        App.get().clearAuthComponent();
    }
}
