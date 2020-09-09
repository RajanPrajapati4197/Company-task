package com.example.internship_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    databasehelper dbhelper;
    EditText et1,et2,et3,et4;
    Button btnreg;
    TextView tvlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper=new databasehelper(this);
        et1=(EditText)findViewById(R.id.editTextTextPersonName);
        et2=(EditText)findViewById(R.id.editTextTextPersonName2);
        et3=(EditText)findViewById(R.id.editTextTextPersonName3);
        et4=(EditText)findViewById(R.id.editTextTextPersonName4);
        btnreg=(Button)findViewById(R.id.button);
        tvlogin=(TextView)findViewById(R.id.textView);

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=et1.getText().toString();
                String s2=et2.getText().toString();
                String s3=et3.getText().toString();
                String s4=et4.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"fields are empty",Toast.LENGTH_SHORT);
                }
                else {
                    if(s3.equals(s4)){
                        Boolean checkmail=dbhelper.checkmail(s2);
                        if(checkmail==true){
                            Boolean insert= dbhelper.insert(s1,s2,s3);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registerd",Toast.LENGTH_SHORT);
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"email already exists",Toast.LENGTH_SHORT);
                        }
                    }
                    Toast.makeText(getApplicationContext(),"password not match",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}