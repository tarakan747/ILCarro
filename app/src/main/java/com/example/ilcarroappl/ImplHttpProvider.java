package com.example.ilcarroappl;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.ilcarroappl.dto.CarDto;
import com.example.ilcarroappl.dto.CarListDto;
import com.example.ilcarroappl.dto.ErrorDto;
import com.example.ilcarroappl.dto.RegistrationDto;
import com.example.ilcarroappl.dto.UserBaseDto;
import com.example.ilcarroappl.dto.UserCarDto;
import com.example.ilcarroappl.dto.UserDto;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ImplHttpProvider implements HttpProvider{
    public static final String BASE_URL = "https://java-3-ilcarro-team-b.herokuapp.com";
    public static final ImplHttpProvider ourInstance = new ImplHttpProvider();
    private Gson gson;
    private MediaType JSON;
    private OkHttpClient client;
    private StoreProvider storeProvider;

    public static ImplHttpProvider getInstance(){return ourInstance;}

    private ImplHttpProvider(){
        gson = new Gson();
        JSON = MediaType.get("application/json; charset=utf-8");
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public UserDto registration(String email, String password, String firstName, String lastName) throws IOException {
        RegistrationDto registrationDto = new RegistrationDto(firstName, lastName);
        String json = gson.toJson(registrationDto);

        RequestBody requestBody = RequestBody.create(JSON, json);

        String token = Base64.getEncoder().encodeToString((email + ":" + password).getBytes());

        Log.d("MY_TAG", "registration: " + token + " " + firstName + " " + lastName);
        Request request = new Request.Builder()
                .url(BASE_URL + "/registration")
                .post(requestBody)
                .addHeader("Authorization", token)
                .build();
        Response response = client.newCall(request).execute();
        Log.d("MY_TAG", "registration: code" + response.code());
        if (response.isSuccessful()){
            json = response.body().string();
            UserDto user = gson.fromJson(json, UserDto.class);
            return user;
        }else if (response.code() == 400 || response.code() == 403 || response.code() == 409){
            json = response.body().string();
            ErrorDto error = gson.fromJson(json, ErrorDto.class);
            throw new RuntimeException(error.getMessage());
        }else {
            json = response.body().string();
            Log.d("MY_TAG", "registration: " + json);
            throw new RuntimeException("Server error! Call to support!");
        }
    }

    public List<CarDto> topCar() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/car/best")
                .get()
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            String json = response.body().string();
            CarListDto dto = gson.fromJson(json, CarListDto.class);
            return dto.getCars();
        } else if(response.code() == 404){
            String json = response.body().string();
            ErrorDto errorDto = gson.fromJson(json, ErrorDto.class);
            throw new RuntimeException(errorDto.getMessage());
        }else {
            String json = response.body().string();
            Log.d("MY_TAG", "topCar: " + json);
            throw new RuntimeException("Server error! Call to support!");
        }
    }

    public CarDto addNewCar(String token, UserCarDto carDto) throws IOException {
        String json = gson.toJson(carDto);

        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(BASE_URL + "/car")
                .post(requestBody)
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            json = response.body().string();
            CarDto dto = gson.fromJson(json, CarDto.class);
            return dto;
        }else if (response.code() == 400 || response.code() == 401){
            json = response.body().string();
            ErrorDto errorDto = gson.fromJson(json, ErrorDto.class);
            throw new RuntimeException(errorDto.getMessage());
        }else {
            json = response.body().string();
            Log.d("MY_TAG", "addNewCar: " + json);
            throw new RuntimeException("Server error! Call to support!");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String login(String email, String password) throws IOException {
        String token = Base64.getEncoder().encodeToString((email + ":" + password).getBytes());
        Request request = new Request.Builder()
                .url(BASE_URL + "/user/login")
                .get()
                .addHeader("Authorization", token)
                .build();
        Log.d("MY_TAG", "login: " + token);
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            String json = response.body().string();
            UserDto user = gson.fromJson(json, UserDto.class);
            return "Login ok!";
        }else if (response.code() == 400 || response.code() == 401 || response.code() == 404){
            String json = response.body().string();
            ErrorDto error = gson.fromJson(json, ErrorDto.class);
            throw new RuntimeException(error.getMessage());
        }else {
            String json = response.body().string();
            Log.d("MY_TAG", "registration: " + json);
            throw new RuntimeException("Server error! Call to support!");
        }
    }

    public String updateUser(String token, UserBaseDto user) throws IOException {
        String json = gson.toJson(user);
        RequestBody requestBody = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(BASE_URL + "/user")
                .addHeader("Authorization", token)
                .put(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            return "Update ok!";
        }else if (response.code() == 400 || response.code() == 401 || response.code() == 404){
            json = response.body().string();
            ErrorDto errorDto = gson.fromJson(json, ErrorDto.class);
            throw new RuntimeException(errorDto.getMessage());
        }else {
            json = response.body().string();
            Log.d("MY_TAG", "updatePassword: " + json);
            throw new RuntimeException("Server error! Call to support.");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String updatePassword(String token, String newPassword, UserBaseDto user) throws IOException {
        String json = gson.toJson(user);
        RequestBody requestBody = RequestBody.create(JSON, json);

        String tokenNewPas = Base64.getEncoder().encodeToString((newPassword).getBytes());

        Request request = new Request.Builder()
                .url(BASE_URL + "/user")
                .put(requestBody)
                .addHeader("Authorization", token)
                .addHeader("X-New-Password", tokenNewPas)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            return "Password is changed.";
        }else if (response.code() == 400 || response.code() == 401 || response.code() == 404){
            json = response.body().string();
            ErrorDto errorDto = gson.fromJson(json, ErrorDto.class);
            throw new RuntimeException(errorDto.getMessage());
        }else {
            json = response.body().string();
            Log.d("MY_TAG", "updatePassword: " + json);
            throw new RuntimeException("Server error! Call to support");
        }
    }

    public String deleteUser(String token) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/user")
                .delete()
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            return "User delete.";
        }else if (response.code() == 400 || response.code() == 401 || response.code() == 404){
            String json = response.body().string();
            ErrorDto errorDto = gson.fromJson(json, ErrorDto.class);
            throw new RuntimeException(errorDto.getMessage());
        }else {
            String json = response.body().string();
            Log.d("MY_TAG", "deleteUser: " + json);
            throw new RuntimeException("Server error! Call to support");
        }
    }
}
