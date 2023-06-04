package com.example.tcc_definitivo.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tcc_definitivo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class meusdados extends AppCompatActivity {
    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String nomeM, localidadeMeu;
    String uidD= user.getUid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meusdados);
        Button nome = (Button)findViewById(R.id.mudarN);
        Button localidade = (Button)findViewById(R.id.mudarL);
        Button senha = (Button)findViewById(R.id.mudarS);
        Button excluir=(Button)findViewById(R.id.excluirConta);
        TextView inf = (TextView)findViewById(R.id.colocaInfo);

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Obtém o valor do Firebase e armazena em uma variável String
                localidadeMeu = dataSnapshot.child(uidD).child("local:").getValue().toString();
                nomeM = dataSnapshot.child(uidD).child("nome").getValue().toString();
                String emailMeu = user.getEmail();
                String MensagemApre = String.format(" Nome: %s\n Email: %s\n Localidade: %s ",nomeM,emailMeu, localidadeMeu);
                inf.setText(MensagemApre);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Lida com erros de leitura do Firebase
                Log.w("TAG", "Falha ao ler o valor do Firebase.", error.toException());
            }
        });

        nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(meusdados.this, com.example.tcc_definitivo.menu.mudarnome.class);
                startActivity(intent);
            }
        });
        localidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(meusdados.this, com.example.tcc_definitivo.menu.localidade.class);
                startActivity(intent);
            }
        });
        senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(meusdados.this, com.example.tcc_definitivo.menu.mudarSenha.class);
                startActivity(intent);
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseRef.child(uidD).removeValue();
                user.delete();
                Intent intent = new Intent(meusdados.this, com.example.tcc_definitivo.criarelogin.MainActivity.class);
                startActivity(intent);
            }
        });


    }
}