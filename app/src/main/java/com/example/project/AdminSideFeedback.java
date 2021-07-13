package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminSideFeedback extends AppCompatActivity {

    EditText e1;
    SwitchCompat s1;
    Button b1;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_side_feedback);



        b1 = (Button) findViewById(R.id.b1);
        e1 = (EditText) findViewById(R.id.e1);
        s1 = (SwitchCompat) findViewById(R.id.switchcompat);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                reff= FirebaseDatabase.getInstance().getReference().child("Feedback").child(e1.getText().toString());
                if(isChecked)
                {
                    reff.child("status").setValue("On");
                    Toast.makeText(getApplicationContext(),"Code Uploaded Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    reff.child("status").setValue("Off");
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminSideFeedback.this,Adfeedback2.class);
                i.putExtra("code",e1.getText().toString());
                startActivity(i);
            }
        });
    }


    }
