package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NovoContratoCliente extends AppCompatActivity {
    EditText et_DataNascimentoContrato;
    final Calendar meuCalendario=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contrato_cliente);
        getSupportActionBar().hide();
        Iniciaalizar();
        DatePickerDialog.OnDateSetListener data=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                meuCalendario.set(Calendar.YEAR,ano);
                meuCalendario.set(Calendar.MONTH,mes);
                meuCalendario.set(Calendar.DAY_OF_MONTH,dia);
                updateLabel();
            }
        };
        et_DataNascimentoContrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(NovoContratoCliente.this,data,meuCalendario.get(Calendar.YEAR),meuCalendario.get(Calendar.MONTH),meuCalendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    public void Iniciaalizar(){
        et_DataNascimentoContrato=findViewById(R.id.et_DataNascimentoContrato);
    }
    public void updateLabel(){
        String formatoData="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(formatoData, Locale.US);
        et_DataNascimentoContrato.setText(dateFormat.format((meuCalendario.getTime())));
    }
}