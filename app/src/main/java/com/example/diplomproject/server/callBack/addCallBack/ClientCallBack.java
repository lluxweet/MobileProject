package com.example.diplomproject.server.callBack.addCallBack;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.diplomproject.adapter.ClientAdapter;
import com.example.diplomproject.server.models.ClientEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientCallBack implements Callback<List<ClientEntity>> {
    private final Spinner spinner;
    private final Context context;
    public ClientCallBack(Context context, Spinner spinner){
        this.spinner = spinner;
        this.context = context;
    }
    @Override
    public void onResponse(Call<List<ClientEntity>> call, Response<List<ClientEntity>> response) {
        if (response.isSuccessful()){
            List<ClientEntity> client = response.body();
            ArrayAdapter<ClientEntity> adapter = new ClientAdapter(context, client);
            spinner.setAdapter(adapter);

        }

    }

    @Override
    public void onFailure(Call<List<ClientEntity>> call, Throwable t) {

    }
}
