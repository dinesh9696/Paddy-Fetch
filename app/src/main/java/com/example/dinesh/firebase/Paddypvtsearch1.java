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

public class Paddypvtsearch1 extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    EditText email;
    Button btnsearch;
    Firebase firebase;
    String pn,a,b,c,d,e,f,g,h,i,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paddypvtsearch1);
        t1 = (TextView) findViewById(R.id.txtemail2);
        t2 = (TextView) findViewById(R.id.txtpaddyname);
        t3 = (TextView) findViewById(R.id.txtusername);
        t4 = (TextView) findViewById(R.id.txtuad);
        t5 = (TextView) findViewById(R.id.txtsolddate);
        t6 = (TextView) findViewById(R.id.txtmutai);
        t7 = (TextView) findViewById(R.id.txthect);
        t8 = (TextView) findViewById(R.id.txtpno);
        t9=(TextView) findViewById(R.id.txttotal1);
        email = (EditText) findViewById(R.id.txtemail);
        btnsearch = (Button) findViewById(R.id.btnsearch);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    public void search() {
        pn=email.getText().toString();
        firebase.setAndroidContext(getApplicationContext());
        firebase = new Firebase("https://demokmp.firebaseio.com/PADDYPVTPURCHASEINSERT_DETAILS/");
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                a = (String) dataSnapshot.child("Email").getValue();
                if (pn.equals(a)) {
                    b = (String) dataSnapshot.child("Paddy name").getValue();
                    c = (String) dataSnapshot.child("User name").getValue();
                    d = (String) dataSnapshot.child("User address").getValue();
                    e = (String) dataSnapshot.child("Date").getValue();
                    f = (String) dataSnapshot.child("Backet").getValue();
                    g = (String) dataSnapshot.child("Hectares").getValue();
                    h = (String) dataSnapshot.child("Phone no").getValue();
                    i = (String) dataSnapshot.child("Total amount").getValue();
                    t1.setText(a);
                    t2.setText(b);
                    t3.setText(c);
                    t4.setText(d);
                    t5.setText(e);
                    t6.setText(f);
                    t7.setText(g);
                    t8.setText(h);
                    t9.setText(i);

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
