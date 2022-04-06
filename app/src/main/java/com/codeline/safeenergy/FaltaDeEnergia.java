package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FaltaDeEnergia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falta_de_energia);
        getSupportActionBar().hide();
    }
}