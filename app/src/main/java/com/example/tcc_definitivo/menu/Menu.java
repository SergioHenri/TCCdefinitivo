package com.example.tcc_definitivo.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcc_definitivo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Menu extends AppCompatActivity {
    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String pontuacao,nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton meusdados = (ImageButton) findViewById(R.id.meusdados);
        ImageButton ecopontos = (ImageButton) findViewById(R.id.ecopontos);
        ImageButton materiaisreciclados = (ImageButton) findViewById(R.id.materiaisreciclados);
        ImageButton coleta = (ImageButton) findViewById(R.id.coletaseletiva);
        ImageView qrcode = (ImageView) findViewById(R.id.QRcode);
        TextView apresenta = findViewById(R.id.apresentacaoAl);
        String email = user.getEmail();
        String id = user.getUid();
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Obtém o valor do Firebase e armazena em uma variável String
                pontuacao = dataSnapshot.child(id).child("pontuação").getValue().toString();
                nome = dataSnapshot.child(id).child("nome").getValue().toString();
                String MensagemApre = String.format("Bem vindo %s, sua pontuação é %s",nome,pontuacao);
                apresenta.setText(MensagemApre);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Lida com erros de leitura do Firebase
                Log.w("TAG", "Falha ao ler o valor do Firebase.", error.toException());
            }
        });
        //String pontuação=snapshot
        //String nome=databaseRef.child("nome").toString();
        //int pontuacao=Integer.parseInt(pontuação);
        //String MensagemApre = String.format("Bem vindo %s, sua pontuação é %d",nome,pontuacao);


        MultiFormatWriter mWriter = new MultiFormatWriter();
        try {
            //BitMatrix class to encode entered text and set Width & Height
            BitMatrix mMatrix = mWriter.encode(id, BarcodeFormat.QR_CODE, 400,400);
            BarcodeEncoder mEncoder = new BarcodeEncoder();
            Bitmap mBitmap = mEncoder.createBitmap(mMatrix);//creating bitmap of code
            qrcode.setImageBitmap(mBitmap);//Setting generated QR code to imageView
            // to hide the keyboard

        } catch (WriterException e) {
            e.printStackTrace();
        }

        meusdados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, com.example.tcc_definitivo.menu.meusdados.class);
                startActivity(intent);
            }
        });
        ecopontos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, com.example.tcc_definitivo.menu.ecoponto.class);
                startActivity(intent);
            }
        });
        materiaisreciclados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, com.example.tcc_definitivo.menu.materiaisreciclados.class);
                startActivity(intent);
            }
        });
        coleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, com.example.tcc_definitivo.menu.coletaseletiva.class);
                startActivity(intent);
            }
        });

    }
}