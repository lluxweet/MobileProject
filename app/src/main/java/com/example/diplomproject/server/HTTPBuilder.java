package com.example.diplomproject.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HTTPBuilder {
    private final Retrofit retrofit;

    public HTTPBuilder(){//конструктор :0
        retrofit = new Retrofit.Builder()
                .baseUrl("http://89.23.112.187")
                .addConverterFactory(GsonConverterFactory.create()).build();

    }
    public <Trepository> Trepository createRepository(Class<Trepository> repository){
        return retrofit.create(repository);
    }
}
