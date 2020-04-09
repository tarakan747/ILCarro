package com.example.ilcarroappl.data.mainAct;


import io.reactivex.Completable;

public interface MainActRepo {
    Completable saveLocation(double lat, double lon);
}
