package com.example.tcc_definitivo.funcionario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tcc_definitivo.R;
import com.example.tcc_definitivo.criarelogin.MainActivity;
import com.example.tcc_definitivo.criarelogin.Usuario;
import com.example.tcc_definitivo.criarelogin.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class escolhefun extends AppCompatActivity {
    private FirebaseAuth loginfun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhefun);
        Button loginfunci = findViewById(R.id.loginfun);
        EditText usuariologinfun = (EditText) findViewById(R.id.usuariologinfun);
        EditText senhaloginfun = (EditText) findViewById(R.id.senhaloginfuncio);
        loginfun = FirebaseAuth.getInstance();

        loginfunci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuariologinfun1 = usuariologinfun.getText().toString();
                String senhaloginfun1 = senhaloginfun.getText().toString();

                if(usuariologinfun1.isEmpty() || senhaloginfun1.isEmpty() ){
                    View view = findViewById(android.R.id.content);
                    Snackbar snackbar = Snackbar.make(view, "Prencha todos os dados corretamente", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    usuariologinfun.setText("");
                    senhaloginfun.setText("");
                }
                else{
                    Usuario usuariolo = new Usuario(usuariologinfun1, senhaloginfun1);
                    loginfun.signInWithEmailAndPassword(usuariolo.getEmail(), usuariolo.getSenha())
                            .addOnCompleteListener(escolhefun.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        View view = findViewById(android.R.id.content);
                                        Snackbar snackbar = Snackbar.make(view, "Só alegria", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                        usuariologinfun.setText("");
                                        senhaloginfun.setText("");
                                        Intent intent = new Intent(escolhefun.this, com.example.tcc_definitivo.funcionario.ecoTela.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        View view = findViewById(android.R.id.content);
                                        Snackbar snackbar = Snackbar.make(view, "Não deu só alegria", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
