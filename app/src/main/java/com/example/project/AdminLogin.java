package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    Button b1;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        b1=(Button) findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().equals("Admin")&&e2.getText().toString().equals("Admin"))
                {
                    Toast.makeText(getApplicationContext(),"Login Successfully..",Toast.LENGTH_LONG).show();

                    Intent i = new Intent(AdminLogin.this, ADHomePage.class);

                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Failed!..",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}