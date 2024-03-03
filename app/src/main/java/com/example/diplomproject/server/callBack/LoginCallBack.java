package com.example.diplomproject.server.callBack;


import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;

import com.example.diplomproject.ProdajaActivity;
import com.example.diplomproject.server.models.UserEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCallBack implements Callback<UserEntity> {

    @Override
    public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
        if (response.isSuccessful()){
            Intent intent = new Intent(context, ProdajaActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public void onFailure(Call<UserEntity> call, Throwable t) {

    }
    Context context;
    public LoginCallBack(Context context){
        this.context = context;
    }
}
