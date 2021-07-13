package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomePage extends AppCompatActivity {

    ImageView attendence,nd,sa,mt,feedback,pass;
    DatabaseReference reff;
    String eno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        attendence=(ImageView) findViewById(R.id.attendence1);
        nd=(ImageView)findViewById(R.id.nd);
        sa=(ImageView)findViewById(R.id.sa);
        mt=(ImageView)findViewById(R.id.mt);
        feedback=(ImageView)findViewById(R.id.feedback);
        pass=(ImageView)findViewById(R.id.pass);
        reff= FirebaseDatabase.getInstance().getReference("Exam_Seats").child("status");

        Intent i = getIntent();
        eno = i.getStringExtra("eno");
        attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Attendence2.class);
                i.putExtra("eno", eno);
                startActivity(i);

            }
        });
        nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,RetrievePDF.class);
                startActivity(i);
            }
        });

        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 reff.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot snapshot) {
                       if(snapshot.getValue().toString().equals("On")) {
                           Intent i = new Intent(HomePage.this, Ex_seats.class);
                           i.putExtra("eno", eno);
                           startActivity(i);
                       }
                     else
                       {
                           Toast.makeText(getApplicationContext(),"Currently not available!!",Toast.LENGTH_LONG).show();
                       }
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError error) {

                     }
                 });

            }
        });

        mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,StudCode.class);
                startActivity(i);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this,StudentFeedback.class);
                i.putExtra("eno", eno);
                startActivity(i);
            }
        });
pass.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(HomePage.this,ChangePassword.class);
        i.putExtra("eno", eno);
        startActivity(i);
    }
});
    }}
