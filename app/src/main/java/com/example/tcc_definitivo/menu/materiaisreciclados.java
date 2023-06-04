package com.example.tcc_definitivo.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tcc_definitivo.R;

public class materiaisreciclados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiaisreciclados);

        ImageButton papel = (ImageButton) findViewById(R.id.Pepelhiperlink);
        ImageButton plastico = (ImageButton) findViewById(R.id.PlasticoHiperlink);
        ImageButton metal = (ImageButton) findViewById(R.id.HiperlinkMetal);
        ImageButton vidro = (ImageButton) findViewById(R.id.VidroHiperlink);

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(materiaisreciclados.this, com.example.tcc_definitivo.menu.papel.class);
                startActivity(intent);
            }
        });
        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(materiaisreciclados.this, com.example.tcc_definitivo.menu.plastico.class);
                startActivity(intent);
            }
        });
        metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(materiaisreciclados.this, com.example.tcc_definitivo.menu.metal.class);
                startActivity(intent);
            }
        });
        vidro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(materiaisreciclados.this, com.example.tcc_definitivo.menu.vidro.class);
                startActivity(intent);
            }
        });
    }
}