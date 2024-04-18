package com.example.mvvm_java_android.utils;

import com.example.mvvm_java_android.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MainApi {


    @POST("/v1/user/")
    Call<User> createUser(@Body User user);

    @POST("v1/login/")
    Call<User> login(@Body User user);



}
