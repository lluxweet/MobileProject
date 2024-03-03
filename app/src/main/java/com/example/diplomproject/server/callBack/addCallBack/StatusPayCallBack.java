package com.example.diplomproject.server.callBack.addCallBack;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.adapter.StatusPayAdapter;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.StatusEntity;
import com.example.diplomproject.server.models.StatusPayEntity;
import com.example.diplomproject.server.models.TypePayEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusPayCallBack implements Callback<List<StatusPayEntity>>{
    private final Spinner spinner;
    private final Context context;
    public StatusPayCallBack(Context context, Spinner spinner){
        this.spinner = spinner;
        this.context = context;
    }
    @Override
    public void onResponse(Call<List<StatusPayEntity>> call, Response<List<StatusPayEntity>> response) {
        if (response.isSuccessful()){
            List<StatusPayEntity> statusPay = response.body();
            ArrayAdapter<StatusPayEntity> adapter = new StatusPayAdapter(context, statusPay);
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Call<List<StatusPayEntity>> call, Throwable t) {

    }
}
