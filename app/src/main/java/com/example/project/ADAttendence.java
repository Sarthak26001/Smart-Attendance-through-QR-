package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ADAttendence extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Button b1;
   String Dep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_attendence);
        Spinner s=findViewById(R.id.Dep);
        Spinner s2=findViewById(R.id.Year);
        Spinner s3=findViewById(R.id.Shift);
        b1=(Button)findViewById(R.id.b1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Dep,R.layout.support_simple_spinner_dropdown_item);

        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);;
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(ADAttendence.this, AttYear.class);
        i.putExtra("Dep", Dep);
        startActivity(i);
    }
});

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

     Dep=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}