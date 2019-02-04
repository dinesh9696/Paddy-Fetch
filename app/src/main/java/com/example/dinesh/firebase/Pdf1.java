package com.example.dinesh.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;

import com.github.barteksc.pdfviewer.PDFView;

public class Pdf1 extends AppCompatActivity {
    PDFView p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf1);
        p1=findViewById(R.id.pdfBook1);


        p1.fromAsset("PADDY VARIETIES IN INDIA.pdf").load();



    }
}
