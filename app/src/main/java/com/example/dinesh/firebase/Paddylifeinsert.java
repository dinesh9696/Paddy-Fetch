package com.example.dinesh.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class Paddylifeinsert extends AppCompatActivity {

    static  Map<String,String> m;
    Button btnsave, btncancel;
    EditText txtpaddyname,txtferttime,txtfertilizers,txtkalaitime,txtdurations,txttime,txtsoil,txtseason;
    Firebase fbase;
    private FirebaseAuth fbaseauth;
    String pname,ftime,fert,ktime,dur,time,soil,season;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paddylifeinsert);
        txtpaddyname = (EditText) findViewById(R.id.txtpaddyname);
        txtferttime = (EditText) findViewById(R.id.txtferttime);
        txtfertilizers = (EditText) findViewById(R.id.txtfertilizers);
        txtkalaitime = (EditText) findViewById(R.id.txtkalaitime);
        txtsoil = (EditText) findViewById(R.id.txtsoil);
        txtseason = (EditText) findViewById(R.id.txtseason);
        txtdurations = (EditText) findViewById(R.id.txtdurations);
        txttime = (EditText) findViewById(R.id.txttime);
        btnsave = (Button) findViewById(R.id.btnsave);
        btncancel = (Button) findViewById(R.id.btncancel);
        fbase.setAndroidContext(Paddylifeinsert.this);
        fbaseauth = FirebaseAuth.getInstance();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pname = txtpaddyname.getText().toString();
                ftime = txtferttime.getText().toString();
                fert = txtfertilizers.getText().toString();
                ktime = txtkalaitime.getText().toString();
                dur = txtdurations.getText().toString();
                time = txttime.getText().toString();
                soil = txtsoil.getText().toString();
                season = txtseason.getText().toString();
                fbase = new Firebase("https://demokmp.firebaseio.com/PADDY_DETAILS/" + pname);
                if (TextUtils.isEmpty(pname)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து நெல் பெயரை உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(ftime)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து பயன்படுத்தப்படும் உரங்களின் கால அளவு உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(fert)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து பயன்படுத்தப்படும் உரங்களின் பெயர் உள்ளிடவும்", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(ktime)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து பயன்படுத்தப்படும் கலைஇன் கால அளவு உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(dur)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து நெல் வாழ்க்கை கால அளவுகள் உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(time)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து நெல் வாழ்க்கை பருவம் உள்ளிடவும் கொடுங்கள் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(soil)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து மண் வகை உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(season)) {
                    Toast.makeText(Paddylifeinsert.this, "தயவுசெய்து பருவங்கள் வகை உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else {
                    m = new HashMap<>();
                    m.put("Paddy name", pname);
                    m.put("Fertilizers time", ftime);
                    m.put("Fertilizers name", fert);
                    m.put("Kalai time", ktime);
                    m.put("Durations", dur);
                    m.put("Time", season);
                    m.put("Soil type", soil);
                    m.put("Season", time);
                    fbase.setValue(m);
                    Toast.makeText(Paddylifeinsert.this, "பதிவு  ஏற்றுக்கொள்ளப்பட்டது ", Toast.LENGTH_LONG).show();

                }
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Paddylifeinsert.this, Paddy.class);
                startActivity(in);

            }
        });

    }
}