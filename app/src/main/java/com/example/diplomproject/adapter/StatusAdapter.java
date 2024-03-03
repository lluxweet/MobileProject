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
import com.example.diplomproject.server.models.ProductEntity;
import com.example.diplomproject.server.models.StatusEntity;

import java.util.List;

public class StatusAdapter extends ArrayAdapter<StatusEntity> {
    public StatusAdapter(@NonNull Context context, List<StatusEntity> list) {
        super(context, R.layout.status_spinner_item, list);
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
        View view = inflater.inflate(R.layout.status_spinner_item, parent, false);
        StatusEntity status = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(status.getName());
        return view;
    }
}
