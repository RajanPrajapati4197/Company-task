package com.example.internship_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText etemail,etpassword;
    Button btnlogin;
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etemail=(EditText)findViewById(R.id.editTextTextPersonName5);
        etpassword=(EditText)findViewById(R.id.editTextTextPersonName7);
        btnlogin=(Button)findViewById(R.id.button2);
        db=new databasehelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=etemail.getText().toString();
                String pass=etpassword.getText().toString();
                Boolean checklogin=db.emailpassword(mail,pass);
                if(checklogin==true){
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}