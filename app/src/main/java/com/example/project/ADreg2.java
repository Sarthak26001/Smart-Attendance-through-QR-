package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.mail.Address;
import  javax.mail.Message;
import  javax.mail.MessagingException;
import  javax.mail.PasswordAuthentication;
import javax.mail.Session;
import  javax.mail.Transport;
import javax.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.*;
import java.util.Objects;
import java.util.Properties;

import static javax.mail.internet.InternetAddress.parse;

public class ADreg2 extends AppCompatActivity {

    ListView l;
    String username;
    String password;
   // String message;
    ArrayList<String> al;
    ArrayAdapter<String> arrayAdapter;
    Intent i;
    String Dep;
    String Year;
    String Shift,email;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_dreg2);
        l=(ListView)findViewById(R.id.l1);

        al=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,al);
        i=getIntent();
         Dep=i.getStringExtra("Dep");
         Year=i.getStringExtra("Year");
         Shift=i.getStringExtra("Shift");
        al=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,al);
        reff= FirebaseDatabase.getInstance().getReference().child("Student_Registration");
        Query checkuser=reff.orderByChild("DYS").equalTo(Dep+""+Year+""+Shift);
        checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    String eno=ds.child("eno").getValue().toString();

                    al.add(eno);
                    l.setAdapter(arrayAdapter);
                    l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            AlertDialog.Builder builder = new AlertDialog.Builder(ADreg2.this);
                            builder.setTitle(al.get(position) + ":");
                            builder.setMessage("Firstname: " + snapshot.child(al.get(position)).child("firstname").getValue().toString() + "\n\n" + "Lastname: " + snapshot.child(al.get(position)).child("lastname").getValue().toString() + "\n\n" + "Email: " + snapshot.child(al.get(position)).child("email").getValue().toString() + "\n\n" + "Gender: " + snapshot.child(al.get(position)).child("gender").getValue().toString() + "\n\n" + "Set password: ");
                            final EditText pass = new EditText(ADreg2.this);
                            builder.setView(pass);

                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    username = "sarthakmandlik45@gmail.com";
                                    password = "S@rthak@15";
                                    reff.child(al.get(position)).child("password").setValue(pass.getText().toString());
                                    Toast.makeText(getApplicationContext(),"Password of "+al.get(position)+" Set Successfully",Toast.LENGTH_LONG).show();

                                    Properties p = new Properties();
                                    email = snapshot.child(al.get(position)).child("email").getValue().toString();

                                   Intent i = new Intent(Intent.ACTION_SEND);
                                    i.setData(Uri.parse("mailto:"));
                                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                                    i.putExtra(Intent.EXTRA_SUBJECT, "Password");
                                    i.putExtra(Intent.EXTRA_TEXT, pass.getText().toString());
                                    i.setType("message/rfc822");
                                    startActivity(i);



                                /*    Properties pos=new Properties();
                                    pos.put("mail.smtp.auth","true");
                                    pos.put("mail.smtp.starttls.enable","true");
                                    pos.put("mail.smtp.host","smtp.gmail.com");
                                    pos.put("mail.smtp.port","587");
                                    Session s=Session.getInstance(pos,new javax.mail.Authenticator(){
                                        @Override
                                        protected PasswordAuthentication getPasswordAuthentication() {
                                           return  new PasswordAuthentication(username,password);
                                        }
                                    });
                                    try {


                                        s.setDebug(true);
                                        Message m=new MimeMessage(s);
                                        m.setFrom(new InternetAddress(username));
                                        m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                                        m.setSubject("Password");
                                        m.setText(pass.getText().toString());

                                        Transport.send(m);
                                        Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_LONG).show();
                                    }
                                    catch (MessagingException e)
                                    {
                                        throw  new RuntimeException(e);
                                    }
                                }
                            });
                            StrictMode.ThreadPolicy pl=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                            StrictMode.setThreadPolicy(pl);
*/

                                }
                            });
                            builder.show();
                        }});}}

            @Override
            public void onCancelled(@NonNull DatabaseError error){
                }});}}