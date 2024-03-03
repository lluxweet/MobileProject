package com.example.diplomproject.server.callBack;


import android.content.Context;
import android.widget.ListView;

import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.models.ClientEntity;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.repository.ProductRepository;

import java.util.Hashtable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientReceiveCallBack implements Callback<List<ClientEntity>> {

    private final ListView listView;
    private final Context context;
    private final List<ProdajaEntity> prodaja;
    public ClientReceiveCallBack(Context context, ListView listView, List<ProdajaEntity> prodaja){
        this.listView = listView;
        this.context = context;
        this.prodaja = prodaja;
    }
    @Override
    public void onResponse(Call<List<ClientEntity>> call, Response<List<ClientEntity>> response) {
        if (response.isSuccessful()){
            Hashtable<Integer, ClientEntity> hashtable = new Hashtable<>();
           List<ClientEntity> client = response.body();
           for (ClientEntity item:client){
               hashtable.put(item.getIdClient(),item);
           }
           for (ProdajaEntity item:prodaja){
               item.setClient(hashtable.get(item.getIdClient()));
           }
            HTTPBuilder httpBuilder = new HTTPBuilder();
            ProductRepository productRepository = httpBuilder.createRepository(ProductRepository.class);
            productRepository.getAll().enqueue(new ProductReceiveCallBack(context,listView, prodaja));
        }
    }

    @Override
    public void onFailure(Call<List<ClientEntity>> call, Throwable t) {

    }
}
