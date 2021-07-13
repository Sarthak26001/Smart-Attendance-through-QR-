package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

EditText e1,e2;
Button b1,b2,b3;
DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref= FirebaseDatabase.getInstance().getReference().child("Student_Registration");
                Query checkuser=ref.orderByChild("eno").equalTo(e1.getText().toString());
                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            String password=snapshot.child(e1.getText().toString()).child("password").getValue().toString();
                          if(e2.getText().toString().equals(password))
                          {

                              Intent i = new Intent(Login.this,HomePage.class);
                              i.putExtra("eno",e1.getText().toString());
                              Toast.makeText(getApplicationContext(),"Login Successfully..",Toast.LENGTH_LONG).show();
                              startActivity(i);
                          }
                          else
                          {
                              Toast.makeText(getApplicationContext(),"Login failed!",Toast.LENGTH_LONG).show();

                          }

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Login failed!",Toast.LENGTH_LONG).show();
                        }
                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this,Register.class));
            }
        });

    }
}