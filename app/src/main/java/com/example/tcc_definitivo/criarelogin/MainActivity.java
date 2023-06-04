package com.example.tcc_definitivo.criarelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tcc_definitivo.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button criar = findViewById(R.id.criar);
        Button login = findViewById(R.id.login);
        Button funcio= findViewById(R.id.funcionario);
        
        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.tcc_definitivo.criarelogin.criarConta.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.tcc_definitivo.criarelogin.login.class);
                startActivity(intent);
            }
        });

        funcio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.tcc_definitivo.funcionario.escolhefun.class);
                startActivity(intent);
            }
        });


    }

}