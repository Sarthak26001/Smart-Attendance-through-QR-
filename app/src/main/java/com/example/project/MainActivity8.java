package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity8 extends AppCompatActivity {

    DatabaseReference reff;
    int att2;
    String att3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        b1=(Button)findViewById(R.id.b1);
        Intent i = getIntent();
        String att = i.getStringExtra("att");
        String eno = i.getStringExtra("eno");
        String s = i.getStringExtra("s");
        att2 = Integer.parseInt(att) + 1;
        att3 = String.valueOf(att2);

        String sa[] = s.split("-");
        reff = FirebaseDatabase.getInstance().getReference().child("Attendence").child(sa[0]).child(sa[1]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("status").getValue().toString().equals("On"))
                        {
                            reff.child(eno).setValue(att3);
                            Toast.makeText(getApplicationContext(),"Attendence marked successfully",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity8.this,HomePage.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Currently not available!!",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
    }

    }


