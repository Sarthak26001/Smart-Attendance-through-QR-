package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.camera2.params.BlackLevelPattern;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class RetrievePDF extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<PutPDF> uploadedPDF;
    FirebaseStorage storage;
    StorageReference storageRef,pathReference,gsReference,httpsReference,islandRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_p_d_f);
        //Intent intent=new Intent(this,MainActivity.class);

        listView=findViewById(R.id.listView);
        uploadedPDF=new ArrayList<>();
        retrievPDFFile();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PutPDF putPDF=uploadedPDF.get(i);
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setType("application/pdf");
                intent.setData(Uri.parse(putPDF.url));
                startActivity(intent);



            }
        });

    }

    private void retrievPDFFile() {
        databaseReference= FirebaseDatabase.getInstance().getReference("project1");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    PutPDF putPDF=ds.getValue(PutPDF.class);
                    uploadedPDF.add(putPDF);

                }

                String[] uploadsName=new String[uploadedPDF.size()];
                for (int i=0;i < uploadsName.length;i++){
                    uploadsName[i]=uploadedPDF.get(i).getName();
                }

                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_expandable_list_item_1,uploadsName){

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view =super.getView(position, convertView, parent);
                        TextView textView=(TextView) view
                                .findViewById(android.R.id.text1);

                        textView.setTextColor(Color.WHITE);
                        textView.setTextSize(20);
                        return view;
                    }
                };
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}