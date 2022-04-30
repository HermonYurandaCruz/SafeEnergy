package com.codeline.safeenergy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class NovoCadastro extends AppCompatActivity {
   private EditText et_nome;
   private EditText et_dataDeNascimento;
    private EditText et_morada;
    private EditText et_email;
    private EditText et_passWord;
    private EditText et_contacto;
    private androidx.appcompat.widget.AppCompatButton bt_confirmar;
    String[] mensagem={"Preencha todos os campos!!!","Cadastro realizado com Sucesso!!!"};
    String usuarioId;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_cadastro);
        getSupportActionBar().hide();
        IniciarComponentes();



bt_confirmar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String nome=et_nome.getText().toString();
        String passWord=et_passWord.getText().toString();
        String dataDeNascimento=et_dataDeNascimento.getText().toString();
        String morada=et_morada.getText().toString();
        String email=et_email.getText().toString();
        String contacto=et_contacto.getText().toString();



        if(nome.isEmpty() ||passWord.isEmpty()|| dataDeNascimento.isEmpty() || morada.isEmpty() || email.isEmpty() || contacto.isEmpty()){
            Snackbar snackbar=Snackbar.make(v,mensagem[0],Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();

        }else{
            CadastrarUsuario(v);

        }


    }
});

    }



    // por testar
    private void CadastrarUsuario(View v){
        String email=et_email.getText().toString();
        String passWord=et_passWord.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    SalavarDadosUsuario();

                    Snackbar snackbar=Snackbar.make(v,mensagem[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }else{
                    String erro;
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erro="Digite uma senha com mais de 6 digitos";
                    }catch (FirebaseAuthUserCollisionException e){
                        erro="Esta conta ja existe";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro="E-mail invalido";
                    }catch (Exception e){
                        erro="Erro ao cadastrar";
                    }
                    Snackbar snackbar=Snackbar.make(v,erro,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();


                }
            }
        });

    }

    public  void SalavarDadosUsuario(){
        String nome=et_nome.getText().toString();
        String passWord=et_passWord.getText().toString();
        String dataDeNascimento=et_dataDeNascimento.getText().toString();
        String morada=et_morada.getText().toString();
        String email=et_email.getText().toString();
        String contacto=et_contacto.getText().toString();

        FirebaseFirestore dataBase= FirebaseFirestore.getInstance();
        Map<String,Object > usuarios=new HashMap<>();
        usuarios.put("nome",nome);
        usuarios.put("Data de Nascimento",dataDeNascimento);
        usuarios.put("Morada",morada);
        usuarios.put("E-mail",email);
        usuarios.put("Contacto",contacto);
        usuarioId=FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference=dataBase.collection("usuario").document(usuarioId);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("add_error","Erro ao salvar os dados"+ e.toString());

                    }
                });
    }



    //1-metodo para inicializar os objectos

    private void IniciarComponentes(){
        et_nome = findViewById(R.id.Nome);
        et_dataDeNascimento = findViewById(R.id.DataNascimento);
        et_morada = findViewById(R.id.Morada);
        et_email = findViewById(R.id.NovoEmail);
        et_passWord = findViewById(R.id.Password);
        et_contacto = findViewById(R.id.Contacto);
        bt_confirmar = findViewById(R.id.Confirmar);
    }





    public void AbrirTelaCategoria2(View v) {
        Intent tela = new Intent(NovoCadastro.this, TelaCategorias.class);
        startActivity(tela);
        finish();
       // despose();


    }
}