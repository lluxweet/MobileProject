package com.example.diplomproject.server.repository;

import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.ProdajaEntity;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ProdajaRepository {
    @GET("/v1/Prodaja")
    Call<List<ProdajaEntity>> getAll();

    @POST("/v1/Prodaja")
    Call<ProdajaEntity> create(@Body() ProdajaEntity prodaja);
}
