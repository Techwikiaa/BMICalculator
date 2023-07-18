package com.techwikiaa.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtresult;
        EditText editWeight,editHeight;
        Button btnCalculate;
        LinearLayout linearMain;

        txtresult = findViewById(R.id.txtresult);
        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        linearMain = findViewById(R.id.linearMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(editWeight.getText().toString());
               int ht = Integer.parseInt(editHeight.getText().toString());

               double totalCm = ht*2.54;
               double totalM = totalCm/100;
               double bmi = wt/(totalM*totalM);
               if (bmi>25){
                   txtresult.setText("Your are over weight!\n \n Start Diet!");
                   linearMain.setBackgroundColor(getResources().getColor(R.color.overwt));
               } else if (bmi<18) {
                   txtresult.setText("You are under weight\n \n Eat some healthy food!");
                   linearMain.setBackgroundColor(getResources().getColor(R.color.underwt));
               }else{
                   txtresult.setText("You are healthy\n \n Keep up what your are doing!");
                   linearMain.setBackgroundColor(getResources().getColor(R.color.healthy));
               }
            }
        });
    }
}