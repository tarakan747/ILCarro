package com.example.ilcarroappl.data.provider.store;

import android.content.Context;

public class StoreProviderImpl implements StoreProvider {
    private static final String SP_AUTH = "AUTH";
    private static final String TOKEN_KEY = "TOKEN";
    public static final String LOCATION_LAT = "LOCATION_LAT";
    public static final String LOCATION_LON = "LOCATION_LON";
    private Context context;

    public StoreProviderImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean saveToken(String token) {
        return context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
                .edit()
                .putString(TOKEN_KEY, token)
                .commit();
    }

    @Override
    public boolean clearToken() {
        return context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .commit();
    }

    @Override
    public boolean saveLatitude(String lat) {
        return context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
                .edit()
                .putString(LOCATION_LAT, lat)
                .commit();
    }

    @Override
    public boolean saveLongitude(String lon) {
        return context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
                .edit()
                .putString(LOCATION_LON, lon)
                .commit();
    }

    @Override
    public double getLat() {
        return Double.parseDouble(context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
                .getString(LOCATION_LAT, "1.0"));
    }

    @Override
    public double getLon() {
        return Double.parseDouble(context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
                .getString(LOCATION_LON, "1.0"));
    }


    @Override
    public String getToken() {
        return context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
                .getString(TOKEN_KEY, null);
    }
}
