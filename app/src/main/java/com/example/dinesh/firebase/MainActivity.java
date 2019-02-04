package com.example.dinesh.firebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    static FirebaseAuth firebaseAuth;
    static EditText username,password;
    Button log,reg;
    static String email,x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.pass);
        log = (Button) findViewById(R.id.sin);
        reg = (Button) findViewById(R.id.reg);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText())) {
                    Toast.makeText(getApplicationContext(), "தயவுசெய்து உங்கள் மின்னஞ்சல் முகவரியை உள்ளிடவும்..", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(getApplicationContext(), "உங்கள் கடவுச்சொல்லை உள்ளிடவும்...", Toast.LENGTH_SHORT).show();

                } else {


                    final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "தயவுசெய்து காத்திருங்கள்...", "செயலாக்க...", true);
                    (firebaseAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()))
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "உள்நுழைவு வெற்றி", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(MainActivity.this, Paddy.class);
                                        intent.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                                        x = firebaseAuth.getCurrentUser().getEmail();
                                        startActivity(intent);
                                        MainActivity.this.finish();


                                    } else {
                                        Log.e("Error", task.getException().toString());
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

     reg.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i=new Intent(MainActivity.this,Registration.class);
             startActivity(i);
         }
     });


    }



        }

