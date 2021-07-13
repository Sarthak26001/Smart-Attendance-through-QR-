package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.time.Year;

public class AttShift extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
String Shift;
Button b1;
String Dep;
String Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_shift);
        Spinner s3=findViewById(R.id.Shift);
        b1=(Button)findViewById(R.id.b1);
        Intent i=getIntent();
        Dep=i.getStringExtra("Dep");
        Year=i.getStringExtra("Year");

        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.Shift,R.layout.support_simple_spinner_dropdown_item);

        s3.setAdapter(adapter3);
        s3.setOnItemSelectedListener(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AttShift.this, AttSub.class);
                i.putExtra("Year", Year);
                i.putExtra("Dep", Dep);
                i.putExtra("Shift", Shift);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Shift=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}