package com.example.diplomproject.server.repository;

import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.StatusPayEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StatusPayRepository {
    @GET("/v1/StatusOplata")
    Call<List<StatusPayEntity>> getAll();
}
