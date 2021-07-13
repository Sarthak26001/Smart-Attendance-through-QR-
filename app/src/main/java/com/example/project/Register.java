package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1;
    RadioGroup rg;
    RadioButton r1,r2;
    DatabaseReference ref;
    Registration r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
       
        e7=(EditText)findViewById(R.id.e7);
        b1=(Button) findViewById(R.id.b1);
        rg=(RadioGroup) findViewById(R.id.rg);
        r1=(RadioButton) findViewById(R.id.r1);
        r2=(RadioButton) findViewById(R.id.r2);
        Spinner s2=findViewById(R.id.Year);
        Spinner s3=findViewById(R.id.Shift);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.Year,R.layout.support_simple_spinner_dropdown_item);

        s2.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.Shift,R.layout.support_simple_spinner_dropdown_item);

        s3.setAdapter(adapter3);

        r=new Registration();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref= FirebaseDatabase.getInstance().getReference().child("Student_Registration");
                r.setFirstname(e1.getText().toString());
                 r.setLastname(e2.getText().toString());
                 r.setEno(e3.getText().toString());
                 r.setEmail(e4.getText().toString());

                if(r1.isChecked())
                {
                    r.setGender(r1.getText().toString());
                }
                if(r2.isChecked())
                {
                    r.setGender(r2.getText().toString());
                }

                        ref.child(e3.getText().toString()).setValue(r);

                        ref.child(e3.getText().toString()).child("Dep").setValue(e7.getText().toString());
                        ref.child(e3.getText().toString()).child("Year").setValue(s2.getSelectedItem().toString());
                        ref.child(e3.getText().toString()).child("Shift").setValue(s3.getSelectedItem().toString());
                        ref.child(e3.getText().toString()).child("DYS").setValue(e7.getText().toString()+""+s2.getSelectedItem().toString()+""+s3.getSelectedItem().toString());
                        AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);

                        builder.setMessage("Register Successfully........");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        //startActivity(new Intent(Register.this,Login.class));
                    }


            });}}