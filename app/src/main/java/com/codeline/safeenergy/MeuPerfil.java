package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MeuPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);
        getSupportActionBar().hide();
    }
}