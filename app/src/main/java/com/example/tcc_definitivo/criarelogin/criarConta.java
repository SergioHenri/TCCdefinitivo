package com.example.tcc_definitivo.criarelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tcc_definitivo.R;
import com.example.tcc_definitivo.menu.configuracaoFire;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class criarConta extends AppCompatActivity {
    private FirebaseAuth criarlogin;

    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);
        Button telaCriar = (Button) findViewById(R.id.criar2);
        EditText usuarioCriar=(EditText) findViewById(R.id.usuarioCriar);
        EditText senhaCriar=(EditText) findViewById(R.id.senhaCriar);
        EditText nomeUser = (EditText) findViewById(R.id.nomedousuario);
        criarlogin= FirebaseAuth.getInstance();

        telaCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario1 = usuarioCriar.getText().toString();
                String senha = senhaCriar.getText().toString();
                if(usuario1.isEmpty() || senha.isEmpty() ){
                    View view = findViewById(android.R.id.content);
                    Snackbar snackbar = Snackbar.make(view, "Prencha todos os dados corretamente", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    senhaCriar.setText("");
                    usuarioCriar.setText("");

                }
                else{
                    Usuario usuario = new Usuario(usuario1,senha);
                    criarlogin.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                            .addOnCompleteListener(criarConta.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        View view = findViewById(android.R.id.content);
                                        Snackbar snackbar = Snackbar.make(view, "Só alegria", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                        String uid = user.getUid();
                                        String email = user.getEmail();
                                        DatabaseReference userRef = databaseRef.child(uid);
                                        String nomeUUU=nomeUser.getText().toString();
                                        senhaCriar.setText("");
                                        usuarioCriar.setText("");
                                        nomeUser.setText("");
                                        //Aqui eu coloquei para apagar os negocios de textos
                                        userRef.child("email").setValue(email);
                                        userRef.child("nome").setValue(nomeUUU);
                                        userRef.child("pontuação").setValue(0);
                                        criarlogin.signInWithEmailAndPassword(usuario.getEmail(),usuario.getSenha());
                                        Intent intent = new Intent(criarConta.this,com.example.tcc_definitivo.menu.localidade.class);
                                        startActivity(intent);
                                        //Cria no Realtime o Úsuario com seu email e nome

                                        // vai para a tela de localidade
                                    } else {
                                        View view = findViewById(android.R.id.content);
                                        Snackbar snackbar = Snackbar.make(view, "Não deu só alegria", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                        // Falha no cadastro, mostrar mensagem de erro para o usuário.
                                    }
                                }
                            });
                }
            }
        });
    }


}





