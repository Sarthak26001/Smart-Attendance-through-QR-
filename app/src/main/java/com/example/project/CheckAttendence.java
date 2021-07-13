package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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

public class CheckAttendence extends AppCompatActivity {
DatabaseReference reff;
    String Dep;
    String Shift;
    String Year;
    String ss;
    String sub;
    ListView lv;
    ArrayList<String> list;
    TextView t1;
    float per=0;
    String value;
    int total;
    ArrayAdapter<String> adapter;
    Attendence a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_attendence);
                lv=(ListView)findViewById(R.id.l1);
        //t1=(TextView)findViewById(R.id.t1);
                Intent i=getIntent();
                Dep=i.getStringExtra("Dep");
                Shift=i.getStringExtra("Shift");
                Year=i.getStringExtra("Year");
                sub=i.getStringExtra("Sub");
                list=new ArrayList<>();
                a=new Attendence();
                adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(Dep+Year+Shift).child(sub);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 total =Integer.parseInt(snapshot.child("total").getValue().toString());

                for(DataSnapshot ds:snapshot.getChildren())
                {
                    String s = ds.getKey();
                value=ds.getValue().toString();
                 //   TextView textView=findViewById(android.R.id.text1);
                   // textView.setTextColor(Color.WHITE);

                // t1.setText(value);

                  //   per=Integer.parseInt(ds.getValue().toString())/6*100;
                // list.add(s+" : "+value+" : "+per);


                //   if(value.equals("On")||value.equals("Off")){

                 //value="0";
                   // }
            //    list.add(s+" : "+value+" : "+((Float.parseFloat(value)) / total) * 100 + " %");
              //     list.remove("status"+" : "+"0"+" : "+0.0+ " %");
               list.add(s);
               list.remove("status");
               list.remove("total");
                    list.remove("Current_QR");
               lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CheckAttendence.this);
                        builder.setTitle(list.get(position));
                     //   ((Float.parseFloat(value)) / total) * 100 + " %
                        ss =String.valueOf(snapshot.child(list.get(position)).getValue());
                        builder.setMessage("Attendance : "+ss+" / "+total+"\n"+"Percentage : "+Float.parseFloat(ss)/total * 100+"%");
                        builder.show();


                    }
                });
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}