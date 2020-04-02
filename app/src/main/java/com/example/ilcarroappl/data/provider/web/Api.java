package com.example.ilcarroappl.data.provider.web;

import com.example.ilcarroappl.data.dto.CarForUsersDto;
import com.example.ilcarroappl.data.dto.RegistrationDto;
import com.example.ilcarroappl.data.dto.UserDtoForUser;

import java.util.List;


import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @GET("car/best")
    Single<Response<List<CarForUsersDto>>> topCar();

    @POST("/registration")
    Single<Response<UserDtoForUser>> registration(@Header("Authorization") String token,
                                                  @Body RegistrationDto person);

    @GET("/user/login")
    Single<Response<UserDtoForUser>> login(@Header("Authorization") String token);
}
