package com.example.diplomproject.server.callBack;

import android.content.Context;
import android.widget.ListView;

import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.StatusPayEntity;
import com.example.diplomproject.server.repository.TypePayRepository;
import java.util.Hashtable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusPayReceiveCallBack implements Callback<List<StatusPayEntity>> {
    private final ListView listView;
    private final Context context;
    private final List<ProdajaEntity> prodaja;
    public StatusPayReceiveCallBack (Context context, ListView listView, List<ProdajaEntity> prodaja){
        this.listView = listView;
        this.context = context;
        this.prodaja = prodaja;
    }
    @Override
    public void onResponse(Call<List<StatusPayEntity>> call, Response<List<StatusPayEntity>> response) {
        if (response.isSuccessful()){
            Hashtable<Integer, StatusPayEntity> hashtable = new Hashtable<>();
            List<StatusPayEntity> status = response.body();
            for (StatusPayEntity item:status){
                hashtable.put(item.getIdStatus(),item);
            }
            for (ProdajaEntity item:prodaja){
                item.setStatusPay(hashtable.get(item.getIdStatusOplata()));
            }
            HTTPBuilder httpBuilder = new HTTPBuilder();
            TypePayRepository productRepository = httpBuilder.createRepository(TypePayRepository.class);
            productRepository.getAll().enqueue(new TypePayReceiveCallBack(context,listView, prodaja));
        }
    }

    @Override
    public void onFailure(Call<List<StatusPayEntity>> call, Throwable t) {

    }
}
