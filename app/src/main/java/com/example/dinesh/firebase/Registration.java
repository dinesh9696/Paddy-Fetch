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
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    static  Map<String,String> m;
    Button btnreg;
    EditText editText, txtfname, txtlname, txtpass, txtemail, txtphone;
    Firebase fbase;
    private FirebaseAuth fbaseauth;
    String name,fname,add,pno,mail,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtfname = (EditText) findViewById(R.id.txtfname);
        txtlname = (EditText) findViewById(R.id.txtlname);
        editText = (EditText) findViewById(R.id.editText);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpass = (EditText) findViewById(R.id.txtpass);
        txtphone = (EditText) findViewById(R.id.txtphone);
        btnreg = (Button) findViewById(R.id.btnreg);
        fbase.setAndroidContext(Registration.this);
        fbaseauth=FirebaseAuth.getInstance();

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=txtlname.getText().toString();
                fname=txtfname.getText().toString();
                add=editText.getText().toString();
                mail=txtemail.getText().toString();
                pwd=txtpass.getText().toString();
                pno=txtphone.getText().toString();
                fbase=new Firebase("https://demokmp.firebaseio.com/REGISTRATION/" +name);
                if(TextUtils.isEmpty(name))
                {
                    Toast.makeText(Registration.this,"தயவுசெய்து உங்கள் பெயரைக் கொடுங்கள் ",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(fname)){
                    Toast.makeText(Registration.this,"தயவுசெய்து உங்கள் தந்தை பெயரைக் கொடுங்கள் ",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(add)){
                    Toast.makeText(Registration.this,"உங்கள் நிரந்தர முகவரியை கொடுக்கவும் ",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(mail)){
                    Toast.makeText(Registration.this,"தயவுசெய்து உங்கள் மின்னஞ்சல் முகவரியை கொடுக்கவும் ",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(Registration.this,"தயவுசெய்து உங்கள் கடவுச்சொல்லை கொடுங்கள் ",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(pno)){
                    Toast.makeText(Registration.this,"உங்கள் செல்லுபடியாகும் தொலைபேசி எண்ணை கொடுங்கள் ",Toast.LENGTH_SHORT).show();
                }
                else {
                    m=new HashMap<>();
                m.put("Name",name);
                m.put("Father Name",fname);
                m.put("Address",add);
                m.put("Email",mail);
                m.put("Password",pwd);
                m.put("Phone no",pno);
                fbase.setValue(m);
                final ProgressDialog progressDialog= ProgressDialog.show(Registration.this, "தயவுசெய்து காத்திருங்கள்....","செயலாக்க........",true);
                (fbaseauth.createUserWithEmailAndPassword(txtemail.getText().toString(),txtpass.getText().toString()))
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(Registration.this,"பதிவு  ஏற்றுக்கொள்ளப்பட்டது ",Toast.LENGTH_LONG).show();
                                    sendmessage();
                                    Intent intent = new Intent(Registration.this,MainActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Log.e("பிழை",task.getException().toString());
                                }
                            }
                        });
                }
            }
        });
        }

    public  void sendmessage() {
        String req ="நெல் பயன்பாடுகளில் உங்கள் கணக்கு வெற்றிகரமாக உருவாக்கப்பட்டது";
        String pno =txtphone.getText().toString().trim();
        if(pno==null || pno.equals("")||req==null|| req.equals("")){
            Toast.makeText(this,"விவரங்களை நிரப்புக",Toast.LENGTH_LONG).show();

        }
        else        {
            if(TextUtils.isDigitsOnly(pno)){
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(pno,null,req,null,null);
                Toast.makeText(this,"செய்தி வெற்றிகரமாக அனுப்பப்பட்டது" ,Toast.LENGTH_LONG).show();
                txtphone.setText("");
                editText.setText("");
                txtemail.setText("");
                txtfname.setText("");
                txtlname.setText("");
                txtpass.setText("");
            }
            else {
                Toast.makeText(this,"தயவுசெய்து எண்ணை மட்டும் உள்ளிடவும்",Toast.LENGTH_LONG).show();
            }
        }

    }

}