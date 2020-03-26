package com.example.ilcarroappl.data.provider.store;

public interface StoreProvider {
    boolean saveToken(String token);
    boolean clearToken();
    String getToken();
}
