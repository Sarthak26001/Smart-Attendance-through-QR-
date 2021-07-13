package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Intent intent;
    float percent;
    int marks;
    ConstraintLayout constraintLayout;
    TextView textView,percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent=getIntent();
        // marks = intent.getStringExtra("result");
        marks=intent.getIntExtra("result",marks);
        //percent=marks/20*100;
        if(marks>7) {
            setContentView(R.layout.activity_result);

        }
        else {
            setContentView(R.layout.result2);
        }
        String m1=String.valueOf(marks);
        percent=Float.parseFloat(m1)/20*100;
        textView=findViewById(R.id.r_marks);
        percentage=findViewById(R.id.percent);
        textView.setText(marks+"/20");
        percentage.setText("Percentage : "+percent+"%");

    }
}