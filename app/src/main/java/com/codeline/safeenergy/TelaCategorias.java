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
    ImageView imagemView,iv_notificacao;
    String url = "https://drive.google.com/file/d/1z4_MKyIFwE7TYakC5m56mMUrAd0imjG-/view?usp=sharing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_categorias);
        getSupportActionBar().hide();

        IniciarImagemView();

        iv_notificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TelaCategorias.this,ListaNotificacao.class);
                startActivity(intent);
                finish();
            }
        });
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
        iv_notificacao=findViewById(R.id.Iv_notificacao);
    }

    public void AbrirNovoContrato(View view){
        Intent intent=new Intent(TelaCategorias.this,NovoContratoCliente.class);
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

    public void AbrirTelaReclamacao(View view){
        Intent intent=new Intent(TelaCategorias.this,TelaReclamacao.class);
        startActivity(intent);

    }




}