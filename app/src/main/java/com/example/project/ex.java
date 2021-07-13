package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ex extends AppCompatActivity {
    Button b1;

    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex);
        b1=(Button)findViewById(R.id.b1);


        reff= FirebaseDatabase.getInstance().getReference("Attendence").child("CO31").child("MAD");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff.child("FS17CO015").setValue("70");
                Intent i=new Intent(ex.this,Login.class);
                startActivity(i);

            }
        });

    }
}