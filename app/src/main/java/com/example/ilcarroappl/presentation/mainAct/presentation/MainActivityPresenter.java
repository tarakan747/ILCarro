package com.example.ilcarroappl.presentation.mainAct.presentation;

import android.Manifest;
import android.app.Activity;
import android.location.Location;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ilcarroappl.App;
import com.example.ilcarroappl.business.mainAct.MainActInteractor;
import com.example.ilcarroappl.di.mainAct.MainActModule;
import com.example.ilcarroappl.presentation.mainAct.view.MainActView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActView> {
    Disposable disposable;

    @Inject
    MainActInteractor interactor;

    public MainActivityPresenter() {
        App.get().plus(new MainActModule()).inject(this);
    }

    public void onSaveLocation(Location location) {
        disposable = interactor.onSaveLocation(location)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, throwable -> {
                    onError(throwable.getMessage());
                });
    }

    private void onError(String error) {
        getViewState().showError(error);
    }

    private void onSuccess() {
        return;
    }

    public void check(Activity act) {
        Dexter.withActivity(act)
                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION
                        , Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report != null) {
                            if (report.areAllPermissionsGranted()) {
                                getViewState().getLocationUpd();
                            } else {
                                getViewState().onDestroy();
                            }
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).withErrorListener(error -> Log.d("MY_TAGg", "check: " + error))
                .check();
    }


    public void onDestroy() {
        if (disposable != null) {
            disposable.dispose();
        }
        App.get().clearMainActComponent();
    }

}
