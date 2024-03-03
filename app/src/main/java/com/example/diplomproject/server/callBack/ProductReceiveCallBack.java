package com.example.diplomproject.server.callBack;

import android.content.Context;
import android.widget.ListView;

import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.ProductEntity;
import com.example.diplomproject.server.repository.StatusRepository;

import java.util.Hashtable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductReceiveCallBack implements Callback<List<ProductEntity>> {
    private final ListView listView;
    private final Context context;
    private final List<ProdajaEntity> prodaja;

    public ProductReceiveCallBack(Context context, ListView listView, List<ProdajaEntity> prodaja){
        this.listView = listView;
        this.context = context;
        this.prodaja = prodaja;
    }
    @Override
    public void onResponse(Call<List<ProductEntity>> call, Response<List<ProductEntity>> response) {
        if (response.isSuccessful()){
            Hashtable<Integer, ProductEntity> hashtable = new Hashtable<>();
            List<ProductEntity> products = response.body();
            for (ProductEntity item:products){
                hashtable.put(item.getIdProduct(),item);
            }
            for (ProdajaEntity item:prodaja){
                item.setProduct(hashtable.get(item.getIdProduct()));
            }
            HTTPBuilder httpBuilder = new HTTPBuilder();
            StatusRepository productRepository = httpBuilder.createRepository(StatusRepository.class);
            productRepository.getAll().enqueue(new StatusReceiveCallBack(context,listView, prodaja));
        }
    }

    @Override
    public void onFailure(Call<List<ProductEntity>> call, Throwable t) {

    }
}
