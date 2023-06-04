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

public class mudarSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_senha);
        Button altersenha= (Button) findViewById((R.id.altersenha));
        EditText textoo2=(EditText) findViewById(R.id.senhaalterada);
        EditText textoo3=(EditText) findViewById(R.id.senhaalterada2);
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String uid = user.getUid();
        DatabaseReference userRef = databaseRef.child(uid);

        altersenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textoo2.toString().isEmpty() || textoo3.toString().isEmpty()) {
                    View view = findViewById(android.R.id.content);
                    Snackbar snackbar = Snackbar.make(view, "Prencha todos os dados corretamente", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else if (textoo2.getText().toString().equals(textoo3.getText().toString())) {


                    String senha =textoo2.getText().toString();
                    user.updatePassword(senha);

                    Intent intent = new Intent(mudarSenha.this, com.example.tcc_definitivo.menu.Menu.class);
                    startActivity(intent);
                } else {
                    View view = findViewById(android.R.id.content);
                    Snackbar snackbar = Snackbar.make(view, "As duas senhas não coincidem", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }

        });

    }
}