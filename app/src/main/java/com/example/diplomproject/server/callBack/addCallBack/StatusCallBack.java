package com.example.diplomproject.server.callBack.addCallBack;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.adapter.StatusAdapter;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.ProductEntity;
import com.example.diplomproject.server.models.StatusEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusCallBack implements Callback<List<StatusEntity>> {
    private final Spinner spinner;
    private final Context context;
    public StatusCallBack(Context context, Spinner spinner){
        this.spinner = spinner;
        this.context = context;
    }
    @Override
    public void onResponse(Call<List<StatusEntity>> call, Response<List<StatusEntity>> response) {
        if (response.isSuccessful()){
            List<StatusEntity> status = response.body();
            ArrayAdapter<StatusEntity> adapter = new StatusAdapter(context, status);
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Call<List<StatusEntity>> call, Throwable t) {

    }
}
