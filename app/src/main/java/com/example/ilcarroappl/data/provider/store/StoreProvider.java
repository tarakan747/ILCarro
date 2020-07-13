package com.example.ilcarroappl.data.provider.store;

import java.util.List;

public interface StoreProvider {
    boolean saveToken(String token);

    boolean clearToken();

    boolean saveLatitude(String lat);

    boolean saveLongitude(String lon);

    double getLat();

    double getLon();

    String getToken();
}
