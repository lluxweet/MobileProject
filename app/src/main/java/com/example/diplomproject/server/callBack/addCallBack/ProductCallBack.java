package com.example.diplomproject.server.callBack.addCallBack;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.adapter.ProductAdapter;
import com.example.diplomproject.server.models.ClientEntity;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.ProductEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductCallBack implements Callback<List<ProductEntity>> {
    private final Spinner spinner;
    private final Context context;
    public ProductCallBack(Context context, Spinner spinner){
        this.spinner = spinner;
        this.context = context;
    }
    @Override
    public void onResponse(Call<List<ProductEntity>> call, Response<List<ProductEntity>> response) {
        if (response.isSuccessful()){
            List<ProductEntity> product = response.body();
            ArrayAdapter<ProductEntity> adapter = new ProductAdapter(context, product);
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Call<List<ProductEntity>> call, Throwable t) {

    }
}
