package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class TelaReclamacao extends AppCompatActivity implements  CompoundButton.OnCheckedChangeListener {
private EditText et_reclamacao,et_localizacao;
Button botao;
String messagem="Se deseja enviar uma reclamação anonima(sem os seus dados), ative o modo anonimo.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_reclamacao);
        getSupportActionBar().hide();
        Inicializar();
        Switch swt_anonimo=(Switch) findViewById(R.id.swt_anonimo);
        swt_anonimo.setOnCheckedChangeListener(this);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String localizacao = et_reclamacao.getText().toString();

                if (localizacao.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, messagem, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }

            }
        });



    }





    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked){
            AbrirTelaNovoCadastro();

        }

    }
    public void Inicializar(){
        MeuPerfil dadosPerfil=new MeuPerfil();

        TextView et_emailUsuario = dadosPerfil.getTv_email();
        et_emailUsuario=findViewById(R.id.Tv_emailMeuPerfil);
        et_localizacao=findViewById(R.id.et_LocalizacaoActual);
        et_reclamacao=findViewById(R.id.Et_textoDaReclamacao);
        botao=findViewById(R.id.botaoReclamacao);

    }

        private void AbrirTelaNovoCadastro(){
            Intent intent=new Intent(TelaReclamacao.this,TelaCategorias.class);
            startActivity(intent);
            finish();

        }
        public void DadosReclamacao(){

        String localizacao=et_localizacao.getText().toString();
        String textoReclamacao=et_reclamacao.getText().toString();
       // String email=et_emailUsuario.getText().toString();
        }

}