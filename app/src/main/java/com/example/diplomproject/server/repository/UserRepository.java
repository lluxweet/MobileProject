package com.example.diplomproject.server.repository;

import com.example.diplomproject.server.models.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserRepository {
    @GET("/v1/User")
    Call<List<UserEntity>> getAll();
    @POST("/login")
    Call<UserEntity> login(@Body UserEntity user);
}
