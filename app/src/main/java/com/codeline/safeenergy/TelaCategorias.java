package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaCategorias extends AppCompatActivity {
    TextView tv_PouparEnergia;
    ImageView imagemView;
    String url = "https://drive.google.com/file/d/1S5eDm9VxgheC2EIkfU91SOj2JU-Ka8rr/view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_categorias);
        getSupportActionBar().hide();

        IniciarImagemView();
        imagemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TelaCategorias.this,MeuPerfil.class);
                startActivity(intent);
            }
        });
        tv_PouparEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });


    }

    private void IniciarImagemView() {
        imagemView=findViewById(R.id.Iv_perfil);
        tv_PouparEnergia=findViewById(R.id.tv_PouparEnergia);
    }


    public void AbrirNovoContrato(View view){
        Intent intent=new Intent(TelaCategorias.this,Novo_Contrato.class);
        startActivity(intent);

    }
    public void AbrirTelaComprarCredelec(View view){
        Intent intent=new Intent(TelaCategorias.this,ComprarCredelec.class);
        startActivity(intent);

    }


    public void AbrirTelaClassificaoEqu(View view){
        Intent intent=new Intent(TelaCategorias.this,ClassificacaoEquipa.class);
        startActivity(intent);


    }

    public void AbrirTelaFaltaDeEnergia(View view){
        Intent intent=new Intent(TelaCategorias.this,FaltaDeEnergia.class);
        startActivity(intent);

    }




}