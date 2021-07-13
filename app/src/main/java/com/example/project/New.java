package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class New extends AppCompatActivity {
Button b1;
DatabaseReference reff;
String data;
String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    b1=(Button)findViewById(R.id.b1);
        Intent i=getIntent();
        data=i.getStringExtra("data");
        total=i.getStringExtra("total");
        String e1a[]=data.split("-");
        reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1a[0]).child(e1a[1]);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           reff.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {

                  String t=snapshot.child("status").getValue().toString();
                   int total1=Integer.parseInt(total)+1;
                   reff.child("total").setValue(total1);
                   Toast.makeText(getApplicationContext(),"Total incremented",Toast.LENGTH_LONG).show();
                   Intent i = new Intent(New.this,ADHomePage.class);
                   startActivity(i);

               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {

               }
           });

        }
    });
    }
}