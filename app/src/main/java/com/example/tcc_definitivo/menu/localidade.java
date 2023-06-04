package com.example.tcc_definitivo.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tcc_definitivo.R;
import com.example.tcc_definitivo.criarelogin.criarConta;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class localidade extends AppCompatActivity {
    //Referencia do Usuario e do Coleta
    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Usuario");
    DatabaseReference databaseC = FirebaseDatabase.getInstance().getReference("ColetaS");
    //Incialização do database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();
    DatabaseReference userRef = databaseRef.child(uid);
    DatabaseReference coleta = databaseRef.child("Região");
    String email = user.getEmail();
    String itemValue;
    String itemValuee;
    String itemValueee;
    String keyyy;
    List<String> listaC = new ArrayList<>();
    List<String> listaH = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(localidade.this);
        setContentView(R.layout.activity_localidade);
        EditText leitura = (EditText) findViewById(R.id.lerlocalidade);
        TextView acessa = (TextView) findViewById(R.id.leituraaa);
        ListView listView = (ListView)findViewById(R.id.lista);

        Button inicia = findViewById(R.id.guardalocalidade);
        databaseC.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Aqui você pode ler os dados do snapshot e adicioná-los a uma lista
                List<String> lista = new ArrayList<>();

                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    for(DataSnapshot childSnapshot1 : childSnapshot.getChildren()){
                        for(DataSnapshot childSnapshot2 : childSnapshot1.getChildren()){

                                HashMap<String, Object> value = (HashMap<String, Object>) childSnapshot2.getValue();
                                HashMap<String, Object> value2 = (HashMap<String, Object>) childSnapshot1.getValue();
                                for (Map.Entry<String, Object> entry : value.entrySet()) {
                                    for(DataSnapshot childSnapshot3 : childSnapshot2.getChildren()){
                                        for(DataSnapshot childSnapshot4 : childSnapshot3.getChildren()){
                                            keyyy=childSnapshot4.getValue().toString();
                                        }
                                    }
                                    String keyy = childSnapshot2.getKey();
                                    String key = entry.getKey();
                                    Object valuee = entry.getValue();
                                    String valorString = key.toString();
                                    if(valorString.equals("Hora")){
                                    }
                                    else{
                                        listaC.add(keyy);
                                        lista.add(valorString);
                                        listaH.add(keyyy);
                                    }
                            }

                        }
                    }
                }
                // Cria e define o adaptador da ListView
                ArrayAdapter<String> adapter = new ArrayAdapter<>(localidade.this, android.R.layout.simple_list_item_1, lista);
                listView.setAdapter(adapter);
                // Notifica o adaptador que os dados foram alterados
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Tratamento de erro
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                itemValue = (String) listView.getItemAtPosition(position);
                leitura.setText(itemValue);
                itemValuee = listaC.get(position);
                itemValueee = listaH.get(position);
                System.out.println(position);
                System.out.println(itemValuee);
                System.out.println(itemValueee);
                System.out.println(itemValue);
            }
        });
        acessa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linksite="https://www.google.com/maps/d/u/0/viewer?mid=1JpPRPc4rq924JK5WqAru2nkK8RI&ll=-23.7300130680047%2C-46.546723884324976&z=12";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(linksite));
                startActivity(intent);
                //criei um hiperlink através TextView, esse evento faz eu sair do aplicativo e ir para o site da coleta
            }
        });
        inicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userRef.child("local:").setValue(itemValue);
                userRef.child("dia:").setValue(itemValuee);
                userRef.child("Hora:").setValue(itemValueee);
                //Coloca localidade no banco de dados do úsuario
                Intent intent = new Intent(localidade.this,com.example.tcc_definitivo.menu.Menu.class);
                startActivity(intent);
                

                DatabaseReference currentUserRef = userRef.child(uid);


            }
        });


      


    }
}