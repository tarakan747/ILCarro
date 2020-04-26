package com.example.ilcarroappl.business.mainAct;

import android.location.Location;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;

public interface MainActInteractor {
    Completable onSaveLocation(Location location);

    boolean isLogin();

    boolean logOut();
}
