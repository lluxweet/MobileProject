package com.example.diplomproject.server.callBack.addCallBack;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.adapter.TypePayAdapter;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.StatusPayEntity;
import com.example.diplomproject.server.models.TypePayEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TypePayCallBack implements Callback<List<TypePayEntity>> {
    private final Spinner spinner;
    private final Context context;
    public TypePayCallBack(Context context, Spinner spinner){
        this.spinner = spinner;
        this.context = context;
    }
    @Override
    public void onResponse(Call<List<TypePayEntity>> call, Response<List<TypePayEntity>> response) {
        if (response.isSuccessful()){
            List<TypePayEntity> typePay = response.body();
            ArrayAdapter<TypePayEntity> adapter = new TypePayAdapter(context,typePay);
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Call<List<TypePayEntity>> call, Throwable t) {

    }
}
