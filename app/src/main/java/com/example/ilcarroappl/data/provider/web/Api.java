package com.example.ilcarroappl.data.provider.web;

import com.example.ilcarroappl.data.dto.CarForUsersDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

public interface Api {

    @GET("car/best")
    Single<Response<List<CarForUsersDto>>> topCar();
}
