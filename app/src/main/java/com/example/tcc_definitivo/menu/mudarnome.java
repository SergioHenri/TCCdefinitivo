package com.example.tcc_definitivo.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tcc_definitivo.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class mudarnome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setContentView(R.layout.activity_mudarnome);
        Button alter= (Button) findViewById((R.id.alteraN));
        EditText textoo=(EditText) findViewById(R.id.nomeAl);
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");

        assert user != null;
        String uid = user.getUid();
        DatabaseReference userRef = databaseRef.child(uid);

        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textoo.toString().isEmpty()){
                    View view = findViewById(android.R.id.content);
                    Snackbar snackbar = Snackbar.make(view, "Prencha todos os dados corretamente", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else{
                    String nome =textoo.getText().toString();
                    userRef.child("nome").setValue(nome);
                    Intent intent = new Intent(mudarnome.this, com.example.tcc_definitivo.menu.Menu.class);
                    startActivity(intent);

                }
            }
        });
    }
}