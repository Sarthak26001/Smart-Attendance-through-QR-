package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ADreg extends AppCompatActivity {

    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_dreg);
        e1=(EditText)findViewById(R.id.e1);
        b1=(Button)findViewById(R.id.b1);
        Spinner s2=findViewById(R.id.Year);
        Spinner s3=findViewById(R.id.Shift);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.Year,R.layout.support_simple_spinner_dropdown_item);

        s2.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.Shift,R.layout.support_simple_spinner_dropdown_item);

        s3.setAdapter(adapter3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ADreg.this, ADreg2.class);
                intent.putExtra("Dep", e1.getText().toString());
                intent.putExtra("Year", s2.getSelectedItem().toString());
                intent.putExtra("Shift", s3.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}