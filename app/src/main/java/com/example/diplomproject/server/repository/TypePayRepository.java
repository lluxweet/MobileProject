package com.example.diplomproject.server.repository;

import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.TypePayEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TypePayRepository {
    @GET("/v1/TypeOplata")
    Call<List<TypePayEntity>> getAll();
}
