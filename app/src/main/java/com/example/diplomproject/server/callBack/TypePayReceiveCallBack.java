package com.example.diplomproject.server.callBack;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.TypePayEntity;

import java.util.Hashtable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TypePayReceiveCallBack implements Callback<List<TypePayEntity>> {
    private final ListView listView;
    private final Context context;
    private final List<ProdajaEntity> prodaja;
    public TypePayReceiveCallBack (Context context, ListView listView, List<ProdajaEntity> prodaja){
        this.listView = listView;
        this.context = context;
        this.prodaja = prodaja;
    }
    @Override
    public void onResponse(Call<List<TypePayEntity>> call, Response<List<TypePayEntity>> response) {
        if (response.isSuccessful()){
            Hashtable<Integer, TypePayEntity> hashtable = new Hashtable<>();
            List<TypePayEntity> type = response.body();
            for (TypePayEntity item:type){
                hashtable.put(item.getIdTypeOplata(),item);
            }
            for (ProdajaEntity item:prodaja){
                item.setTypePay(hashtable.get(item.getIdTipOplata()));
            }
            ArrayAdapter<ProdajaEntity> adapter = new ProdajaAdapter(context,prodaja);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Call<List<TypePayEntity>> call, Throwable t) {

    }
}
