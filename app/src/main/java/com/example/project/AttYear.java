package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.Year;

public class AttYear extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Button b1;
TextView t1;
String Dep;

String Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_year);
        Spinner s2=findViewById(R.id.Year);
        t1=(TextView)findViewById(R.id .t1);
        b1=(Button)findViewById(R.id.b1);
        Intent i=getIntent();
        Dep=i.getStringExtra("Dep");
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.Year,R.layout.support_simple_spinner_dropdown_item);

        s2.setAdapter(adapter2);
        s2.setOnItemSelectedListener(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AttYear.this, AttShift.class);
                i.putExtra("Year", Year);
                i.putExtra("Dep", Dep);
                startActivity(i);
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         Year=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}