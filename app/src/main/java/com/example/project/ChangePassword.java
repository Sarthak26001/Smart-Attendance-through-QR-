package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangePassword extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    DatabaseReference reff;
    String eno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    e1=(EditText)findViewById(R.id.e1);
    e2=(EditText)findViewById(R.id.e2);
    b1=(Button)findViewById(R.id.b1);
    reff= FirebaseDatabase.getInstance().getReference().child("Student_Registration");
        Intent i=getIntent();
        eno=i.getStringExtra("eno");
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(e1.getText().toString().length()>=8) {
                if (e1.getText().toString().equals(e2.getText().toString()))
            {
                reff.child(eno).child("password").setValue(e1.getText().toString());
                Toast.makeText(getApplicationContext(),"Password set",Toast.LENGTH_LONG).show();
            }
            else {
                        Toast.makeText(getApplicationContext(),"Check Confirm password...",Toast.LENGTH_LONG).show();
            }}

                else{
                    Toast.makeText(getApplicationContext(), "Password should be in 8 digit", Toast.LENGTH_LONG).show();

                }     }

    });}}