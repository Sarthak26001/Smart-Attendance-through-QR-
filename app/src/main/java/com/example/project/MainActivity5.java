package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button;
    //public static String examcode;
    EditText editText;
    public static String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button=findViewById(R.id.mybutton);

        editText=findViewById(R.id.examcode);

    }

    public void run(View view) {
        Intent intent = new Intent(this, T_module.class);
        intent.putExtra("examcode",editText.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selected = adapterView.getItemAtPosition(i).toString();
        System.out.println(selected);
        Toast.makeText(this,selected,Toast.LENGTH_SHORT).show();
        n=selected;

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}