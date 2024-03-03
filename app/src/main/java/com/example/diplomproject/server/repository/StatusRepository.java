package com.example.diplomproject.server.repository;

import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.StatusEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StatusRepository {
    @GET("/v1/Status")
    Call<List<StatusEntity>> getAll();
}
