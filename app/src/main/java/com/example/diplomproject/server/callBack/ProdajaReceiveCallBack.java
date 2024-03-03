package com.example.diplomproject.server.callBack;


import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.repository.ClientRepository;
import com.example.diplomproject.server.repository.ProdajaRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdajaReceiveCallBack implements Callback<List<ProdajaEntity>> {
    private final ListView listView;
    private final Context context;

    public ProdajaReceiveCallBack(ListView listView, Context context){
        this.listView = listView;
        this.context = context;
    }
    @Override
    public void onResponse(Call<List<ProdajaEntity>> call, Response<List<ProdajaEntity>> response) {
        if (response.isSuccessful()){
            List<ProdajaEntity> prodaja = response.body();
            HTTPBuilder httpBuilder = new HTTPBuilder();
            ClientRepository prodajaRepository = httpBuilder.createRepository(ClientRepository.class);
            prodajaRepository.getAll().enqueue(new ClientReceiveCallBack(context,listView, prodaja));
        }
    }

    @Override
    public void onFailure(Call<List<ProdajaEntity>> call, Throwable t) {

    }
}
