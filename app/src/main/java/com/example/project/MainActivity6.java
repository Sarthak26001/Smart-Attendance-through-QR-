 package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity6 extends AppCompatActivity {
    TextView Q1,Q2,Q3,Q4,Q5,Q6;
    RadioButton f1o1,f1o2,f1o3;
    RadioButton f2o1,f2o2,f2o3;
    RadioButton f3o1,f3o2,f3o3;
    RadioButton f4o1,f4o2,f4o3;
    RadioButton f5o1,f5o2,f5o3;
    RadioButton f6o1,f6o2,f6o3;
    Button b1;
    String result;
    Intent i;
    String eno,code;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        b1=findViewById(R.id.b1);
        Q1=findViewById(R.id.fq1);
        f1o1=findViewById(R.id.f1o1);
        f1o2=findViewById(R.id.f1o2);
        f1o3=findViewById(R.id.f1o3);

        Q2=findViewById(R.id.fq2);
        f2o1=findViewById(R.id.f2o1);
        f2o2=findViewById(R.id.f2o2);
        f2o3=findViewById(R.id.f2o3);

        Q3=findViewById(R.id.fq3);
        f3o1=findViewById(R.id.f3o1);
        f3o2=findViewById(R.id.f3o2);
        f3o3=findViewById(R.id.f3o3);

        Q4=findViewById(R.id.fq4);
        f4o1=findViewById(R.id.f4o1);
        f4o2=findViewById(R.id.f4o2);
        f4o3=findViewById(R.id.f4o3);

        Q5=findViewById(R.id.fq5);
        f5o1=findViewById(R.id.f5o1);
        f5o2=findViewById(R.id.f5o2);
        f5o3=findViewById(R.id.f5o3);

        Q6=findViewById(R.id.fq6);
        f6o1=findViewById(R.id.f6o1);
        f6o2=findViewById(R.id.f6o2);
        f6o3=findViewById(R.id.f6o3);
        i=getIntent();
        eno=i.getStringExtra("eno");
        code=i.getStringExtra("code");
        reff= FirebaseDatabase.getInstance().getReference("Feedback").child(code);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(f1o1.isChecked())
                {
                    result="1. "+f1o1.getText().toString()+"\n";
                }
                else if(f1o2.isChecked())
                {
                    result="1. "+f1o2.getText().toString()+"\n";
                }
                else if(f1o3.isChecked())
                {
                    result="1. "+f1o3.getText().toString()+"\n";
                }
                else
                {

                }

                if(f2o1.isChecked())
                {
                    result=result.concat("2. "+f2o1.getText().toString()+"\n");

                }
                else if(f2o2.isChecked())
                {
                    result=result.concat("2. "+f2o2.getText().toString()+"\n");

                }
                else if(f2o3.isChecked())
                {
                    result=result.concat("2. "+f2o3.getText().toString()+"\n");

                }
                else {}
                if(f3o1.isChecked())
                {
                    result=result.concat("3. "+f3o1.getText().toString()+"\n");

                }
                else if(f3o2.isChecked())
                {
                    result=result.concat("3. "+f3o2.getText().toString()+"\n");

                }
                else if(f3o3.isChecked())
                {
                    result=result.concat("3. "+f3o3.getText().toString()+"\n");

                }
                else {}
                if(f4o1.isChecked())
                {
                    result=result.concat("4. "+f4o1.getText().toString()+"\n");

                }
                else if(f4o2.isChecked())
                {
                    result=result.concat("4. "+f4o2.getText().toString()+"\n");

                }
                else if(f4o3.isChecked())
                {
                    result=result.concat("4. "+f4o3.getText().toString()+"\n");

                }
                else {}
                if(f5o1.isChecked())
                {
                    result=result.concat("5. "+f5o1.getText().toString()+"\n");

                }
                else if(f5o2.isChecked())
                {
                    result=result.concat("5. "+f5o2.getText().toString()+"\n");

                }
                else if(f5o3.isChecked())
                {
                    result=result.concat("5. "+f5o3.getText().toString()+"\n");

                }else {}
                if(f6o1.isChecked())
                {
                    result=result.concat("6. "+f6o1.getText().toString()+"\n");

                }
                else if(f6o2.isChecked())
                {
                    result=result.concat("6. "+f6o2.getText().toString()+"\n");

                }
                else if(f6o3.isChecked())
                {
                    result=result.concat("6. "+f6o3.getText().toString()+"\n");

                }else {}
                reff.child(eno).setValue(result);
                Toast.makeText(getApplicationContext(),"Feedback submited",Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity6.this,StartingPage.class);
                startActivity(i);
                // b1.setText(result);
                /*reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("status").getValue().toString().equals("On"))
                        {
                            reff.child(eno).setValue(result);

                            Intent i = new Intent(MainActivity6.this,StartingPage.class);
                            startActivity(i);
                            Toast.makeText(getApplicationContext(),"Feedback submited",Toast.LENGTH_LONG).show();
                        }

            }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });*/


    }
});}}