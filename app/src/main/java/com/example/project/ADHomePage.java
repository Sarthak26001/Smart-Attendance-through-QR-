package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ADHomePage extends AppCompatActivity {
 ImageView attendence,sta,mt,nu,feedback,studregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_home_page);
        attendence=(ImageView) findViewById(R.id.attendence1);
        sta=(ImageView) findViewById(R.id.sa);
        mt=(ImageView)findViewById(R.id.mt);
        nu=(ImageView)findViewById(R.id.nu);
       studregist=(ImageView)findViewById(R.id.studregist);
        feedback=(ImageView)findViewById(R.id.feedback);
        attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ADHomePage.this,ADAttendence1.class);

                startActivity(i);
            }
        });
        sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ADHomePage.this,ad_ex_seats.class);
                startActivity(i);
            }
        });
        mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ADHomePage.this,MainActivity5.class);

                startActivity(i);
            }
        });
        nu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i=new Intent(ADHomePage.this,MainActivity7.class);
                    startActivity(i);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ADHomePage.this,AdminSideFeedback.class);
                startActivity(i);
            }
        });
        studregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ADHomePage.this,ADreg.class);
                startActivity(i);
            }
        });
        }

    }
