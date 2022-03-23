package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NovoCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_cadastro);
        getSupportActionBar().hide();
    }

    public void AbrirTelaCategoria2 (View v){
        Intent tela=new Intent(NovoCadastro.this,TelaCategorias.class);
        startActivity(tela);
    }

}