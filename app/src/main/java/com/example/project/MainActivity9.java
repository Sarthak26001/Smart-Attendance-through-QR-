package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity9 extends AppCompatActivity {

    DatabaseReference reff;
    SwitchCompat status1;
    String data;
    String total;
    String Dep;
    String Shift;
    String Year;
    String sub;
    String Date;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        status1=(SwitchCompat)findViewById(R.id.status);
        b1=(Button)findViewById(R.id.b1);
        Intent i=getIntent();
        Dep=i.getStringExtra("Dep");
        Shift=i.getStringExtra("Shift");
        Year=i.getStringExtra("Year");
        sub=i.getStringExtra("Sub");
        Date=i.getStringExtra("Date");
        //total=i.getStringExtra("total");
        //data=i.getStringExtra("data");
        data=Dep+Year+Shift+"-"+sub+"-"+Date;
       // total=i.getStringExtra("total");
        String e1a[]=data.split("-");

        reff = FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1a[0]).child(e1a[1]);
        Query checkuser=reff;

        status1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(getApplicationContext(),"Status On",Toast.LENGTH_LONG).show();
                    reff.child("status").setValue("On");

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Status Off",Toast.LENGTH_LONG).show();
                    reff.child("status").setValue("Off");
                }



            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String ss=snapshot.child("total").getValue().toString();
                        Intent i = new Intent(MainActivity9.this,MainActivity.class);
                        i.putExtra("data", data);
                        i.putExtra("total", ss);
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