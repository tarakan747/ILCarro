package com.example.ilcarroappl.data.main;

import android.util.Log;

import com.example.ilcarroappl.StoreProvider;
import com.example.ilcarroappl.data.dto.CarForUsersDto;
import com.example.ilcarroappl.data.provider.web.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class MainRepoImpl implements MainRepo {
    private List<CarForUsersDto> list;
    private Api api;
    //private StoreProvider storeProvider;


    public MainRepoImpl(Api api) {
        this.api = api;
    }

    @Override
    public Completable onSearch(String location, String dateStart, String dateEnd) {
        return null;
    }

    @Override
    public Completable onViewPager() {
        return Completable.fromSingle(
                api.topCar().doOnSuccess(this::doOnGetSuccess).map(response -> {
                    return response.body();
                }));
    }

    private void doOnGetSuccess(Response<List<CarForUsersDto>> response) throws IOException {
        if (response.isSuccessful()) {
            if (response.body() != null) {
                list = response.body();
            }
        } else if (response.code() == 400) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            throw new RuntimeException("Server error! Call to Support");
        }
    }


    public List<CarForUsersDto> getList() {
        return this.list;
    }
}
