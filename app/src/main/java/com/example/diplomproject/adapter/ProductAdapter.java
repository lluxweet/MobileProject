package com.example.diplomproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.diplomproject.R;
import com.example.diplomproject.server.models.ClientEntity;
import com.example.diplomproject.server.models.ProductEntity;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductEntity> {
    public ProductAdapter(@NonNull Context context, List<ProductEntity> list) {
        super(context, R.layout.product_spinner_item, list);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getOnTemplate(position, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getOnTemplate(position, parent);
    }
    private View getOnTemplate(int position, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.product_spinner_item, parent, false);
        ProductEntity product = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(product.getName());
        return view;
    }
}
