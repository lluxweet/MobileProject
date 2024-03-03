package com.example.diplomproject.server.repository;

import com.example.diplomproject.server.models.ClientEntity;
import com.example.diplomproject.server.models.ProdajaEntity;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientRepository {
    @GET("/v1/Client")
    Call<List<ClientEntity>> getAll();
}
