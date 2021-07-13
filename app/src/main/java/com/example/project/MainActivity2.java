package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity2 extends AppCompatActivity implements ZXingScannerView.ResultHandler {
ZXingScannerView sv;
DatabaseReference reff,reff2;
String att2=null;
String eno=null;
int att=0;
Intent i;
ArrayList list;
String status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         i=getIntent();
        eno=i.getStringExtra("eno");
        sv=new ZXingScannerView(this);
        setContentView(sv);


    }

    @Override
    public void handleResult(Result result) {


     String s=result.getText().toString();
     String sa[]=s.split("-");

        list=new ArrayList<>();

     reff= FirebaseDatabase.getInstance().getReference("Attendence").child(sa[0]).child(sa[1]).child(eno);

        Query checkuser=reff;
        checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    att2 = snapshot.getValue().toString();
                } else {
                    att2 = "0";
                }
                Intent i = new Intent(MainActivity2.this, MainActivity4.class);
                i.putExtra("att", att2);
                i.putExtra("s", s);
                i.putExtra("eno", eno);
                startActivity(i);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    /*reff.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //if(dataSnapshot.child("status").getValue().toString().equals("On")) {
            if (dataSnapshot.exists()) {
               att2 = dataSnapshot.getValue().toString();
            } else {
                att2 = "0";
            }

            //att2 = String.valueOf(att);


            Intent i = new Intent(MainActivity2.this, MainActivity4.class);
            i.putExtra("att", att2);
            i.putExtra("s", s);
            i.putExtra("eno", eno);
            startActivity(i);
        }
              else

        {
            Intent i = new Intent(MainActivity2.this, Login.class);
            startActivity(i);

        }





        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });*/

    }


    @Override
    protected void onPause() {
        super.onPause();
        sv.stopCamera();
    }

   @Override
    protected void onResume() {
        super.onResume();
        sv.setResultHandler(this);
        sv.startCamera();
    }
}