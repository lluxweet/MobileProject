package com.example.diplomproject.server.callBack;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.ProductEntity;
import com.example.diplomproject.server.models.StatusEntity;
import com.example.diplomproject.server.repository.StatusPayRepository;
import com.example.diplomproject.server.repository.StatusRepository;

import java.util.Hashtable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusReceiveCallBack implements Callback<List<StatusEntity>> {
    private final ListView listView;
    private final Context context;
    private final List<ProdajaEntity> prodaja;
    public StatusReceiveCallBack (Context context, ListView listView, List<ProdajaEntity> prodaja){
        this.listView = listView;
        this.context = context;
        this.prodaja = prodaja;
    }
    @Override
    public void onResponse(Call<List<StatusEntity>> call, Response<List<StatusEntity>> response) {
        if (response.isSuccessful()){
            Hashtable<Integer, StatusEntity> hashtable = new Hashtable<>();
            List<StatusEntity> status = response.body();
            for (StatusEntity item:status){
                hashtable.put(item.getIdstatus(),item);
            }
            for (ProdajaEntity item:prodaja){
                item.setStatus(hashtable.get(item.getIdStatus()));
            }
            HTTPBuilder httpBuilder = new HTTPBuilder();
            StatusPayRepository productRepository = httpBuilder.createRepository(StatusPayRepository.class);
            productRepository.getAll().enqueue(new StatusPayReceiveCallBack(context,listView, prodaja));
        }
    }

    @Override
    public void onFailure(Call<List<StatusEntity>> call, Throwable t) {

    }
}
