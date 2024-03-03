package com.example.diplomproject.server.callBack.addCallBack;

import android.content.Context;
import android.content.Intent;

import com.example.diplomproject.ProdajaActivity;
import com.example.diplomproject.server.models.ProdajaEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdajaCallBack implements Callback<ProdajaEntity> {
    private final Context context;
    public ProdajaCallBack(Context context){
        this.context = context;
    }
    @Override
    public void onResponse(Call<ProdajaEntity> call, Response<ProdajaEntity> response) {
        if (response.isSuccessful()){
            Intent intent = new Intent(context, ProdajaActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public void onFailure(Call<ProdajaEntity> call, Throwable t) {

    }
}
