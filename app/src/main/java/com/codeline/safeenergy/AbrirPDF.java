package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.joanzapata.pdfview.PDFView;

public class AbrirPDF extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir_pdf);

        String assetFileName = "Manual-Consumo-Consciente"; //The name of the asset to open
        int pageNumber = 0; //Start at the first page

        PDFView pdfView = (PDFView) findViewById(R.id.pdfview); //Fetch the view
        pdfView.fromAsset(assetFileName) //Fill it with data
                .defaultPage(pageNumber) //Set default page number
                .onPageChange(null) //PageChangeListener
                .load();















    }
}