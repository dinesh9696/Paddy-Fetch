package com.example.dinesh.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Paddysales extends AppCompatActivity {
    TextView textView13;
    Button btngvt,btnpvt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paddysales);
        btngvt = (Button) findViewById(R.id.btngvt);
       btnpvt = (Button) findViewById(R.id.btnpvt);

        btngvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Paddysales.this, Paddygvt.class);
                startActivity(in);

            }
        });

        btnpvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Paddysales.this, Paddypvt.class);
                startActivity(in);

            }
        });

    }
}