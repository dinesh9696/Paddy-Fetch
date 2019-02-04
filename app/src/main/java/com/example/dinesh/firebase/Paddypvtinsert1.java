package com.example.dinesh.firebase;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Paddypvtinsert1 extends AppCompatActivity implements View.OnClickListener {

    static  Map<String,String> m;
    Button btnsave,btncancel,btncal,btnsetdate;
    EditText txtpno,txtmutai,txtsoldtime,txtuad,txtpaddyname,txtemail,txtusername1,txttotal1,txthect;
    private int myear,mmonth,mdate;
    Firebase fbase;
    private FirebaseAuth fbaseauth;
    String pno,backet,date,uad,pname,email,uname,tot,hect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paddypvtinsert1);
        txtemail=(EditText)findViewById(R.id.txtemail);
        txtpaddyname=(EditText)findViewById(R.id.txtpaddyname);
        txtusername1=(EditText)findViewById(R.id.txtusername1);
        txtuad=(EditText)findViewById(R.id.txtuad);
        txtsoldtime=(EditText)findViewById(R.id.txtsoldtime);
        txtmutai=(EditText)findViewById(R.id.txtmutai);
        txthect=(EditText)findViewById(R.id.txthect);
        txtpno=(EditText)findViewById(R.id.txtpno);
        txttotal1 = (EditText) findViewById(R.id.txttotal1);
        btncal = (Button) findViewById(R.id.btncal);
        btnsave=(Button)findViewById(R.id.btnsave);
        btncancel=(Button)findViewById(R.id.btncancel);
        btnsetdate=(Button) findViewById(R.id.btnsetdate);
        fbase.setAndroidContext(Paddypvtinsert1.this);
        fbaseauth = FirebaseAuth.getInstance();


        btnsetdate.setOnClickListener(Paddypvtinsert1.this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = txtemail.getText().toString();
                pname = txtpaddyname.getText().toString();
                uname = txtusername1.getText().toString();
                uad = txtuad.getText().toString();
                date = txtsoldtime.getText().toString();
                backet = txtmutai.getText().toString();
                hect=txthect.getText().toString();
                pno = txtpno.getText().toString();
                tot = txttotal1.getText().toString();
                fbase = new Firebase("https://demokmp.firebaseio.com/PADDYPVTPURCHASEINSERT_DETAILS/" + uname);
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Paddypvtinsert1.this, "தயவுசெய்து உங்கள் மின்னஞ்சல் முகவரியை கொடுக்கவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pname)) {
                    Toast.makeText(Paddypvtinsert1.this, "தயவுசெய்து நெல் பெயரை உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(uname)) {
                    Toast.makeText(Paddypvtinsert1.this, "தயவுசெய்து உங்கள் பெயரைக் கொடுங்கள் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(uad)) {
                    Toast.makeText(Paddypvtinsert1.this, "உங்கள் நிரந்தர முகவரியை கொடுக்கவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(date)) {
                    Toast.makeText(Paddypvtinsert1.this, "தயவு செய்து உங்கள் நெல் வாங்கிய தேதி உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(backet)) {
                    Toast.makeText(Paddypvtinsert1.this, "உங்கள் மொத்த நெல் கிலோவை உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(hect)) {
                    Toast.makeText(Paddypvtinsert1.this, "உங்கள் மொத்த ஹெக்டேர் உள்ளிடவும் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pno)) {
                    Toast.makeText(Paddypvtinsert1.this, "உங்கள் செல்லுபடியாகும் தொலைபேசி எண்ணை கொடுங்கள் ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(tot)) {
                    Toast.makeText(Paddypvtinsert1.this, "தயவுசெய்து உங்கள் தொகை சேர்க்கவும் ", Toast.LENGTH_SHORT).show();
                } else {
                    m = new HashMap<>();
                    m.put("Email", email);
                    m.put("Paddy name", pname);
                    m.put("User name", uname);
                    m.put("User address", uad);
                    m.put("Date", date);
                    m.put("Backet", backet);
                    m.put("Hectares", hect);
                    m.put("Phone no", pno);
                    m.put("Total amount", tot);
                    fbase.setValue(m);
                    Toast.makeText(Paddypvtinsert1.this, "பதிவு  ஏற்றுக்கொள்ளப்பட்டது ", Toast.LENGTH_LONG).show();
                    sendmessage();

                }
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Paddypvtinsert1.this, Paddysalesstation.class);
                startActivity(i);
            }
        });
        btncal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                double res;
                double n = Double.parseDouble(txtmutai.getText().toString());
                String pn = txtpaddyname.getText().toString();

                if (pn.equals("பொன்னி")) {
                    res = n * 700;
                } else if (pn.equals("டீலக்ஸ்")) {
                    res = n * 650;
                } else if (pn.equals("கல்சர்")) {
                    res = n * 600;
                } else if (pn.equals("சம்பா")) {
                    res = n * 550;
                } else {
                    res = n * 500;
                }
                txttotal1.setText("" + res);
            }

        });


    }
    public  void sendmessage(){
        String req ="உங்கள் நெல் வாங்கிய விவரங்கள் வெற்றிகரமாக பதிவு செய்யப்பட்டது";
        String pno =txtpno.getText().toString().trim();
        if(pno==null || pno.equals("")||req==null|| req.equals("")){
            Toast.makeText(this,"விவரங்களை நிரப்புக",Toast.LENGTH_LONG).show();

        }
        else        {
            if(TextUtils.isDigitsOnly(pno)){
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(pno,null,req,null,null);
                Toast.makeText(this,"செய்தி வெற்றிகரமாக அனுப்புகிறது" +pno,Toast.LENGTH_LONG).show();
                txtpno.setText("");
            }
            else {
                Toast.makeText(this,"தயவுசெய்து எண்ணை மட்டும் உள்ளிடவும்",Toast.LENGTH_LONG).show();
            }
        }

    }


    @Override
    public void onClick(View view) {
        if (view == btnsetdate) {
            final Calendar c = Calendar.getInstance();
            myear = c.get(Calendar.YEAR);
            mmonth = c.get(Calendar.MONTH);
            mdate = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    txtsoldtime.setText(i2 + "-" + (i1 + 1) + "-" + i);
                }
            }, myear, mmonth, mdate);
            dpd.show();


        }

    }
}
