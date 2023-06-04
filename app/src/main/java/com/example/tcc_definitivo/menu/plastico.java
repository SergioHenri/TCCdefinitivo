package com.example.tcc_definitivo.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.tcc_definitivo.R;

public class plastico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastico);
        String plastico = getString(R.string.plastico); // recupera a string HTML da resource
        TextView textView = findViewById(R.id.textoplastico1); // encontra a referência para o TextView no layout
        textView.setText(Html.fromHtml(plastico)); // define o texto do TextView usando a formatação HTML
    }
}