package com.codeline.safeenergy;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PopUp extends Activity {

    TextView confirmacaoTexto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        confirmacaoTexto=findViewById(R.id.sucessoTeexto);





        setContentView(R.layout.pop_up);

        DisplayMetrics tamanhoTela= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(tamanhoTela);

        int width=tamanhoTela.widthPixels;
        int height=tamanhoTela.heightPixels;


        getWindow().setLayout((int)(width*.9),(int)(height*.4));


    }
}
