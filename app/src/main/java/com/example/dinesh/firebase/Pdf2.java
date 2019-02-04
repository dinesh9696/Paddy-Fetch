package com.example.dinesh.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;

import com.github.barteksc.pdfviewer.PDFView;


public class Pdf2 extends AppCompatActivity {
PDFView p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);
        p2=findViewById(R.id.pdfBook2);


        p2.fromAsset("paddy.pdf").load();

    }
}
