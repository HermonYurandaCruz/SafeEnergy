package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class ComprarCredelec extends AppCompatActivity {
    EditText et_numeroContadorCredelec;
    EditText et_valor;
    TextView tv_valorEmKw,tv_contador,tv_valEnergia,tv_taxaLixo,tv_taxaRadio;
    TextView tv_kw,tv_numeroRecarga;
    ImageView iv_pesquisaCredelec;
    Button bt_pagarFactura;

    double somaValorValor=57;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_credelec);
        getSupportActionBar().hide();
        inicializar();
        iniciarImgem();

        bt_pagarFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double valorCredelec=Double.parseDouble(et_valor.getText().toString());

                if(valorCredelec<somaValorValor){
                    Snackbar snackbar=Snackbar.make(v,"Valor reduzido para a compra de Credelec",Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
                if(valorCredelec>somaValorValor){
                    String numeroRecargaCredelec = gerarDigitosAleatorios(12);
                    tv_numeroRecarga.setText(numeroRecargaCredelec);
                    ValidarCampos(v);

                }

            }
        });
       iv_pesquisaCredelec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ValidarCampos(v);

            }

        });




    }
    public void inicializar(){
        et_numeroContadorCredelec=findViewById(R.id.ET_numeroContadorCredelec);
        et_valor=findViewById(R.id.et_valor);
        tv_valorEmKw=findViewById(R.id.Tv_valorEmKw);
        tv_kw=findViewById(R.id.tv_kw);
        tv_contador=findViewById(R.id.tv_contador);
        tv_valEnergia=findViewById(R.id.tv_valEnergia);
        tv_taxaLixo=findViewById(R.id.tv_taxaLixo);
        tv_taxaRadio=findViewById(R.id.tv_taxaRadio);
        tv_numeroRecarga=findViewById(R.id.tv_numeroRecarga);
        bt_pagarFactura=findViewById(R.id.Bt_pagarFactura);
    }

    public void iniciarImgem(){
        iv_pesquisaCredelec=findViewById(R.id.iv_pesquisa);

    }

    private static String gerarDigitosAleatorios(int digitos) {
        StringBuilder text = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < digitos; i++) {
            text.append(random.nextInt(10)); // gerar um número aleatório entre 0 e 9
        }
        return text.toString();
    }


    public void CalcularCredelec(View view){

        String contador=et_numeroContadorCredelec.getText().toString();

        Double valorCredelec=Double.parseDouble(et_valor.getText().toString());



        if(valorCredelec<somaValorValor){
            Snackbar snackbar=Snackbar.make(view,"Valor reduzido para a compra de Credelec",Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        }
        if (contador.length() != 11) {
            Snackbar snackbar = Snackbar.make(view, "Numero de contador incorrecto...", Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        }
        if (valorCredelec>somaValorValor){
            double valorFinalCredelec = (valorCredelec-somaValorValor);
            double credelec=valorFinalCredelec/7.6;

            DecimalFormat decimalFormat=new DecimalFormat("#,##0.00");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            String valueDouble=Double.toString(Double.parseDouble(decimalFormat.format(credelec)));
            String valorKw=Double.toString(Double.parseDouble(String.valueOf(valorFinalCredelec)));
         //   String valorString=Integer.parseInt();


            tv_valorEmKw.setText(valueDouble);
            tv_kw.setText("kw");
            tv_valEnergia.setText(valorKw);
            tv_taxaRadio.setText("45 Mt");
            tv_taxaLixo.setText("12 Mt");




        }


    }

    public void ValidarCampos(View v){
        String contador=et_numeroContadorCredelec.getText().toString();
        String valor=et_valor.getText().toString();
        tv_contador.setText(contador);
        try {
            Long valorInt = Long.parseLong(et_valor.getText().toString());

            if (contador.length() == 11 || valorInt > 0) {
                CalcularCredelec(v);
            }

            if (contador.isEmpty()) {
                Snackbar snackbar = Snackbar.make(v, "Sem numero de Contador", Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();
            }


        }catch (Exception e){
            if (valor.isEmpty()) {
                Snackbar snackbar = Snackbar.make(v, "Sem Valor de Compra", Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();

            }

        }


    }

}