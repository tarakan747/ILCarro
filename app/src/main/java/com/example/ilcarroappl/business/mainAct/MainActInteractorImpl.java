package com.example.ilcarroappl.business.mainAct;

import android.location.Location;

import com.example.ilcarroappl.data.mainAct.MainActRepo;

import io.reactivex.Completable;

public class MainActInteractorImpl implements MainActInteractor {
    MainActRepo repo;

    public MainActInteractorImpl(MainActRepo repo) {
        this.repo = repo;
    }

    @Override
    public Completable onSaveLocation(Location location) {
        try {
            isLocationValid(location);
            return repo.saveLocation(location.getLatitude(), location.getLongitude());
        } catch (Throwable throwable) {
            return Completable.error(throwable);
        }
    }

    private void isLocationValid(Location location) {
        if (location == null) {
            throw new LocationValid("Check internet");
        }
    }
}
