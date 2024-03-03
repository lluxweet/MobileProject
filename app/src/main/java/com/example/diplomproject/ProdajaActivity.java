package com.example.diplomproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomproject.adapter.ProdajaAdapter;
import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.callBack.ProdajaReceiveCallBack;
import com.example.diplomproject.server.models.ClientEntity;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.repository.ClientRepository;
import com.example.diplomproject.server.repository.ProdajaRepository;

import java.util.Hashtable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProdajaActivity extends AppCompatActivity {

    Button btnAddProd;
    TextView textClient;
    TextView textProduct;
    TextView textColvo;
    TextView textStatus;
    TextView textStOplata;
    TextView textTypeOpalta;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodaja);

        textClient = findViewById(R.id.textClient);
        textProduct = findViewById(R.id.textProduct);
        textColvo = findViewById(R.id.textColvo);
        textStatus =findViewById(R.id.textStatus);
        textStOplata = findViewById(R.id.textStatusOplata);
        textTypeOpalta = findViewById(R.id.textTypeOplata);

        listView = findViewById(R.id.listView);

        btnAddProd = findViewById(R.id.btnAddProd);
        btnAddProd.setOnClickListener(this::AddApplication);
        getDataFromApi();
   }

    private void getDataFromApi () {

        HTTPBuilder httpBuilder = new HTTPBuilder();
        ProdajaRepository prodajaRepository = httpBuilder.createRepository(ProdajaRepository.class);
        prodajaRepository.getAll().enqueue(new ProdajaReceiveCallBack(listView, this));
    }

    private void AddApplication(View view){
        //навигация
        Intent intent = new Intent(this, activity_addProdaja.class);
        startActivity(intent);
    }

}