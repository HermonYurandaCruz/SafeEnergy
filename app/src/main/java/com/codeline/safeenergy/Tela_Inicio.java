package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Tela_Inicio extends AppCompatActivity {

    private TextView tv_novoCadastro;

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


    }

public void AbrirTelaCategoria(View view){
        Intent intent=new Intent(Tela_Inicio.this,TelaCategorias.class);
        startActivity(intent);

    }

private  void IniciarNovoCadastro(){
        tv_novoCadastro=findViewById(R.id.Novo_cadastro);
}


}
