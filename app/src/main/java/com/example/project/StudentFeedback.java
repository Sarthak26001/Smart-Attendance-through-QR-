package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class StudentFeedback extends AppCompatActivity {

    EditText e1;
    Button b1;
    DatabaseReference reff;
    Intent i;
    String eno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feedback);

        e1=findViewById(R.id.e1);
        b1=findViewById(R.id.code_btn);

        i=getIntent();

        eno=i.getStringExtra("eno");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reff= FirebaseDatabase.getInstance().getReference("Feedback").child(e1.getText().toString());
                Query checkuser=reff;
                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.child("status").getValue().toString().equals("On"))
                        {
                            //  b1.setText(eno+" "+e1.getText().toString());
                            Intent i=new Intent(StudentFeedback.this,MainActivity6.class);
                            i.putExtra("eno",eno);
                            i.putExtra("code",e1.getText().toString());
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
                /*reff.addValueEventListener(new ValueEventListener() {
                   @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("status").getValue().toString().equals("On"))
                        {
                          //  b1.setText(eno+" "+e1.getText().toString());
                            Intent i=new Intent(StudentFeedback.this,MainActivity6.class);
                            i.putExtra("eno",eno);
                            i.putExtra("code",e1.getText().toString());
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
                });*/
            }
        });
    }
}