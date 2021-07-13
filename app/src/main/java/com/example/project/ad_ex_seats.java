package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ad_ex_seats extends AppCompatActivity {
EditText e1,e2;
Button b1;
SwitchCompat status;
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_ex_seats);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1=(Button)findViewById(R.id.b1);
        status=findViewById(R.id.switchcompat);
        reff= FirebaseDatabase.getInstance().getReference().child("Exam_Seats");
        status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //reff= FirebaseDatabase.getInstance().getReference().child("Feedback").child(e1.getText().toString());
                if(isChecked)
                {
                    reff.child("status").setValue("On");
                }
                else
                {
                    reff.child("status").setValue("Off");

                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff.child(e1.getText().toString()).setValue(e2.getText().toString()+":"+e1.getText().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(ad_ex_seats.this);

                builder.setMessage("Detalis Uploaded..........");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

            }
        });

    }
}