package com.example.mvvm_java_android;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainApi {


    @POST("/v1/user/")
    Call<User> createUser(@Body User user);

    @POST("v1/login/")
    Call<User> login(@Body User user);



}
