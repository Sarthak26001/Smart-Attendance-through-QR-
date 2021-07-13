package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AttSub extends AppCompatActivity
        //implements AdapterView.OnItemSelectedListener
        {

    Button b1;
    String Dep;
    String Year;
    String Shift;
    TextView t1;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_sub);
        Spinner s3=findViewById(R.id.Shift);
        b1=(Button)findViewById(R.id.b1);
        t1=(TextView)findViewById(R.id.t1);
        Intent i=getIntent();
        Dep=i.getStringExtra("Dep");
        Shift=i.getStringExtra("Shift");
        Year=i.getStringExtra("Year");

        String node=Dep.concat(Year);
        String node1=node.concat(Shift);

        ref= FirebaseDatabase.getInstance().getReference().child(node1);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot d:snapshot.getChildren()) {
                    String a=String.valueOf(d.getChildren());
                    t1.setText(a);
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

/*        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.Shift,R.layout.support_simple_spinner_dropdown_item);

        s3.setAdapter(adapter3);
        s3.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}}