package com.codeline.safeenergy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MeuPerfil extends AppCompatActivity {
private TextView tv_email,tv_numeroDecelular;
private TextView tv_nome,tv_numeroDeContador;
private  TextView tv_morada,tv_dataDeNascimento;
private TextView tv_terminarSessao;
FirebaseFirestore bancoDeDados=FirebaseFirestore.getInstance();
String usuarioId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);
        getSupportActionBar().hide();
        IniciarComponentes();

        tv_terminarSessao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(MeuPerfil.this,Tela_Inicio.class);
                startActivity(intent);
                finish();

            }
        });


    }
//recuperar os dados do banco de dados
    @Override
    protected void onStart() {
        super.onStart();
        String email=FirebaseAuth.getInstance().getCurrentUser().getEmail();
        usuarioId=FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference=bancoDeDados.collection("usuario").document(usuarioId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot !=null){
                    tv_nome.setText(documentSnapshot.getString("nome"));
                    tv_dataDeNascimento.setText(documentSnapshot.getString("Data de Nascimento"));
                    tv_morada.setText(documentSnapshot.getString("Morada"));

                  //  tv_numeroDeContador.setText(documentSnapshot.getString(""));

                    tv_numeroDecelular.setText(documentSnapshot.getString("Contacto"));
                    tv_email.setText(email);

                }
            }
        });



    }

    private void IniciarComponentes(){
     tv_email=findViewById(R.id.Tv_emailMeuPerfil);
     tv_numeroDecelular=findViewById(R.id.Tv_NumeroDecelularPerfil);
     tv_morada=findViewById(R.id.Tv_MoradaPerfil);
     tv_dataDeNascimento=findViewById(R.id.Tv_dataDeNascimentoPerfil);
     tv_nome=findViewById(R.id.Tv_NomePerfil);
     tv_numeroDeContador=findViewById(R.id.Tv_NumeroContadorPerfil);
     tv_terminarSessao=findViewById(R.id.Tv_terminarSessao);

    }
}