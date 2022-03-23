package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Novo_Contrato extends AppCompatActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contrato);
        getSupportActionBar().hide();

    spinner1 =findViewById(R.id.spinnerSexo);

    //ler a lista do spinner criado no xml strings
    String[] sexo=getResources().getStringArray(R.array.arraySexo);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sexo);
        spinner1.setAdapter(adapter);



    }


}