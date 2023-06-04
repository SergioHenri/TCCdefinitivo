package com.example.tcc_definitivo.funcionario;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.tcc_definitivo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ecoTela extends AppCompatActivity {
    //private static final int PERMISSION_REQUEST_CAMERA = 0;

    private Handler handler = new Handler();


    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");
    String texto="nada";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eco_tela);
        Button ecoVa = findViewById(R.id.ecoValida);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Coloque o código que deseja executar após o atraso aqui
                IntentIntegrator intentIntegrator = new IntentIntegrator(ecoTela.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Scan a QR Code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();

            }

        }, 2000); // 1000 é o número de milissegundos que deseja atrasar (1 segundo no exemplo)





        ecoVa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(ecoTela.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Scan a QR Code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Obtém o resultado da leitura de QR Code
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null && result.getContents() != null) {
            String content = result.getContents();
            databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Obtém o valor do Firebase e armazena em uma variável String
                    String pontuacao = dataSnapshot.child(content).child("pontuação").getValue().toString();
                    int pont = Integer.parseInt(pontuacao)+10;
                    DatabaseReference userRef = databaseRef.child(content);
                    userRef.child("pontuação").setValue(pont);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Lida com erros de leitura do Firebase
                    Log.w("TAG", "Falha ao ler o valor do Firebase.", error.toException());
                }
            });
            // Exibe o conteúdo lido na tela

        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }


    }
