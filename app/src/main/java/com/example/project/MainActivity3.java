package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
Button b1,b2;
TextView t1;
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    b1=(Button)findViewById(R.id.b1);
    b2=(Button)findViewById(R.id.b2);
    t1=(TextView)findViewById(R.id.t1);
    Intent i=getIntent();
  //  String att=i.getStringExtra("att");
    String eno=i.getStringExtra("eno");
    String s=i.getStringExtra("s");
    String sa[]=s.split("-");
    reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(sa[0]).child(eno);
    //    int att2=Integer.parseInt(att)+1;
    b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        reff.child(sa[1]).setValue(1);
        t1.setText("Attendence Marked successfully");

    }


});
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent it=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(it);
    }
});

    }}
