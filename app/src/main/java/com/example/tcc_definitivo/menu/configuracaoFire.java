package com.example.tcc_definitivo.menu;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class configuracaoFire {
    private static DatabaseReference database;
    private static FirebaseAuth conta;

    public static DatabaseReference getFirebaseDatabase(){
        if(database==null){
            database = FirebaseDatabase.getInstance().getReference();
        }
        return database;
    }
    public static FirebaseAuth getFirebaseAutenticacao(){
        if(conta==null){
            conta = FirebaseAuth.getInstance();
        }
        return conta;
    }


}
