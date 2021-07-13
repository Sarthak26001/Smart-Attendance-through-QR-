package com.example.project;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class T_module extends AppCompatActivity {

    int t;
    DatabaseReference myref;
    Intent intent;
    String examcode;
    EditText Q1,Q1op1,Q1op2,Q1op3,Q1op4,Q1ans;
    EditText Q2,Q2op1,Q2op2,Q2op3,Q2op4,Q2ans;
    EditText Q3,Q3op1,Q3op2,Q3op3,Q3op4,Q3ans;
    EditText Q4,Q4op1,Q4op2,Q4op3,Q4op4,Q4ans;
    EditText Q5,Q5op1,Q5op2,Q5op3,Q5op4,Q5ans;
    EditText Q6,Q6op1,Q6op2,Q6op3,Q6op4,Q6ans;
    EditText Q7,Q7op1,Q7op2,Q7op3,Q7op4,Q7ans;
    EditText Q8,Q8op1,Q8op2,Q8op3,Q8op4,Q8ans;
    EditText Q9,Q9op1,Q9op2,Q9op3,Q9op4,Q9ans;
    EditText Q10,Q10op1,Q10op2,Q10op3,Q10op4,Q10ans;
    EditText Q11,Q11op1,Q11op2,Q11op3,Q11op4,Q11ans;
    EditText Q12,Q12op1,Q12op2,Q12op3,Q12op4,Q12ans;
    EditText Q13,Q13op1,Q13op2,Q13op3,Q13op4,Q13ans;
    EditText Q14,Q14op1,Q14op2,Q14op3,Q14op4,Q14ans;
    EditText Q15,Q15op1,Q15op2,Q15op3,Q15op4,Q15ans;
    EditText Q16,Q16op1,Q16op2,Q16op3,Q16op4,Q16ans;
    EditText Q17,Q17op1,Q17op2,Q17op3,Q17op4,Q17ans;
    EditText Q18,Q18op1,Q18op2,Q18op3,Q18op4,Q18ans;
    EditText Q19,Q19op1,Q19op2,Q19op3,Q19op4,Q19ans;
    EditText Q20,Q20op1,Q20op2,Q20op3,Q20op4,Q20ans;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_module);

        intent=getIntent();
        examcode = intent.getStringExtra("examcode");
        myref =FirebaseDatabase.getInstance().getReference("MyMessage2").child(examcode);

        Q1=findViewById(R.id.q1);
        Q1op1=findViewById(R.id.q1o1);
        Q1op2=findViewById(R.id.q1o2);
        Q1op3=findViewById(R.id.q1o3);
        Q1op4=findViewById(R.id.q1o4);
        Q1ans=findViewById(R.id.q1ans);

        Q2=findViewById(R.id.q2);
        Q2op1=findViewById(R.id.q2o1);
        Q2op2=findViewById(R.id.q2o2);
        Q2op3=findViewById(R.id.q2o3);
        Q2op4=findViewById(R.id.q2o4);
        Q2ans=findViewById(R.id.q2ans);

        Q3=findViewById(R.id.q3);
        Q3op1=findViewById(R.id.q3o1);
        Q3op2=findViewById(R.id.q3o2);
        Q3op3=findViewById(R.id.q3o3);
        Q3op4=findViewById(R.id.q3o4);
        Q3ans=findViewById(R.id.q3ans);

        Q4=findViewById(R.id.q4);
        Q4op1=findViewById(R.id.q4o1);
        Q4op2=findViewById(R.id.q4o2);
        Q4op3=findViewById(R.id.q4o3);
        Q4op4=findViewById(R.id.q4o4);
        Q4ans=findViewById(R.id.q4ans);

        Q5=findViewById(R.id.q5);
        Q5op1=findViewById(R.id.q5o1);
        Q5op2=findViewById(R.id.q5o2);
        Q5op3=findViewById(R.id.q5o3);
        Q5op4=findViewById(R.id.q5o4);
        Q5ans=findViewById(R.id.q5ans);


        Q6=findViewById(R.id.q6);
        Q6op1=findViewById(R.id.q6o1);
        Q6op2=findViewById(R.id.q6o2);
        Q6op3=findViewById(R.id.q6o3);
        Q6op4=findViewById(R.id.q6o4);
        Q6ans=findViewById(R.id.q6ans);


        Q7=findViewById(R.id.q7);
        Q7op1=findViewById(R.id.q7o1);
        Q7op2=findViewById(R.id.q7o2);
        Q7op3=findViewById(R.id.q7o3);
        Q7op4=findViewById(R.id.q7o4);
        Q7ans=findViewById(R.id.q7ans);

        Q8=findViewById(R.id.q8);
        Q8op1=findViewById(R.id.q8o1);
        Q8op2=findViewById(R.id.q8o2);
        Q8op3=findViewById(R.id.q8o3);
        Q8op4=findViewById(R.id.q8o4);
        Q8ans=findViewById(R.id.q8ans);

        Q9=findViewById(R.id.q9);
        Q9op1=findViewById(R.id.q9o1);
        Q9op2=findViewById(R.id.q9o2);
        Q9op3=findViewById(R.id.q9o3);
        Q9op4=findViewById(R.id.q9o4);
        Q9ans=findViewById(R.id.q9ans);

        Q10=findViewById(R.id.q10);
        Q10op1=findViewById(R.id.q10o1);
        Q10op2=findViewById(R.id.q10o2);
        Q10op3=findViewById(R.id.q10o3);
        Q10op4=findViewById(R.id.q10o4);
        Q10ans=findViewById(R.id.q10ans);

        Q11=findViewById(R.id.q11);
        Q11op1=findViewById(R.id.q11o1);
        Q11op2=findViewById(R.id.q11o2);
        Q11op3=findViewById(R.id.q11o3);
        Q11op4=findViewById(R.id.q11o4);
        Q11ans=findViewById(R.id.q11ans);

        Q12=findViewById(R.id.q12);
        Q12op1=findViewById(R.id.q12o1);
        Q12op2=findViewById(R.id.q12o2);
        Q12op3=findViewById(R.id.q12o3);
        Q12op4=findViewById(R.id.q12o4);
        Q12ans=findViewById(R.id.q12ans);

        Q13=findViewById(R.id.q13);
        Q13op1=findViewById(R.id.q13o1);
        Q13op2=findViewById(R.id.q13o2);
        Q13op3=findViewById(R.id.q13o3);
        Q13op4=findViewById(R.id.q13o4);
        Q13ans=findViewById(R.id.q13ans);

        Q14=findViewById(R.id.q14);
        Q14op1=findViewById(R.id.q14o1);
        Q14op2=findViewById(R.id.q14o2);
        Q14op3=findViewById(R.id.q14o3);
        Q14op4=findViewById(R.id.q14o4);
        Q14ans=findViewById(R.id.q14ans);

        Q15=findViewById(R.id.q15);
        Q15op1=findViewById(R.id.q15o1);
        Q15op2=findViewById(R.id.q15o2);
        Q15op3=findViewById(R.id.q15o3);
        Q15op4=findViewById(R.id.q15o4);
        Q15ans=findViewById(R.id.q15ans);

        Q16=findViewById(R.id.q16);
        Q16op1=findViewById(R.id.q16o1);
        Q16op2=findViewById(R.id.q16o2);
        Q16op3=findViewById(R.id.q16o3);
        Q16op4=findViewById(R.id.q16o4);
        Q16ans=findViewById(R.id.q16ans);

        Q17=findViewById(R.id.q17);
        Q17op1=findViewById(R.id.q17o1);
        Q17op2=findViewById(R.id.q17o2);
        Q17op3=findViewById(R.id.q17o3);
        Q17op4=findViewById(R.id.q17o4);
        Q17ans=findViewById(R.id.q17ans);


        Q18=findViewById(R.id.q18);
        Q18op1=findViewById(R.id.q18o1);
        Q18op2=findViewById(R.id.q18o2);
        Q18op3=findViewById(R.id.q18o3);
        Q18op4=findViewById(R.id.q18o4);
        Q18ans=findViewById(R.id.q18ans);

        Q19=findViewById(R.id.q19);
        Q19op1=findViewById(R.id.q19o1);
        Q19op2=findViewById(R.id.q19o2);
        Q19op3=findViewById(R.id.q19o3);
        Q19op4=findViewById(R.id.q19o4);
        Q19ans=findViewById(R.id.q19ans);

        Q20=findViewById(R.id.q20);
        Q20op1=findViewById(R.id.q20o1);
        Q20op2=findViewById(R.id.q20o2);
        Q20op3=findViewById(R.id.q20o3);
        Q20op4=findViewById(R.id.q20o4);
        Q20ans=findViewById(R.id.q20ans);



    }

    public void onButtonClicked(View view) {




        String q1     = Q1.getText().toString();
        String q1op1  = Q1op1.getText().toString();
        String q1op2  = Q1op2.getText().toString();
        String q1op3  = Q1op3.getText().toString();
        String q1op4  =Q1op4.getText().toString();
        String q1ans  =Q1ans.getText().toString();

        myref.child("Question1").child("Question1").setValue(q1);
        myref.child("Question1/Q1_options1").setValue(q1op1);
        myref.child("Question1/Q1_options2").setValue(q1op2);
        myref.child("Question1/Q1_options3").setValue(q1op3);
        myref.child("Question1/Q1_options4").setValue(q1op4);
        myref.child("Question1/Q1_answer").setValue(q1ans);
        //******************************************************************************************


        String q2     = Q2.getText().toString();
        String q2op1  = Q2op1.getText().toString();
        String q2op2  = Q2op2.getText().toString();
        String q2op3  = Q2op3.getText().toString();
        String q2op4  =Q2op4.getText().toString();
        String q2ans  =Q2ans.getText().toString();
        myref.child("Question2/Question2").setValue(q2);
        myref.child("Question2/Q2_options1").setValue(q2op1);
        myref.child("Question2/Q2_options2").setValue(q2op2);
        myref.child("Question2/Q2_options3").setValue(q2op3);
        myref.child("Question2/Q2_options4").setValue(q2op4);
        myref.child("Question2/Q2_answer").setValue(q2ans);
        //******************************************************************************************



        String q3    = Q3.getText().toString();
        String q3op1  = Q3op1.getText().toString();
        String q3op2  = Q3op2.getText().toString();
        String q3op3  = Q3op3.getText().toString();
        String q3op4  = Q3op4.getText().toString();
        String q3ans  =Q3ans.getText().toString();
        myref.child("Question3/Question3").setValue(q3);
        myref.child("Question3/Q3_options1").setValue(q3op1);
        myref.child("Question3/Q3_options2").setValue(q3op2);
        myref.child("Question3/Q3_options3").setValue(q3op3);
        myref.child("Question3/Q3_options4").setValue(q3op4);
        myref.child("Question3/Q3_answer").setValue(q3ans);
        //******************************************************************************************


        String q4     = Q4.getText().toString();
        String q4op1  = Q4op1.getText().toString();
        String q4op2  = Q4op2.getText().toString();
        String q4op3  = Q4op3.getText().toString();
        String q4op4  = Q4op4.getText().toString();
        String q4ans  =Q4ans.getText().toString();
        myref.child("Question4/Question4").setValue(q4);
        myref.child("Question4/Q4_options1").setValue(q4op1);
        myref.child("Question4/Q4_options2").setValue(q4op2);
        myref.child("Question4/Q4_options3").setValue(q4op3);
        myref.child("Question4/Q4_options4").setValue(q4op4);
        myref.child("Question4/Q4_answer").setValue(q4ans);
        //******************************************************************************************



        String q5     = Q5.getText().toString();
        String q5op1  = Q5op1.getText().toString();
        String q5op2  = Q5op2.getText().toString();
        String q5op3  = Q5op3.getText().toString();
        String q5op4  = Q5op4.getText().toString();
        String q5ans  =Q5ans.getText().toString();
        myref.child("Question5/Question5").setValue(q5);
        myref.child("Question5/Q5_options1").setValue(q5op1);
        myref.child("Question5/Q5_options2").setValue(q5op2);
        myref.child("Question5/Q5_options3").setValue(q5op3);
        myref.child("Question5/Q5_options4").setValue(q5op4);
        myref.child("Question5/Q5_answer").setValue(q5ans);
        //******************************************************************************************



        String q6     = Q6.getText().toString();
        String q6op1  = Q6op1.getText().toString();
        String q6op2  = Q6op2.getText().toString();
        String q6op3  = Q6op3.getText().toString();
        String q6op4  = Q6op4.getText().toString();
        String q6ans  =Q6ans.getText().toString();
        myref.child("Question6/Question6").setValue(q6);
        myref.child("Question6/Q6_options1").setValue(q6op1);
        myref.child("Question6/Q6_options2").setValue(q6op2);
        myref.child("Question6/Q6_options3").setValue(q6op3);
        myref.child("Question6/Q6_options4").setValue(q6op4);
        myref.child("Question6/Q6_answer").setValue(q6ans);
//**************************************************************************************************

        String q7     = Q7.getText().toString();
        String q7op1  = Q7op1.getText().toString();
        String q7op2  = Q7op2.getText().toString();
        String q7op3  = Q7op3.getText().toString();
        String q7op4  =Q7op4.getText().toString();
        String q7ans  =Q7ans.getText().toString();
        myref.child("Question7/Question7").setValue(q7);
        myref.child("Question7/Q7_options1").setValue(q7op1);
        myref.child("Question7/Q7_options2").setValue(q7op2);
        myref.child("Question7/Q7_options3").setValue(q7op3);
        myref.child("Question7/Q7_options4").setValue(q7op4);
        myref.child("Question7/Q7_answer").setValue(q7ans);
        //******************************************************************************************


        String q8     = Q8.getText().toString();
        String q8op1  = Q8op1.getText().toString();
        String q8op2  = Q8op2.getText().toString();
        String q8op3  = Q8op3.getText().toString();
        String q8op4  =Q8op4.getText().toString();
        String q8ans  =Q8ans.getText().toString();
        myref.child("Question8/Question8").setValue(q8);
        myref.child("Question8/Q8_options1").setValue(q8op1);
        myref.child("Question8/Q8_options2").setValue(q8op2);
        myref.child("Question8/Q8_options3").setValue(q8op3);
        myref.child("Question8/Q8_options4").setValue(q8op4);
        myref.child("Question8/Q8_answer").setValue(q8ans);
        //******************************************************************************************



        String q9     = Q9.getText().toString();
        String q9op1  = Q9op1.getText().toString();
        String q9op2  = Q9op2.getText().toString();
        String q9op3  = Q9op3.getText().toString();
        String q9op4  =Q9op4.getText().toString();
        String q9ans  =Q9ans.getText().toString();
        myref.child("Question9/Question9").setValue(q9);
        myref.child("Question9/Q9_options1").setValue(q9op1);
        myref.child("Question9/Q9_options2").setValue(q9op2);
        myref.child("Question9/Q9_options3").setValue(q9op3);
        myref.child("Question9/Q9_options4").setValue(q9op4);
        myref.child("Question9/Q9_answer").setValue(q9ans);
        //******************************************************************************************



        String q10     = Q10.getText().toString();
        String q10op1  = Q10op1.getText().toString();
        String q10op2  = Q10op2.getText().toString();
        String q10op3  = Q10op3.getText().toString();
        String q10op4  =Q10op4.getText().toString();
        String q10ans  =Q10ans.getText().toString();
        myref.child("Question10/Question10").setValue(q10);
        myref.child("Question10/Q10_options1").setValue(q10op1);
        myref.child("Question10/Q10_options2").setValue(q10op2);
        myref.child("Question10/Q10_options3").setValue(q10op3);
        myref.child("Question10/Q10_options4").setValue(q10op4);
        myref.child("Question10/Q10_answer").setValue(q10ans);
        //******************************************************************************************



        String q11     = Q11.getText().toString();
        String q11op1  = Q11op1.getText().toString();
        String q11op2  = Q11op2.getText().toString();
        String q11op3  = Q11op3.getText().toString();
        String q11op4  =Q11op4.getText().toString();
        String q11ans  =Q11ans.getText().toString();
        myref.child("Question11/Question11").setValue(q11);
        myref.child("Question11/Q11_options1").setValue(q11op1);
        myref.child("Question11/Q11_options2").setValue(q11op2);
        myref.child("Question11/Q11_options3").setValue(q11op3);
        myref.child("Question11/Q11_options4").setValue(q11op4);
        myref.child("Question11/Q11_answer").setValue(q11ans);
        //******************************************************************************************




        String q12     = Q12.getText().toString();
        String q12op1  = Q12op1.getText().toString();
        String q12op2  = Q12op2.getText().toString();
        String q12op3  = Q12op3.getText().toString();
        String q12op4  =Q12op4.getText().toString();
        String q12ans  =Q12ans.getText().toString();
        myref.child("Question12/Question12").setValue(q12);
        myref.child("Question12/Q12_options1").setValue(q12op1);
        myref.child("Question12/Q12_options2").setValue(q12op2);
        myref.child("Question12/Q12_options3").setValue(q12op3);
        myref.child("Question12/Q12_options4").setValue(q12op4);
        myref.child("Question12/Q12_answer").setValue(q12ans);
        //******************************************************************************************


        String q13    = Q13.getText().toString();
        String q13op1  = Q13op1.getText().toString();
        String q13op2  = Q13op2.getText().toString();
        String q13op3  = Q13op3.getText().toString();
        String q13op4  = Q13op4.getText().toString();
        String q13ans  =Q13ans.getText().toString();
        myref.child("Question13/Question13").setValue(q13);
        myref.child("Question13/Q13_options1").setValue(q13op1);
        myref.child("Question13/Q13_options2").setValue(q13op2);
        myref.child("Question13/Q13_options3").setValue(q13op3);
        myref.child("Question13/Q13_options4").setValue(q13op4);
        myref.child("Question13/Q13_answer").setValue(q13ans);
        //******************************************************************************************



        String q14     = Q14.getText().toString();
        String q14op1  = Q14op1.getText().toString();
        String q14op2  = Q14op2.getText().toString();
        String q14op3  = Q14op3.getText().toString();
        String q14op4  = Q14op4.getText().toString();
        String q14ans  =Q14ans.getText().toString();
        myref.child("Question14/Question14").setValue(q14);
        myref.child("Question14/Q14_options1").setValue(q14op1);
        myref.child("Question14/Q14_options2").setValue(q14op2);
        myref.child("Question14/Q14_options3").setValue(q14op3);
        myref.child("Question14/Q14_options4").setValue(q14op4);
        myref.child("Question14/Q14_answer").setValue(q14ans);
        //******************************************************************************************



        String q15     = Q15.getText().toString();
        String q15op1  = Q15op1.getText().toString();
        String q15op2  = Q15op2.getText().toString();
        String q15op3  = Q15op3.getText().toString();
        String q15op4  = Q15op4.getText().toString();
        String q15ans  =Q15ans.getText().toString();
        myref.child("Question15/Question15").setValue(q15);
        myref.child("Question15/Q15_options1").setValue(q15op1);
        myref.child("Question15/Q15_options2").setValue(q15op2);
        myref.child("Question15/Q15_options3").setValue(q15op3);
        myref.child("Question15/Q15_options4").setValue(q15op4);
        myref.child("Question15/Q15_answer").setValue(q15ans);
        //******************************************************************************************



        String q16     = Q16.getText().toString();
        String q16op1  = Q16op1.getText().toString();
        String q16op2  = Q16op2.getText().toString();
        String q16op3  = Q16op3.getText().toString();
        String q16op4  = Q16op4.getText().toString();
        String q16ans  =Q16ans.getText().toString();
        myref.child("Question16/Question16").setValue(q16);
        myref.child("Question16/Q16_options1").setValue(q16op1);
        myref.child("Question16/Q16_options2").setValue(q16op2);
        myref.child("Question16/Q16_options3").setValue(q16op3);
        myref.child("Question16/Q16_options4").setValue(q16op4);
        myref.child("Question16/Q16_answer").setValue(q16ans);
//**************************************************************************************************



        String q17     = Q17.getText().toString();
        String q17op1  = Q17op1.getText().toString();
        String q17op2  = Q17op2.getText().toString();
        String q17op3  = Q17op3.getText().toString();
        String q17op4  =Q17op4.getText().toString();
        String q17ans  =Q17ans.getText().toString();
        myref.child("Question17/Question17").setValue(q17);
        myref.child("Question17/Q17_options1").setValue(q17op1);
        myref.child("Question17/Q17_options2").setValue(q17op2);
        myref.child("Question17/Q17_options3").setValue(q17op3);
        myref.child("Question17/Q17_options4").setValue(q17op4);
        myref.child("Question17/Q17_answer").setValue(q17ans);
        //******************************************************************************************


        String q18     = Q18.getText().toString();
        String q18op1  = Q18op1.getText().toString();
        String q18op2  = Q18op2.getText().toString();
        String q18op3  = Q18op3.getText().toString();
        String q18op4  =Q18op4.getText().toString();
        String q18ans  =Q18ans.getText().toString();
        myref.child("Question18/Question18").setValue(q18);
        myref.child("Question18/Q18_options1").setValue(q18op1);
        myref.child("Question18/Q18_options2").setValue(q18op2);
        myref.child("Question18/Q18_options3").setValue(q18op3);
        myref.child("Question18/Q18_options4").setValue(q18op4);
        myref.child("Question18/Q18_answer").setValue(q18ans);
        //******************************************************************************************



        String q19     = Q19.getText().toString();
        String q19op1  = Q19op1.getText().toString();
        String q19op2  = Q19op2.getText().toString();
        String q19op3  = Q19op3.getText().toString();
        String q19op4  =Q19op4.getText().toString();
        String q19ans  =Q19ans.getText().toString();
        myref.child("Question19/Question19").setValue(q19);
        myref.child("Question19/Q19_options1").setValue(q19op1);
        myref.child("Question19/Q19_options2").setValue(q19op2);
        myref.child("Question19/Q19_options3").setValue(q19op3);
        myref.child("Question19/Q19_options4").setValue(q19op4);
        myref.child("Question19/Q19_answer").setValue(q19ans);
        //******************************************************************************************



        String q20     = Q20.getText().toString();
        String q20op1  = Q20op1.getText().toString();
        String q20op2  = Q20op2.getText().toString();
        String q20op3  = Q20op3.getText().toString();
        String q20op4  =Q20op4.getText().toString();
        String q20ans  =Q20ans.getText().toString();
        myref.child("Question20/Question20").setValue(q20);
        myref.child("Question20/Q20_options1").setValue(q20op1);
        myref.child("Question20/Q20_options2").setValue(q20op2);
        myref.child("Question20/Q20_options3").setValue(q20op3);
        myref.child("Question20/Q20_options4").setValue(q20op4);
        myref.child("Question20/Q20_answer").setValue(q20ans);

        AlertDialog.Builder builder = new AlertDialog.Builder(T_module.this);

        builder.setMessage("Questions Uploaded Successfully....");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }
}






