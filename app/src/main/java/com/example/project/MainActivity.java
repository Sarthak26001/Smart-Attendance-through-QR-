package com.example.project;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.nfc.tech.NfcBarcode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.*;
import android.widget.Toast;

import com.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
public static EditText e1,e2;
SwitchCompat status1;
Button b1,b2,s;
ImageView i1;
DatabaseReference reff;
String Dep;
String Shift;
String Year;
String sub;
String Date;
String total;
String data;
private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=(ImageView)findViewById(R.id.i1);
        status1=(SwitchCompat)findViewById(R.id.status);
        b1=(Button) findViewById(R.id.b1);
      //  s=(Button) findViewById(R.id.s);
        Intent i=getIntent();
        Dep=i.getStringExtra("Dep");
        Shift=i.getStringExtra("Shift");
        Year=i.getStringExtra("Year");
        sub=i.getStringExtra("Sub");
        Date=i.getStringExtra("Date");
        //total=i.getStringExtra("total");
        //data=i.getStringExtra("data");
        data=Dep+Year+Shift+"-"+sub+"-"+Date;
        //data=i.getStringExtra("data");
      //  total=i.getStringExtra("total");


        String e1a[]=data.split("-");

        reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1a[0]).child(e1a[1]);
        Query checkuser=reff;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d = data;
                QRGEncoder qrgEncoder = new QRGEncoder(d, null, QRGContents.Type.TEXT, 100);
                Bitmap bitmap = qrgEncoder.getBitmap();
                i1.setImageBitmap(bitmap);
                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            total = snapshot.child("total").getValue().toString();
                        } else {
                            total = "0";
                        }
                      //  total=snapshot.child("total").getValue().toString();
                        int total1=Integer.parseInt(total)+1;
                        reff.child("total").setValue(total1);
                        reff.child("Current_QR").setValue(data);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }});

   /*     s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.getText().toString().equals("Status Off"))
                {
                    reff.child("status").setValue("On");
                    s.setText("Status On");
                }
                else
                {
                    reff.child("status").setValue(null);
                    s.setText("Status Off");
                }
            }
        });
*/
            status1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //String e1a[]=data.split("-");
      //  reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1a[0]);
    checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            //String ss=snapshot.child("status").getValue().toString();
            //   total=snapshot.child("total").getValue().toString();

            if(isChecked)
            {

               // int total1=Integer.parseInt(total)+1;
               // reff.child("total").setValue(total1);
                reff.child("status").setValue("On");
                Toast.makeText(getApplicationContext(),"Status On",Toast.LENGTH_LONG).show();
             //   Intent i = new Intent(MainActivity.this, Splashscreen.class);
//            i.putExtra("data", data);

                //    i.putExtra("Dep", e1.getText().toString());
                //   i.putExtra("total", total);
               // startActivity(i);
                //int total1=Integer.parseInt(total)+1;
                //reff.child("total").setValue(total1);
                //reff.child("status").setValue("On");
                //               Intent i = new Intent(MainActivity.this,New.class);
                //             i.putExtra("data", data);
                //           i.putExtra("total", total);
                //         startActivity(i);

                //Toast.makeText(getApplicationContext(),"Status is On...",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Status Off",Toast.LENGTH_LONG).show();
                reff.child("status").setValue("Off");
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
 /*   reff.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
       String ss=snapshot.child("status").getValue().toString();
          //   total=snapshot.child("total").getValue().toString();

            if(isChecked)
            {

                int total1=Integer.parseInt(total)+1;
                reff.child("total").setValue(total1);
                reff.child("status").setValue("Off");
                Toast.makeText(getApplicationContext(),"Total incremented",Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, Splashscreen.class);
//            i.putExtra("data", data);

        //    i.putExtra("Dep", e1.getText().toString());
         //   i.putExtra("total", total);
            startActivity(i);
                //int total1=Integer.parseInt(total)+1;
                //reff.child("total").setValue(total1);
                //reff.child("status").setValue("On");
 //               Intent i = new Intent(MainActivity.this,New.class);
   //             i.putExtra("data", data);
     //           i.putExtra("total", total);
       //         startActivity(i);

                //Toast.makeText(getApplicationContext(),"Status is On...",Toast.LENGTH_LONG).show();
            }
            else {

                //reff.child("status").setValue("Off");
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

        }
        });}}
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                         String ss=snapshot.getValue().toString();
                        String d=data;
                        QRGEncoder qrgEncoder=new QRGEncoder(d,null, QRGContents.Type.TEXT,100);
                        Bitmap bitmap=qrgEncoder.getBitmap();
                        i1.setImageBitmap(bitmap);


                        int total1=Integer.parseInt(total)+1;
                        //   reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1a[0]).child(e1a[1]).child("total");
                        reff.child(total).setValue(total1);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });

status1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String e1a[]=data.split("-");
        reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1a[0]);
        if(isChecked)
        {
            reff.child("status").setValue("On");
            Toast.makeText(getApplicationContext(),"Status is On...",Toast.LENGTH_LONG).show();
        }
        else {

            reff.child("status").setValue("Off");
        }

    }
});}}

           /* String e1a[]=data.split("-");
            reff= FirebaseDatabase.getInstance().getReference().child("Attendence").child(e1a[0]);

            if(status.getText().toString().equals("Status Off")) {
                reff.child(e1a[1]).child("status").setValue("On");
                status.setText("Status On");

            }
            else if(status.getText().toString().equals("Status On"))
            {
                reff.child(e1a[1]).child("status").setValue("Off");
                status.setText("Status Off");

            }}


    }
}*/}});}}