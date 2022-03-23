package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaCategorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_categorias);
        getSupportActionBar().hide();

    }
    public void AbrirNovoContrato(View view){
        Intent intent=new Intent(TelaCategorias.this,Novo_Contrato.class);
        startActivity(intent);

    }
}