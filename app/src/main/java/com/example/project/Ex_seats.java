package com.example.project;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Ex_seats extends AppCompatActivity {
DatabaseReference reff,reff2;
    String eno;
    String s,value,a,k;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;
    ArrayList list,list1;
    String f;
    TextView t1;
    int b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_seats);
        reff= FirebaseDatabase.getInstance().getReference().child("Exam_Seats");
       // reff2= FirebaseDatabase.getInstance().getReference().child("Exam_Seats");
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b10=(Button)findViewById(R.id.b10);

        b11=(Button)findViewById(R.id.b11);
        b12=(Button)findViewById(R.id.b12);
        b13=(Button)findViewById(R.id.b13);
        b14=(Button)findViewById(R.id.b14);
        b15=(Button)findViewById(R.id.b15);
        b16=(Button)findViewById(R.id.b16);
        b17=(Button)findViewById(R.id.b17);
        b18=(Button)findViewById(R.id.b18);
        b19=(Button)findViewById(R.id.b19);
        b20=(Button)findViewById(R.id.b20);

        b21=(Button)findViewById(R.id.b21);
        b22=(Button)findViewById(R.id.b22);
        b23=(Button)findViewById(R.id.b23);
        b24=(Button)findViewById(R.id.b24);
        b25=(Button)findViewById(R.id.b25);
        b26=(Button)findViewById(R.id.b26);
        b27=(Button)findViewById(R.id.b27);
        b28=(Button)findViewById(R.id.b28);
        b29=(Button)findViewById(R.id.b29);
        b30=(Button)findViewById(R.id.b30);


        t1=(TextView) findViewById(R.id.t1);
        Intent i=getIntent();
        list=new ArrayList<>();
        list1=new ArrayList<>();
        eno=i.getStringExtra("eno");

        reff.addValueEventListener(new ValueEventListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {


                     value=ds.getValue().toString();
                      if(value.equals("On"))
                      {

                      }
                    else if(value.substring(0,6).equals(eno.substring(0,6))&&Integer.parseInt(eno.substring(7,9))>=Integer.parseInt(value.substring(7,9))&&Integer.parseInt(eno.substring(7,9))<=Integer.parseInt(value.substring(17,19)))
                            //&&Integer.parseInt(value.substring(7,9))>=Integer.parseInt(eno.substring(7,9))&&Integer.parseInt(eno.substring(7,9))<=Integer.parseInt(value.substring(17,19)))
                    {
                        a = value;
                        t1.setText(value.substring(20) + ":" + value.substring(0, 6));

                        b = Integer.parseInt(value.substring(7, 9));
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                           // b1.setText(b + " ");

                            if(String.valueOf(b).length()==1) {

                               b1.setText("0"+b);
                            }
                            else
                            {
                                b1.setText(String.valueOf(b));
                            }
                            if(b1.getText().toString().equals(eno.substring(7,9)))
                            b1.setBackgroundColor(R.color.black);
                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b2.setText("0" + b);
                            }
                            else
                            {
                                b2.setText(String.valueOf(b));
                            }
                            if(b2.getText().toString().equals(eno.substring(7,9)))
                                b2.setBackgroundColor(R.color.black);
                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b3.setText("0" + b);
                            }
                            else
                            {
                                b3.setText(String.valueOf(b));
                            }
                            if(b3.getText().toString().equals(eno.substring(7,9)))
                                b3.setBackgroundColor(R.color.black);

                            }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b4.setText("0" + b);
                            }
                            else
                            {
                                b4.setText(String.valueOf(b));
                            }
                            if(b4.getText().toString().equals(eno.substring(7,9)))
                                b4.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b5.setText("0" + b);
                            }
                            else
                            {
                                b5.setText(String.valueOf(b));
                            }
                            if(b5.getText().toString().equals(eno.substring(7,9)))
                                b5.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b6.setText("0" + b);
                            }
                            else
                            {
                                b6.setText(String.valueOf(b));
                            }
                            if(b6.getText().toString().equals(eno.substring(7,9)))
                                b6.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b7.setText("0" + b);
                            }
                            else
                            {
                                b7.setText(String.valueOf(b));
                            }
                            if(b7.getText().toString().equals(eno.substring(7,9)))
                                b7.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b8.setText("0" + b);
                            }
                            else
                            {
                                b8.setText(String.valueOf(b));
                            }
                            if(b8.getText().toString().equals(eno.substring(7,9)))
                                b8.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b9.setText("0" + b);
                            }
                            else
                            {
                                b9.setText(String.valueOf(b));
                            }
                            if(b9.getText().toString().equals(eno.substring(7,9)))
                                b9.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b10.setText("0" + b);
                            }
                            else
                            {
                                b10.setText(String.valueOf(b));
                            }
                            if(b10.getText().toString().equals(eno.substring(7,9)))
                                b10.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                           // b1.setText(b + " ");

                            if(String.valueOf(b).length()==1) {

                               b11.setText("0"+b);
                            }
                            else
                            {
                                b11.setText(String.valueOf(b));
                            }
                            if(b11.getText().toString().equals(eno.substring(7,9)))
                            b11.setBackgroundColor(R.color.black);
                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b12.setText("0" + b);
                            }
                            else
                            {
                                b12.setText(String.valueOf(b));
                            }
                            if(b12.getText().toString().equals(eno.substring(7,9)))
                                b12.setBackgroundColor(R.color.black);
                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b13.setText("0" + b);
                            }
                            else
                            {
                                b13.setText(String.valueOf(b));
                            }
                            if(b13.getText().toString().equals(eno.substring(7,9)))
                                b13.setBackgroundColor(R.color.black);

                            }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b14.setText("0" + b);
                            }
                            else
                            {
                                b14.setText(String.valueOf(b));
                            }
                            if(b14.getText().toString().equals(eno.substring(7,9)))
                                b14.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b15.setText("0" + b);
                            }
                            else
                            {
                                b15.setText(String.valueOf(b));
                            }
                            if(b15.getText().toString().equals(eno.substring(7,9)))
                                b15.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b16.setText("0" + b);
                            }
                            else
                            {
                                b16.setText(String.valueOf(b));
                            }
                            if(b16.getText().toString().equals(eno.substring(7,9)))
                                b16.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b17.setText("0" + b);
                            }
                            else
                            {
                                b17.setText(String.valueOf(b));
                            }
                            if(b17.getText().toString().equals(eno.substring(7,9)))
                                b17.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b18.setText("0" + b);
                            }
                            else
                            {
                                b18.setText(String.valueOf(b));
                            }
                            if(b18.getText().toString().equals(eno.substring(7,9)))
                                b18.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b19.setText("0" + b);
                            }
                            else
                            {
                                b19.setText(String.valueOf(b));
                            }
                            if(b19.getText().toString().equals(eno.substring(7,9)))
                                b19.setBackgroundColor(R.color.black);

                        }
                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b20.setText("0" + b);
                            }
                            else
                            {
                                b20.setText(String.valueOf(b));
                            }
                            if(b20.getText().toString().equals(eno.substring(7,9)))
                                b20.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b21.setText("0" + b);
                            }
                            else
                            {
                                b21.setText(String.valueOf(b));
                            }
                            if(b21.getText().toString().equals(eno.substring(7,9)))
                                b21.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b22.setText("0" + b);
                            }
                            else
                            {
                                b22.setText(String.valueOf(b));
                            }
                            if(b22.getText().toString().equals(eno.substring(7,9)))
                                b22.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b23.setText("0" + b);
                            }
                            else
                            {
                                b23.setText(String.valueOf(b));
                            }
                            if(b23.getText().toString().equals(eno.substring(7,9)))
                                b23.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b24.setText("0" + b);
                            }
                            else
                            {
                                b24.setText(String.valueOf(b));
                            }
                            if(b24.getText().toString().equals(eno.substring(7,9)))
                                b24.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b25.setText("0" + b);
                            }
                            else
                            {
                                b25.setText(String.valueOf(b));
                            }
                            if(b25.getText().toString().equals(eno.substring(7,9)))
                                b25.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b26.setText("0" + b);
                            }
                            else
                            {
                                b26.setText(String.valueOf(b));
                            }
                            if(b26.getText().toString().equals(eno.substring(7,9)))
                                b26.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b27.setText("0" + b);
                            }
                            else
                            {
                                b27.setText(String.valueOf(b));
                            }
                            if(b27.getText().toString().equals(eno.substring(7,9)))
                                b27.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b28.setText("0" + b);
                            }
                            else
                            {
                                b28.setText(String.valueOf(b));
                            }
                            if(b28.getText().toString().equals(eno.substring(7,9)))
                                b28.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b29.setText("0" + b);
                            }
                            else
                            {
                                b29.setText(String.valueOf(b));
                            }
                            if(b29.getText().toString().equals(eno.substring(7,9)))
                                b29.setBackgroundColor(R.color.black);

                        }

                        b = b + 1;
                        if (b <= Integer.parseInt(value.substring(17, 19))) {
                            if(String.valueOf(b).length()==1) {
                                b30.setText("0" + b);
                            }
                            else
                            {
                                b30.setText(String.valueOf(b));
                            }
                            if(b30.getText().toString().equals(eno.substring(7,9)))
                                b30.setBackgroundColor(R.color.black);

                        }




                    }}}



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }});



    }
}