package com.example.ilcarroappl.data.mainAct;

import com.example.ilcarroappl.data.provider.store.StoreProvider;
import com.example.ilcarroappl.data.provider.web.Api;

import io.reactivex.Completable;

public class MainActRepoImpl implements MainActRepo {

    private Api api;
    private StoreProvider storeProvider;

    public MainActRepoImpl(Api api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public Completable saveLocation(double lat, double lon) {
        if (storeProvider.saveLongitude("" + lon) && storeProvider.saveLatitude("" + lat)) {
            return Completable.complete();
        }
        return null;
    }

    @Override
    public boolean isLogin() {
        if (storeProvider.getToken() != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean logOut() {
        return storeProvider.clearToken();
    }
}
