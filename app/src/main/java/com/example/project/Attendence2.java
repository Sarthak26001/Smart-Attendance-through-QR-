package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Attendence2 extends AppCompatActivity {

    Button scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence2);
        scan=(Button) findViewById(R.id.scan);
        Intent i=getIntent();
        String eno=i.getStringExtra("eno");
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Attendence2.this,MainActivity2.class);
                i.putExtra("eno",eno);
                startActivity(i);
            }
        });

    }
}