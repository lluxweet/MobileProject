package com.example.diplomproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.callBack.addCallBack.ClientCallBack;
import com.example.diplomproject.server.callBack.addCallBack.ProdajaCallBack;
import com.example.diplomproject.server.callBack.addCallBack.ProductCallBack;
import com.example.diplomproject.server.callBack.addCallBack.StatusCallBack;
import com.example.diplomproject.server.callBack.addCallBack.StatusPayCallBack;
import com.example.diplomproject.server.callBack.addCallBack.TypePayCallBack;
import com.example.diplomproject.server.models.ClientEntity;
import com.example.diplomproject.server.models.ProdajaEntity;
import com.example.diplomproject.server.models.ProductEntity;
import com.example.diplomproject.server.models.StatusEntity;
import com.example.diplomproject.server.models.StatusPayEntity;
import com.example.diplomproject.server.models.TypePayEntity;
import com.example.diplomproject.server.repository.ClientRepository;
import com.example.diplomproject.server.repository.ProdajaRepository;
import com.example.diplomproject.server.repository.ProductRepository;
import com.example.diplomproject.server.repository.StatusPayRepository;
import com.example.diplomproject.server.repository.StatusRepository;
import com.example.diplomproject.server.repository.TypePayRepository;

public class activity_addProdaja extends AppCompatActivity {

    Spinner cmbClient;
    Spinner cmbProduct;
    EditText txbColvo;
    Spinner cmbStatus;
    Spinner cmbStatusPay;
    Spinner cmbTypePay;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prodaja);

        cmbClient = findViewById(R.id.cmbClient);
        cmbProduct= findViewById(R.id.cmbProduct);
        txbColvo = findViewById(R.id.txbColvo);
        cmbStatus = findViewById(R.id.cmbStatus);
        cmbStatusPay = findViewById(R.id.cmbStatusPay);
        cmbTypePay = findViewById(R.id.cmbTypePay);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this::trySave);
        getDataFromApi();

    }
    private void getDataFromApi () {//читаем данные с апишечки
        HTTPBuilder httpBuilder = new HTTPBuilder();

        ClientRepository clientRepository = httpBuilder.createRepository(ClientRepository.class);
        clientRepository.getAll().enqueue(new ClientCallBack(this,cmbClient));

        ProductRepository productRepository = httpBuilder.createRepository(ProductRepository.class);
        productRepository.getAll().enqueue(new ProductCallBack(this,cmbProduct));

        StatusRepository statusRepository = httpBuilder.createRepository(StatusRepository.class);
        statusRepository.getAll().enqueue(new StatusCallBack(this,cmbStatus));

        StatusPayRepository statusPayRepository = httpBuilder.createRepository(StatusPayRepository.class);
        statusPayRepository.getAll().enqueue(new StatusPayCallBack(this, cmbStatusPay));

        TypePayRepository typePayRepository = httpBuilder.createRepository(TypePayRepository.class);
        typePayRepository.getAll().enqueue(new TypePayCallBack(this, cmbTypePay));
    }

    private void trySave(View view){//сохраняем данные через кнопочку
        try {
                ProdajaEntity prodaja = validate();
                HTTPBuilder httpBuilder = new HTTPBuilder();
            ProdajaRepository prodajaRepository = httpBuilder.createRepository(ProdajaRepository.class);
            prodajaRepository.create(prodaja).enqueue(new ProdajaCallBack(this));
        }catch (Exception ex){

        }
    }

    private ProdajaEntity validate() throws Exception {//проверка данных
        ClientEntity client = (ClientEntity) cmbClient.getSelectedItem();
        ProductEntity product= (ProductEntity) cmbProduct.getSelectedItem();
        StatusEntity status = (StatusEntity) cmbStatus.getSelectedItem();
        StatusPayEntity statusPay = (StatusPayEntity) cmbStatusPay.getSelectedItem();
        TypePayEntity typePay = (TypePayEntity) cmbTypePay.getSelectedItem();
        String count = txbColvo.getText().toString();
        if (client == null || product == null || status == null || statusPay==null || typePay==null || count.isEmpty()){
            throw new Exception();
        }
        ProdajaEntity prodaja = new ProdajaEntity();
        prodaja.setColichestvo(Integer.parseInt(count));
        prodaja.setIdClient(client.getIdClient());
        prodaja.setIdProduct(product.getIdProduct());
        prodaja.setIdStatus(status.getIdstatus());
        prodaja.setIdStatusOplata(statusPay.getIdStatus());
        prodaja.setIdTipOplata(typePay.getIdTypeOplata());
        return prodaja;
    }
}