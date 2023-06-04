package com.example.tcc_definitivo.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tcc_definitivo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class coletaseletiva extends AppCompatActivity {
    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String localc,diac,horac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletaseletiva);
        TextView coleescr = findViewById(R.id.coletaescrita);
        String uiddd = user.getUid();


        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Obtém o valor do Firebase e armazena em uma variável String

                localc = dataSnapshot.child(uiddd).child("local:").getValue().toString();
                diac = dataSnapshot.child(uiddd).child("dia:").getValue().toString();
                horac = dataSnapshot.child(uiddd).child("Hora:").getValue().toString();
                String MensagemApre = String.format(" Localidade: %s \n Dia da coleta: %s \n Hora que começa a coleta: %s \n  ",localc,diac,horac);
                coleescr.setText(MensagemApre);
                //System.out.println();
                //coleescr.setText(localc);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Lida com erros de leitura do Firebase
                Log.w("TAG", "Falha ao ler o valor do Firebase.", error.toException());
            }
        });


    }
}