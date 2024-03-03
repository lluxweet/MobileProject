package com.example.diplomproject.server.repository;

import com.example.diplomproject.server.models.ProductEntity;
import com.example.diplomproject.server.models.ProductEntity;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductRepository {
    @GET("/v1/Product")
    Call<List<ProductEntity>> getAll();
}
