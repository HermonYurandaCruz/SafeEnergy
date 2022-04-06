package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TelaReclamacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_reclamacao);
        getSupportActionBar().hide();
    }
}