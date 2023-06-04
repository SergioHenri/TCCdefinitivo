package com.example.tcc_definitivo.criarelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tcc_definitivo.menu.Menu;
import com.example.tcc_definitivo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class login extends AppCompatActivity {
    private FirebaseAuth login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button logintela = (Button) findViewById(R.id.login2);
        EditText usuariologin=(EditText) findViewById(R.id.usuariologin);
        EditText senhalogin=(EditText) findViewById(R.id.senhalogin);
        login=FirebaseAuth.getInstance();
        logintela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuarioL = usuariologin.getText().toString();
                String senhaL = senhalogin.getText().toString();
                ;
                if(usuarioL.isEmpty() || senhaL.isEmpty() ){
                    View view = findViewById(android.R.id.content);
                    Snackbar snackbar = Snackbar.make(view, "Prencha todos os dados corretamente", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    usuariologin.setText("");
                    senhalogin.setText("");
                }
                else{
                    Usuario usuariolo=new Usuario(usuarioL,senhaL);
                    login.signInWithEmailAndPassword(usuariolo.getEmail(),usuariolo.getSenha())
                            .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>(){
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        View view = findViewById(android.R.id.content);
                                        Snackbar snackbar = Snackbar.make(view, "Só alegria", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                        senhalogin.setText("");
                                        usuariologin.setText("");
                                        Intent intent = new Intent(login.this,com.example.tcc_definitivo.menu.Menu.class);
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