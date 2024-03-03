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
import com.example.diplomproject.server.models.ProdajaEntity;

import java.util.List;

public class ProdajaAdapter extends ArrayAdapter<ProdajaEntity> {

    public ProdajaAdapter(@NonNull Context context, List<ProdajaEntity> list) {
        super(context, R.layout.row, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row, parent, false);
        ProdajaEntity prodaja = getItem(position);

        TextView client = view.findViewById(R.id.textClient);
        client.setText(String.valueOf(prodaja.getClient().getName()));

        TextView product = view.findViewById(R.id.textProduct);
        product.setText(String.valueOf(prodaja.getProduct().getName()));

        TextView status = view.findViewById(R.id.textStatus);
        status.setText(String.valueOf(prodaja.getStatus().getName()));

        TextView statusPay = view.findViewById(R.id.textStatusOplata);
        statusPay.setText(String.valueOf(prodaja.getStatusPay().getName()));

        TextView typePay = view.findViewById(R.id.textTypeOplata);
        typePay.setText(String.valueOf(prodaja.getTypePay().getName()));

        TextView colvo = view.findViewById(R.id.textColvo);
        colvo.setText(String.valueOf(prodaja.getColichestvo()));

        return view;

    }
}
