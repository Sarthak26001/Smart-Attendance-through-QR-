package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class ADAttendence1 extends AppCompatActivity  {

    EditText e1,e2,e3;
    Button b1,date,b2;
    TextView t1;
    String Date;
    DatabaseReference reff;
    DatePickerDialog.OnDateSetListener setListener;
    String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_attendence1);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        b1=(Button)findViewById(R.id.b1);

        b2=(Button)findViewById(R.id.b2);
        t1=(TextView)findViewById(R.id.t1);


        Calendar c=Calendar.getInstance();
        final int y=c.get(Calendar.YEAR);
        final int d=c.get(Calendar.MONTH);
        final int m=c.get(Calendar.DAY_OF_MONTH);

        Spinner s2=findViewById(R.id.Year);
        Spinner s3=findViewById(R.id.Shift);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.Year,R.layout.support_simple_spinner_dropdown_item);

        s2.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.Shift,R.layout.support_simple_spinner_dropdown_item);

        s3.setAdapter(adapter3);
     t1.setOnClickListener(new View.OnClickListener() {
         @RequiresApi(api = Build.VERSION_CODES.N)
         @Override
         public void onClick(View v) {
             DatePickerDialog dpd=new DatePickerDialog(ADAttendence1.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,y,m,d);
             dpd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
             dpd.show();
         }
     });
        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
             month=month+1;
             Date=d+"/"+month+"/"+year;
             t1.setText(Date);
                }
        };
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String Year=s2.getSelectedItem().toString();
            String shift=s3.getSelectedItem().toString();
            Intent i = new Intent(ADAttendence1.this, MainActivity.class);
            i.putExtra("Year", Year);
            i.putExtra("Shift", shift);
            i.putExtra("Dep", e1.getText().toString());
            i.putExtra("Sub", e2.getText().toString());
            i.putExtra("Date", t1.getText().toString());
//            i.putExtra("total", total);
            startActivity(i);
         /*   reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1.getText().toString()+Year+shift);
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()) {
                        total = snapshot.child(e2.getText().toString()).child("total").getValue().toString();
                    }
                    else
                    {
                        total="0";
                    }
                        Intent i = new Intent(ADAttendence1.this, MainActivity9.class);
                        i.putExtra("Year", Year);
                        i.putExtra("Shift", shift);
                        i.putExtra("Dep", e1.getText().toString());
                        i.putExtra("Sub", e2.getText().toString());
                        i.putExtra("Date", t1.getText().toString());
                        i.putExtra("total", total);
                        startActivity(i);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
*/


        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String Year=s2.getSelectedItem().toString();
            String shift=s3.getSelectedItem().toString();

            Intent i = new Intent(ADAttendence1.this, CheckAttendence.class);
            i.putExtra("Year", Year);
            i.putExtra("Shift", shift);
            i.putExtra("Dep",e1.getText().toString());
            i.putExtra("Sub",e2.getText().toString());

            startActivity(i);
        }
    });

    }



}