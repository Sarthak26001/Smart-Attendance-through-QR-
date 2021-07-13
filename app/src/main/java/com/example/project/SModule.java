package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SModule extends AppCompatActivity {
    Intent intent,intent1;
    TextView Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14,Q15,Q16,Q17,Q18,Q19,Q20;
    RadioButton Q1op1,Q1op2,Q1op3,Q1op4;
    RadioButton Q2op1,Q2op2,Q2op3,Q2op4;
    RadioButton Q3op1,Q3op2,Q3op3,Q3op4;
    RadioButton Q4op1,Q4op2,Q4op3,Q4op4;
    RadioButton Q5op1,Q5op2,Q5op3,Q5op4;
    RadioButton Q6op1,Q6op2,Q6op3,Q6op4;
    RadioButton Q7op1,Q7op2,Q7op3,Q7op4;
    RadioButton Q8op1,Q8op2,Q8op3,Q8op4;
    RadioButton Q9op1,Q9op2,Q9op3,Q9op4;
    RadioButton Q10op1,Q10op2,Q10op3,Q10op4;
    RadioButton Q11op1,Q11op2,Q11op3,Q11op4;
    RadioButton Q12op1,Q12op2,Q12op3,Q12op4;
    RadioButton Q13op1,Q13op2,Q13op3,Q13op4;
    RadioButton Q14op1,Q14op2,Q14op3,Q14op4;
    RadioButton Q15op1,Q15op2,Q15op3,Q15op4;
    RadioButton Q16op1,Q16op2,Q16op3,Q16op4;
    RadioButton Q17op1,Q17op2,Q17op3,Q17op4;
    RadioButton Q18op1,Q18op2,Q18op3,Q18op4;
    RadioButton Q19op1,Q19op2,Q19op3,Q19op4;
    RadioButton Q20op1,Q20op2,Q20op3,Q20op4;


    String value,s,SExamcode;
    TextView mark;
    DatabaseReference reference;
    Button marks_btn;
    int marks=0;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_module);

        list=new ArrayList<>();
        mark=findViewById(R.id.marks);
        marks_btn=findViewById(R.id.marks_btn);




        Q1=findViewById(R.id.q1);
        Q1op1=findViewById(R.id.q1op1);
        Q1op2=findViewById(R.id.q1op2);
        Q1op3=findViewById(R.id.q1op3);
        Q1op4=findViewById(R.id.q1op4);

        Q2=findViewById(R.id.q2);
        Q2op1=findViewById(R.id.q2op1);
        Q2op2=findViewById(R.id.q2op2);
        Q2op3=findViewById(R.id.q2op3);
        Q2op4=findViewById(R.id.q2op4);

        Q3=findViewById(R.id.q3);
        Q3op1=findViewById(R.id.q3op1);
        Q3op2=findViewById(R.id.q3op2);
        Q3op3=findViewById(R.id.q3op3);
        Q3op4=findViewById(R.id.q3op4);

        Q4=findViewById(R.id.q4);
        Q4op1=findViewById(R.id.q4op1);
        Q4op2=findViewById(R.id.q4op2);
        Q4op3=findViewById(R.id.q4op3);
        Q4op4=findViewById(R.id.q4op4);

        Q5=findViewById(R.id.q5);
        Q5op1=findViewById(R.id.q5op1);
        Q5op2=findViewById(R.id.q5op2);
        Q5op3=findViewById(R.id.q5op3);
        Q5op4=findViewById(R.id.q5op4);

        Q6=findViewById(R.id.q6);
        Q6op1=findViewById(R.id.q6op1);
        Q6op2=findViewById(R.id.q6op2);
        Q6op3=findViewById(R.id.q6op3);
        Q6op4=findViewById(R.id.q6op4);

        Q7=findViewById(R.id.q7);
        Q7op1=findViewById(R.id.q7op1);
        Q7op2=findViewById(R.id.q7op2);
        Q7op3=findViewById(R.id.q7op3);
        Q7op4=findViewById(R.id.q7op4);

        Q8=findViewById(R.id.q8);
        Q8op1=findViewById(R.id.q8op1);
        Q8op2=findViewById(R.id.q8op2);
        Q8op3=findViewById(R.id.q8op3);
        Q8op4=findViewById(R.id.q8op4);

        Q9=findViewById(R.id.q9);
        Q9op1=findViewById(R.id.q9op1);
        Q9op2=findViewById(R.id.q9op2);
        Q9op3=findViewById(R.id.q9op3);
        Q9op4=findViewById(R.id.q9op4);

        Q10=findViewById(R.id.q10);
        Q10op1=findViewById(R.id.q10op1);
        Q10op2=findViewById(R.id.q10op2);
        Q10op3=findViewById(R.id.q10op3);
        Q10op4=findViewById(R.id.q10op4);

        Q11=findViewById(R.id.q11);
        Q11op1=findViewById(R.id.q11op1);
        Q11op2=findViewById(R.id.q11op2);
        Q11op3=findViewById(R.id.q11op3);
        Q11op4=findViewById(R.id.q11op4);

        Q12=findViewById(R.id.q12);
        Q12op1=findViewById(R.id.q12op1);
        Q12op2=findViewById(R.id.q12op2);
        Q12op3=findViewById(R.id.q12op3);
        Q12op4=findViewById(R.id.q12op4);

        Q13=findViewById(R.id.q13);
        Q13op1=findViewById(R.id.q13op1);
        Q13op2=findViewById(R.id.q13op2);
        Q13op3=findViewById(R.id.q13op3);
        Q13op4=findViewById(R.id.q13op4);

        Q14=findViewById(R.id.q14);
        Q14op1=findViewById(R.id.q14op1);
        Q14op2=findViewById(R.id.q14op2);
        Q14op3=findViewById(R.id.q14op3);
        Q14op4=findViewById(R.id.q14op4);

        Q15=findViewById(R.id.q15);
        Q15op1=findViewById(R.id.q15op1);
        Q15op2=findViewById(R.id.q15op2);
        Q15op3=findViewById(R.id.q15op3);
        Q15op4=findViewById(R.id.q15op4);

        Q16=findViewById(R.id.q16);
        Q16op1=findViewById(R.id.q16op1);
        Q16op2=findViewById(R.id.q16op2);
        Q16op3=findViewById(R.id.q16op3);
        Q16op4=findViewById(R.id.q16op4);

        Q17=findViewById(R.id.q17);
        Q17op1=findViewById(R.id.q17op1);
        Q17op2=findViewById(R.id.q17op2);
        Q17op3=findViewById(R.id.q17op3);
        Q17op4=findViewById(R.id.q17op4);

        Q18=findViewById(R.id.q18);
        Q18op1=findViewById(R.id.q18op1);
        Q18op2=findViewById(R.id.q18op2);
        Q18op3=findViewById(R.id.q18op3);
        Q18op4=findViewById(R.id.q18op4);

        Q19=findViewById(R.id.q19);
        Q19op1=findViewById(R.id.q19op1);
        Q19op2=findViewById(R.id.q19op2);
        Q19op3=findViewById(R.id.q19op3);
        Q19op4=findViewById(R.id.q19op4);

        Q20=findViewById(R.id.q20);
        Q20op1=findViewById(R.id.q20op1);
        Q20op2=findViewById(R.id.q20op2);
        Q20op3=findViewById(R.id.q20op3);
        Q20op4=findViewById(R.id.q20op4);



        intent=getIntent();
        SExamcode = intent.getStringExtra("SExamcode");
        intent1=new Intent(this,Result.class);

        reference= FirebaseDatabase.getInstance().getReference().child("MyMessage2").child(SExamcode);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String q1 = dataSnapshot.child("Question1").child("Question1").getValue().toString();
                Q1.setText(q1);
                String q1op1 = dataSnapshot.child("Question1").child("Q1_options1").getValue().toString();
                Q1op1.setText(q1op1);
                String q1op2 = dataSnapshot.child("Question1").child("Q1_options2").getValue().toString();
                Q1op2.setText(q1op2);
                String q1op3 = dataSnapshot.child("Question1").child("Q1_options3").getValue().toString();
                Q1op3.setText(q1op3);
                String q1op4 = dataSnapshot.child("Question1").child("Q1_options4").getValue().toString();
                Q1op4.setText(q1op4);



                String q2 = dataSnapshot.child("Question2").child("Question2").getValue().toString();
                Q2.setText(q2);
                String q2op1 = dataSnapshot.child("Question2").child("Q2_options1").getValue().toString();
                Q2op1.setText(q2op1);
                String q2op2 = dataSnapshot.child("Question2").child("Q2_options2").getValue().toString();
                Q2op2.setText(q2op2);
                String q2op3 = dataSnapshot.child("Question2").child("Q2_options3").getValue().toString();
                Q2op3.setText(q2op3);
                String q2op4 = dataSnapshot.child("Question2").child("Q2_options4").getValue().toString();
                Q2op4.setText(q2op4);


                String q3 = dataSnapshot.child("Question3").child("Question3").getValue().toString();
                Q3.setText(q3);
                String q3op1 = dataSnapshot.child("Question3").child("Q3_options1").getValue().toString();
                Q3op1.setText(q3op1);
                String q3op2 = dataSnapshot.child("Question3").child("Q3_options2").getValue().toString();
                Q3op2.setText(q3op2);
                String q3op3 = dataSnapshot.child("Question3").child("Q3_options3").getValue().toString();
                Q3op3.setText(q3op3);
                String q3op4 = dataSnapshot.child("Question3").child("Q3_options4").getValue().toString();
                Q3op4.setText(q3op4);

                String q4 = dataSnapshot.child("Question4").child("Question4").getValue().toString();
                Q4.setText(q4);
                String q4op1 = dataSnapshot.child("Question4").child("Q4_options1").getValue().toString();
                Q4op1.setText(q4op1);
                String q4op2 = dataSnapshot.child("Question4").child("Q4_options2").getValue().toString();
                Q4op2.setText(q4op2);
                String q4op3 = dataSnapshot.child("Question4").child("Q4_options3").getValue().toString();
                Q4op3.setText(q4op3);
                String q4op4 = dataSnapshot.child("Question4").child("Q4_options4").getValue().toString();
                Q4op4.setText(q4op4);



                String q5 = dataSnapshot.child("Question5").child("Question5").getValue().toString();
                Q5.setText(q2);
                String q5op1 = dataSnapshot.child("Question5").child("Q5_options1").getValue().toString();
                Q5op1.setText(q5op1);
                String q5op2 = dataSnapshot.child("Question5").child("Q5_options2").getValue().toString();
                Q5op2.setText(q5op2);
                String q5op3 = dataSnapshot.child("Question5").child("Q5_options3").getValue().toString();
                Q5op3.setText(q5op3);
                String q5op4 = dataSnapshot.child("Question5").child("Q5_options4").getValue().toString();
                Q5op4.setText(q5op4);


                String q6 = dataSnapshot.child("Question6").child("Question6").getValue().toString();
                Q6.setText(q6);
                String q6op1 = dataSnapshot.child("Question6").child("Q6_options1").getValue().toString();
                Q6op1.setText(q6op1);
                String q6op2 = dataSnapshot.child("Question6").child("Q6_options2").getValue().toString();
                Q6op2.setText(q6op2);
                String q6op3 = dataSnapshot.child("Question6").child("Q6_options3").getValue().toString();
                Q6op3.setText(q6op3);
                String q6op4 = dataSnapshot.child("Question6").child("Q6_options4").getValue().toString();
                Q6op4.setText(q6op4);

                String q7 = dataSnapshot.child("Question7").child("Question7").getValue().toString();
                Q7.setText(q7);
                String q7op1 = dataSnapshot.child("Question7").child("Q7_options1").getValue().toString();
                Q7op1.setText(q7op1);
                String q7op2 = dataSnapshot.child("Question7").child("Q7_options2").getValue().toString();
                Q7op2.setText(q7op2);
                String q7op3 = dataSnapshot.child("Question7").child("Q7_options3").getValue().toString();
                Q7op3.setText(q7op3);
                String q7op4 = dataSnapshot.child("Question7").child("Q7_options4").getValue().toString();
                Q7op4.setText(q7op4);



                String q8 = dataSnapshot.child("Question8").child("Question8").getValue().toString();
                Q8.setText(q8);
                String q8op1 = dataSnapshot.child("Question8").child("Q8_options1").getValue().toString();
                Q8op1.setText(q8op1);
                String q8op2 = dataSnapshot.child("Question8").child("Q8_options2").getValue().toString();
                Q8op2.setText(q8op2);
                String q8op3 = dataSnapshot.child("Question8").child("Q8_options3").getValue().toString();
                Q8op3.setText(q8op3);
                String q8op4 = dataSnapshot.child("Question8").child("Q8_options4").getValue().toString();
                Q8op4.setText(q8op4);


                String q9 = dataSnapshot.child("Question9").child("Question9").getValue().toString();
                Q9.setText(q9);
                String q9op1 = dataSnapshot.child("Question9").child("Q9_options1").getValue().toString();
                Q9op1.setText(q9op1);
                String q9op2 = dataSnapshot.child("Question9").child("Q9_options2").getValue().toString();
                Q9op2.setText(q9op2);
                String q9op3 = dataSnapshot.child("Question9").child("Q9_options3").getValue().toString();
                Q9op3.setText(q9op3);
                String q9op4 = dataSnapshot.child("Question9").child("Q9_options4").getValue().toString();
                Q9op4.setText(q9op4);

                String q10 = dataSnapshot.child("Question10").child("Question10").getValue().toString();
                Q10.setText(q10);
                String q10op1 = dataSnapshot.child("Question10").child("Q10_options1").getValue().toString();
                Q10op1.setText(q10op1);
                String q10op2 = dataSnapshot.child("Question10").child("Q10_options2").getValue().toString();
                Q10op2.setText(q10op2);
                String q10op3 = dataSnapshot.child("Question10").child("Q10_options3").getValue().toString();
                Q10op3.setText(q10op3);
                String q10op4 = dataSnapshot.child("Question10").child("Q10_options4").getValue().toString();
                Q10op4.setText(q10op4);



                String q11 = dataSnapshot.child("Question11").child("Question11").getValue().toString();
                Q11.setText(q11);
                String q11op1 = dataSnapshot.child("Question11").child("Q11_options1").getValue().toString();
                Q11op1.setText(q11op1);
                String q11op2 = dataSnapshot.child("Question11").child("Q11_options2").getValue().toString();
                Q11op2.setText(q11op2);
                String q11op3 = dataSnapshot.child("Question11").child("Q11_options3").getValue().toString();
                Q11op3.setText(q11op3);
                String q11op4 = dataSnapshot.child("Question11").child("Q11_options4").getValue().toString();
                Q11op4.setText(q11op4);


                String q12 = dataSnapshot.child("Question12").child("Question12").getValue().toString();
                Q12.setText(q12);
                String q12op1 = dataSnapshot.child("Question12").child("Q12_options1").getValue().toString();
                Q12op1.setText(q12op1);
                String q12op2 = dataSnapshot.child("Question12").child("Q12_options2").getValue().toString();
                Q12op2.setText(q12op2);
                String q12op3 = dataSnapshot.child("Question12").child("Q12_options3").getValue().toString();
                Q12op3.setText(q12op3);
                String q12op4 = dataSnapshot.child("Question12").child("Q12_options4").getValue().toString();
                Q12op4.setText(q12op4);


                String q13 = dataSnapshot.child("Question13").child("Question13").getValue().toString();
                Q13.setText(q13);
                String q13op1 = dataSnapshot.child("Question13").child("Q13_options1").getValue().toString();
                Q13op1.setText(q13op1);
                String q13op2 = dataSnapshot.child("Question13").child("Q13_options2").getValue().toString();
                Q13op2.setText(q13op2);
                String q13op3 = dataSnapshot.child("Question13").child("Q13_options3").getValue().toString();
                Q13op3.setText(q13op3);
                String q13op4 = dataSnapshot.child("Question13").child("Q13_options4").getValue().toString();
                Q13op4.setText(q13op4);



                String q14 = dataSnapshot.child("Question14").child("Question14").getValue().toString();
                Q14.setText(q14);
                String q14op1 = dataSnapshot.child("Question14").child("Q14_options1").getValue().toString();
                Q14op1.setText(q14op1);
                String q14op2 = dataSnapshot.child("Question14").child("Q14_options2").getValue().toString();
                Q14op2.setText(q14op2);
                String q14op3 = dataSnapshot.child("Question14").child("Q14_options3").getValue().toString();
                Q14op3.setText(q14op3);
                String q14op4 = dataSnapshot.child("Question14").child("Q14_options4").getValue().toString();
                Q14op4.setText(q14op4);


                String q15 = dataSnapshot.child("Question15").child("Question15").getValue().toString();
                Q15.setText(q15);
                String q15op1 = dataSnapshot.child("Question15").child("Q15_options1").getValue().toString();
                Q15op1.setText(q15op1);
                String q15op2 = dataSnapshot.child("Question15").child("Q15_options2").getValue().toString();
                Q15op2.setText(q15op2);
                String q15op3 = dataSnapshot.child("Question15").child("Q15_options3").getValue().toString();
                Q15op3.setText(q15op3);
                String q15op4 = dataSnapshot.child("Question15").child("Q15_options4").getValue().toString();
                Q15op4.setText(q15op4);

                String q16 = dataSnapshot.child("Question16").child("Question16").getValue().toString();
                Q16.setText(q16);
                String q16op1 = dataSnapshot.child("Question16").child("Q16_options1").getValue().toString();
                Q16op1.setText(q16op1);
                String q16op2 = dataSnapshot.child("Question16").child("Q16_options2").getValue().toString();
                Q16op2.setText(q16op2);
                String q16op3 = dataSnapshot.child("Question16").child("Q16_options3").getValue().toString();
                Q16op3.setText(q16op3);
                String q16op4 = dataSnapshot.child("Question16").child("Q16_options4").getValue().toString();
                Q16op4.setText(q16op4);



                String q17 = dataSnapshot.child("Question17").child("Question17").getValue().toString();
                Q17.setText(q17);
                String q17op1 = dataSnapshot.child("Question17").child("Q17_options1").getValue().toString();
                Q17op1.setText(q17op1);
                String q17op2 = dataSnapshot.child("Question17").child("Q17_options2").getValue().toString();
                Q17op2.setText(q17op2);
                String q17op3 = dataSnapshot.child("Question17").child("Q17_options3").getValue().toString();
                Q17op3.setText(q17op3);
                String q17op4 = dataSnapshot.child("Question17").child("Q17_options4").getValue().toString();
                Q17op4.setText(q17op4);


                String q18 = dataSnapshot.child("Question18").child("Question18").getValue().toString();
                Q18.setText(q18);
                String q18op1 = dataSnapshot.child("Question18").child("Q18_options1").getValue().toString();
                Q18op1.setText(q18op1);
                String q18op2 = dataSnapshot.child("Question18").child("Q18_options2").getValue().toString();
                Q18op2.setText(q18op2);
                String q18op3 = dataSnapshot.child("Question18").child("Q18_options3").getValue().toString();
                Q18op3.setText(q18op3);
                String q18op4 = dataSnapshot.child("Question18").child("Q18_options4").getValue().toString();
                Q18op4.setText(q18op4);

                String q19 = dataSnapshot.child("Question19").child("Question19").getValue().toString();
                Q19.setText(q19);
                String q19op1 = dataSnapshot.child("Question19").child("Q19_options1").getValue().toString();
                Q19op1.setText(q19op1);
                String q19op2 = dataSnapshot.child("Question19").child("Q19_options2").getValue().toString();
                Q19op2.setText(q19op2);
                String q19op3 = dataSnapshot.child("Question19").child("Q19_options3").getValue().toString();
                Q19op3.setText(q19op3);
                String q19op4 = dataSnapshot.child("Question19").child("Q19_options4").getValue().toString();
                Q19op4.setText(q19op4);



                String q20 = dataSnapshot.child("Question20").child("Question20").getValue().toString();
                Q20.setText(q20);
                String q20op1 = dataSnapshot.child("Question20").child("Q20_options1").getValue().toString();
                Q20op1.setText(q20op1);
                String q20op2 = dataSnapshot.child("Question20").child("Q20_options2").getValue().toString();
                Q20op2.setText(q20op2);
                String q20op3 = dataSnapshot.child("Question20").child("Q20_options3").getValue().toString();
                Q20op3.setText(q20op3);
                String q20op4 = dataSnapshot.child("Question20").child("Q20_options4").getValue().toString();
                Q20op4.setText(q20op4);






                marks_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String q1ans = dataSnapshot.child("Question1").child("Q1_answer").getValue().toString();
                        if(Q1op1.isChecked() && Q1op1.getText().toString().equals(q1ans)){
                            marks=marks+1;
                        }
                        else if(Q1op2.isChecked() && Q1op2.getText().toString().equals(q1ans)){
                            marks=marks+1;
                        }
                        else if(Q1op3.isChecked() && Q1op3.getText().toString().equals(q1ans)){
                            marks=marks+1;
                        }
                        else if(Q1op4.isChecked() && Q1op4.getText().toString().equals(q1ans)){
                            marks=marks+1;
                        }
                        else {

                        }

                        String q2ans = dataSnapshot.child("Question2").child("Q2_answer").getValue().toString();
                        if(Q2op1.isChecked() && Q2op1.getText().toString().equals(q2ans)){
                            marks=marks+1;
                        }
                        else if(Q2op2.isChecked() && Q2op2.getText().toString().equals(q2ans)){
                            marks=marks+1;
                        }
                        else if(Q2op3.isChecked() && Q2op3.getText().toString().equals(q2ans)){
                            marks=marks+1;
                        }
                        else if(Q2op4.isChecked() && Q2op4.getText().toString().equals(q2ans)){
                            marks=marks+1;
                        }
                        else{

                        }


                        String q3ans = dataSnapshot.child("Question3").child("Q3_answer").getValue().toString();
                        if(Q3op1.isChecked() && Q3op1.getText().toString().equals(q3ans)){
                            marks=marks+1;
                        }
                        else if(Q3op2.isChecked() && Q3op2.getText().toString().equals(q3ans)){
                            marks=marks+1;
                        }
                        else if(Q3op3.isChecked() && Q3op3.getText().toString().equals(q3ans)){
                            marks=marks+1;
                        }
                        else if(Q3op4.isChecked() && Q3op4.getText().toString().equals(q3ans)){;
                            marks=marks+1;
                        }
                        else{

                        }

                        String q4ans = dataSnapshot.child("Question4").child("Q4_answer").getValue().toString();
                        if(Q4op1.isChecked() && Q4op1.getText().toString().equals(q4ans)){
                            marks=marks+1;
                        }
                        else if(Q4op2.isChecked() && Q4op2.getText().toString().equals(q4ans)){
                            marks=marks+1;
                        }
                        else if(Q4op3.isChecked() && Q4op3.getText().toString().equals(q4ans)){
                            marks=marks+1;
                        }
                        else if(Q4op4.isChecked() && Q4op4.getText().toString().equals(q4ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q5ans = dataSnapshot.child("Question5").child("Q5_answer").getValue().toString();
                        if(Q5op1.isChecked() && Q5op1.getText().toString().equals(q5ans)){
                            marks=marks+1;
                        }
                        else if(Q5op2.isChecked() && Q5op2.getText().toString().equals(q5ans)){
                            marks=marks+1;
                        }
                        else if(Q5op3.isChecked() && Q5op3.getText().toString().equals(q5ans)){
                            marks=marks+1;
                        }
                        else if(Q5op4.isChecked() && Q5op4.getText().toString().equals(q5ans)){
                            marks=marks+1;
                        }
                        else{

                        }


                        String q6ans = dataSnapshot.child("Question6").child("Q6_answer").getValue().toString();
                        if(Q6op1.isChecked() && Q6op1.getText().toString().equals(q6ans)){
                            marks=marks+1;
                        }
                        else if(Q6op2.isChecked() && Q6op2.getText().toString().equals(q6ans)){
                            marks=marks+1;
                        }
                        else if(Q6op3.isChecked() && Q6op3.getText().toString().equals(q6ans)){
                            marks=marks+1;
                        }
                        else if(Q6op4.isChecked() && Q6op4.getText().toString().equals(q6ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q7ans = dataSnapshot.child("Question7").child("Q7_answer").getValue().toString();
                        if(Q7op1.isChecked() && Q7op1.getText().toString().equals(q7ans)){
                            marks=marks+1;
                        }
                        else if(Q7op2.isChecked() && Q7op2.getText().toString().equals(q7ans)){
                            marks=marks+1;
                        }
                        else if(Q7op3.isChecked() && Q7op3.getText().toString().equals(q7ans)){
                            marks=marks+1;
                        }
                        else if(Q7op4.isChecked() && Q7op4.getText().toString().equals(q7ans))
                        {
                            marks=marks+1;
                        }
                        else{

                        }

                        String q8ans = dataSnapshot.child("Question8").child("Q8_answer").getValue().toString();
                        if(Q8op1.isChecked() && Q8op1.getText().toString().equals(q8ans)){
                            marks=marks+1;
                        }
                        else if(Q8op2.isChecked() && Q8op2.getText().toString().equals(q8ans)){
                            marks=marks+1;
                        }
                        else if(Q8op3.isChecked() && Q8op3.getText().toString().equals(q8ans)){
                            marks=marks+1;
                        }
                        else if(Q8op4.isChecked() && Q8op4.getText().toString().equals(q8ans)){
                            marks=marks+1;
                        }
                        else{

                        }


                        String q9ans = dataSnapshot.child("Question9").child("Q9_answer").getValue().toString();
                        if(Q9op1.isChecked() && Q9op1.getText().toString().equals(q9ans)){
                            marks=marks+1;
                        }
                        else if(Q9op2.isChecked() && Q9op2.getText().toString().equals(q9ans)){
                            marks=marks+1;
                        }
                        else if(Q9op3.isChecked() && Q9op3.getText().toString().equals(q9ans)){
                            marks=marks+1;
                        }
                        else if(Q9op4.isChecked() && Q9op4.getText().toString().equals(q9ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q10ans = dataSnapshot.child("Question10").child("Q10_answer").getValue().toString();
                        if(Q10op1.isChecked() && Q10op1.getText().toString().equals(q10ans)){
                            marks=marks+1;
                        }
                        else if(Q10op2.isChecked() && Q10op2.getText().toString().equals(q10ans)){
                            marks=marks+1;
                        }
                        else if(Q10op3.isChecked() && Q10op3.getText().toString().equals(q10ans)){
                            marks=marks+1;
                        }
                        else if(Q10op4.isChecked() && Q10op4.getText().toString().equals(q10ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q11ans = dataSnapshot.child("Question11").child("Q11_answer").getValue().toString();
                        if(Q11op1.isChecked() && Q11op1.getText().toString().equals(q11ans)){
                            marks=marks+1;
                        }
                        else if(Q11op2.isChecked() && Q11op2.getText().toString().equals(q11ans)){
                            marks=marks+1;
                        }
                        else if(Q11op3.isChecked() && Q11op3.getText().toString().equals(q11ans)){
                            marks=marks+1;
                        }
                        else if(Q11op4.isChecked() && Q11op4.getText().toString().equals(q11ans)){
                            marks=marks+1;
                        }
                        else{

                        }


                        String q12ans = dataSnapshot.child("Question12").child("Q12_answer").getValue().toString();
                        if(Q12op1.isChecked() && Q12op1.getText().toString().equals(q12ans)){
                            marks=marks+1;
                        }
                        else if(Q12op2.isChecked() && Q12op2.getText().toString().equals(q12ans)){
                            marks=marks+1;
                        }
                        else if(Q12op3.isChecked() && Q12op3.getText().toString().equals(q12ans)){
                            marks=marks+1;
                        }
                        else if(Q12op4.isChecked() && Q12op4.getText().toString().equals(q12ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q13ans = dataSnapshot.child("Question13").child("Q13_answer").getValue().toString();
                        if(Q13op1.isChecked() && Q13op1.getText().toString().equals(q13ans)){
                            marks=marks+1;
                        }
                        else if(Q13op2.isChecked() && Q13op2.getText().toString().equals(q13ans)){
                            marks=marks+1;
                        }
                        else if(Q13op3.isChecked() && Q13op3.getText().toString().equals(q13ans)){
                            marks=marks+1;
                        }
                        else if(Q13op4.isChecked() && Q13op4.getText().toString().equals(q13ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q14ans = dataSnapshot.child("Question14").child("Q14_answer").getValue().toString();
                        if(Q14op1.isChecked() && Q14op1.getText().toString().equals(q14ans)){
                            marks=marks+1;
                        }
                        else if(Q14op2.isChecked() && Q14op2.getText().toString().equals(q14ans)){
                            marks=marks+1;
                        }
                        else if(Q14op3.isChecked() && Q14op3.getText().toString().equals(q14ans)){
                            marks=marks+1;
                        }
                        else if(Q14op4.isChecked() && Q14op4.getText().toString().equals(q14ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q15ans = dataSnapshot.child("Question15").child("Q15_answer").getValue().toString();
                        if(Q15op1.isChecked() && Q15op1.getText().toString().equals(q15ans)){
                            marks=marks+1;
                        }
                        else if(Q15op2.isChecked() && Q15op2.getText().toString().equals(q15ans)){
                            marks=marks+1;
                        }
                        else if(Q15op3.isChecked() && Q15op3.getText().toString().equals(q15ans)){
                            marks=marks+1;
                        }
                        else if(Q15op4.isChecked() && Q15op4.getText().toString().equals(q15ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q16ans = dataSnapshot.child("Question16").child("Q16_answer").getValue().toString();
                        if(Q16op1.isChecked() && Q16op1.getText().toString().equals(q16ans)){
                            marks=marks+1;
                        }
                        else if(Q16op2.isChecked() && Q16op2.getText().toString().equals(q16ans)){
                            marks=marks+1;
                        }
                        else if(Q16op3.isChecked() && Q16op3.getText().toString().equals(q16ans)){
                            marks=marks+1;
                        }
                        else if(Q16op4.isChecked() && Q16op4.getText().toString().equals(q16ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q17ans = dataSnapshot.child("Question17").child("Q17_answer").getValue().toString();
                        if(Q17op1.isChecked() && Q17op1.getText().toString().equals(q17ans)){
                            marks=marks+1;
                        }
                        else if(Q17op2.isChecked() && Q17op2.getText().toString().equals(q17ans)){
                            marks=marks+1;
                        }
                        else if(Q17op3.isChecked() && Q17op3.getText().toString().equals(q17ans)){
                            marks=marks+1;
                        }
                        else if(Q17op4.isChecked() && Q17op4.getText().toString().equals(q17ans)){
                            marks=marks+1;
                        }
                        else{

                        }


                        String q18ans = dataSnapshot.child("Question18").child("Q18_answer").getValue().toString();
                        if(Q18op1.isChecked() && Q18op1.getText().toString().equals(q18ans)){
                            marks=marks+1;
                        }
                        else if(Q18op2.isChecked() && Q18op2.getText().toString().equals(q18ans)){
                            marks=marks+1;
                        }
                        else if(Q18op3.isChecked() && Q18op3.getText().toString().equals(q18ans)){
                            marks=marks+1;
                        }
                        else if(Q18op4.isChecked() && Q18op4.getText().toString().equals(q18ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q19ans = dataSnapshot.child("Question19").child("Q19_answer").getValue().toString();
                        if(Q19op1.isChecked() && Q19op1.getText().toString().equals(q19ans)){
                            marks=marks+1;
                        }
                        else if(Q19op2.isChecked() && Q19op2.getText().toString().equals(q19ans)){
                            marks=marks+1;
                        }
                        else if(Q19op3.isChecked() && Q19op3.getText().toString().equals(q19ans)){
                            marks=marks+1;
                        }
                        else if(Q19op4.isChecked() && Q19op4.getText().toString().equals(q19ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        String q20ans = dataSnapshot.child("Question20").child("Q20_answer").getValue().toString();
                        if(Q20op1.isChecked() && Q20op1.getText().toString().equals(q20ans)){
                            marks=marks+1;
                        }
                        else if(Q20op2.isChecked() && Q20op2.getText().toString().equals(q20ans)){
                            marks=marks+1;
                        }
                        else if(Q20op3.isChecked() && Q20op3.getText().toString().equals(q20ans)){
                            marks=marks+1;
                        }
                        else if(Q20op4.isChecked() && Q20op4.getText().toString().equals(q20ans)){
                            marks=marks+1;
                        }
                        else{

                        }

                        mark.setText(" "+marks);


                        intent1.putExtra("result",marks);

                        startActivity(intent1);

                    }
                });



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}