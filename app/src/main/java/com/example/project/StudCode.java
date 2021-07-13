package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudCode extends AppCompatActivity {
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_code);

        editText = findViewById(R.id.code);
        btn = findViewById(R.id.code_btn);

    }

    public void onClicked(View view) {
        Intent intent = new Intent(this, SModule.class);
        intent.putExtra("SExamcode", editText.getText().toString());
        startActivity(intent);
    }
}