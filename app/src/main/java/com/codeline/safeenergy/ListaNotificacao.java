package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaNotificacao extends AppCompatActivity {
    ListView Lv_Listadenotificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notificacao);
        getSupportActionBar().hide();
        Inicializar();

        ArrayList<String> notificacao=prencherDados();
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,notificacao);
        Lv_Listadenotificacao.setAdapter(arrayAdapter);
    }

    private ArrayList<String> prencherDados() {
        ArrayList<String> listaNotificacao=new ArrayList<String>();
        listaNotificacao.add( "notificacao 1");
        listaNotificacao.add( "notificacao 2");
        return  listaNotificacao;
    }

    public void Inicializar(){
        Lv_Listadenotificacao=findViewById(R.id.Lv_Listadenotificacao);
    }
}