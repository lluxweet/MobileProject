package com.example.diplomproject;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.diplomproject.server.HTTPBuilder;
import com.example.diplomproject.server.callBack.LoginCallBack;
import com.example.diplomproject.server.models.UserEntity;
import com.example.diplomproject.server.repository.UserRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText txbLogin;
    EditText txbPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnter = findViewById(R.id.btnEnter);
        txbLogin = findViewById(R.id.txbLogin);
        txbPassword = findViewById(R.id.txbPassword);

        btnEnter.setOnClickListener(this::enterApplication);

    }
    private void enterApplication(View view){
        String login = txbLogin.getText().toString();
        String password = txbPassword.getText().toString();

        HTTPBuilder httpBuilder = new HTTPBuilder();

        UserRepository userRepository = httpBuilder.createRepository(UserRepository.class);
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setPassword(password);

        Call<UserEntity> userEntityCall = userRepository.login(user);
        userEntityCall.enqueue(new LoginCallBack(this));
    }
}