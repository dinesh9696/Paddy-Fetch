package com.example.dinesh.firebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Paddylifesearch extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    EditText paddyname1;
    Button btnsearch;
    Firebase firebase;
String pn,a,b,c,d,e,f,g,h,i,j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paddylifesearch);
        t1 = (TextView) findViewById(R.id.txtpaddyname);
        t2 = (TextView) findViewById(R.id.txtferttime);
        t3 = (TextView) findViewById(R.id.txtfertilizers);
        t4 = (TextView) findViewById(R.id.txtkalaitime);
        t5 = (TextView) findViewById(R.id.txtsoil);
        t6 = (TextView) findViewById(R.id.txtseason);
        t7 = (TextView) findViewById(R.id.txtdurations);
        t8 = (TextView) findViewById(R.id.txttime);
        paddyname1 = (EditText) findViewById(R.id.txtpaddyname1);
        btnsearch = (Button) findViewById(R.id.btnsearch);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    public void search() {
        pn=paddyname1.getText().toString();
        firebase.setAndroidContext(getApplicationContext());
        firebase = new Firebase("https://demokmp.firebaseio.com/PADDY_DETAILS/");
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                a = (String) dataSnapshot.child("Paddy name").getValue();
                if (pn.equals(a)) {
                    b = (String) dataSnapshot.child("Fertilizers time").getValue();
                    c = (String) dataSnapshot.child("Fertilizers name").getValue();
                    d = (String) dataSnapshot.child("Kalai time").getValue();
                    e = (String) dataSnapshot.child("Durations").getValue();
                    f = (String) dataSnapshot.child("Time").getValue();
                    g = (String) dataSnapshot.child("Soil type").getValue();
                    h = (String) dataSnapshot.child("Season").getValue();
                    t1.setText(a);
                    t2.setText(b);
                    t3.setText(c);
                    t4.setText(d);
                    t5.setText(g);
                    t6.setText(h);
                    t7.setText(e);
                    t8.setText(f);


                }
            }



                @Override
                public void onChildChanged (DataSnapshot dataSnapshot, String s){

                }

                @Override
                public void onChildRemoved (DataSnapshot dataSnapshot){

                }

                @Override
                public void onChildMoved (DataSnapshot dataSnapshot, String s){

                }

                @Override
                public void onCancelled (FirebaseError firebaseError){

                }



        });

    }

}