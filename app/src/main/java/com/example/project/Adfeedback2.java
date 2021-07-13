package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Adfeedback2 extends AppCompatActivity {

    String sv;
    String t;
    TextView t1;
    ListView l;
    ArrayList<String> al;
    ArrayAdapter<String> arrayAdapter;
    DatabaseReference reff;
    Intent i;
    String s[];
    String value,code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adfeedback2);
        l=(ListView)findViewById(R.id.l1);
t1=(TextView)findViewById(R.id.text_exam);
        al=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,al);
        i=getIntent();
         code=i.getStringExtra("code");

        reff= FirebaseDatabase.getInstance().getReference().child("Feedback").child(code);
      reff.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              for(DataSnapshot ds:snapshot.getChildren()) {
                  String s = ds.getKey();
                  value = ds.getValue().toString();
                  sv=s+":"+value;
                  al.add(s);
                  al.remove("status");
                  l.setAdapter(arrayAdapter);

                  l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                      @Override
                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                          AlertDialog.Builder builder = new AlertDialog.Builder(Adfeedback2.this);
                          builder.setTitle(al.get(position)+":");
                          builder.setMessage(snapshot.child(al.get(position)).getValue().toString());
                          builder.show();


                      }
                  });
              }
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });
}}