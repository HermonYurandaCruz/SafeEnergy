package com.codeline.safeenergy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Tela_Inicio extends AppCompatActivity {
    private TextView tv_novoCadastro;
    private EditText et_email,et_passWord;
    private Button bt_login;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
        getSupportActionBar().hide();

        IniciarNovoCadastro();


        tv_novoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tela_Inicio.this,NovoCadastro.class);
                startActivity(intent);
            }
        });


        // DAR ACCAO A BOTAO LOGIN
      bt_login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String email=et_email.getText().toString();
              String passWord=et_passWord.getText().toString();

              if (email.isEmpty()||passWord.isEmpty()){
                  Snackbar snackbar=Snackbar.make(view,"Preencha todos os campos!!!",Snackbar.LENGTH_SHORT);
                  snackbar.setBackgroundTint(Color.WHITE);
                  snackbar.setTextColor(Color.BLACK);
                  snackbar.show();

              }else{
                  AutenticarUsuario(view);
              }


          }
      });


    }
    private void AutenticarUsuario(View view){
        String email=et_email.getText().toString();
        String passWord=et_passWord.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AbrirTelaCategoriaLogin();

                        }
                    },2500);

                }else{
                    String erro1;
                    try{
                        throw task.getException();
                    }catch (Exception e){
                        erro1="Erro ao Logar Usuario...";
                        Snackbar snackbar=Snackbar.make(view,erro1,Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.WHITE);
                        snackbar.setTextColor(Color.BLACK);
                        snackbar.show();
                    }
                }
            }
        });


    }
// ACCAO PARA O APP NAO PEDIR O LOGIN CASO O USURIO JA TENHA FEITO O LOGIN NO DISPOSITIVO
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuarioAtual=FirebaseAuth.getInstance().getCurrentUser();
        if(usuarioAtual!=null){
            AbrirTelaCategoriaLogin();
        }

    }

    private void AbrirTelaCategoriaLogin(){
        Intent intent=new Intent(Tela_Inicio.this,TelaCategorias.class);
        startActivity(intent);
        finish();

    }



    private  void IniciarNovoCadastro(){
        tv_novoCadastro=findViewById(R.id.Novo_cadastro);
        et_email=findViewById(R.id.emailLogin);
        et_passWord=findViewById(R.id.PasswordLogin);
        bt_login=findViewById(R.id.BotaoLogin);
        progressBar=findViewById(R.id.progresse);
    }

    private void AbrirTelaNovoCadastro(){
        Intent intent=new Intent(Tela_Inicio.this,NovoCadastro.class);
        startActivity(intent);
        finish();

    }


}