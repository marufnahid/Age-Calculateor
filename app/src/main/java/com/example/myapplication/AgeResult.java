package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Period;

public class AgeResult extends AppCompatActivity {

    TextView resultAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_result);

        resultAge = findViewById(R.id.resultAge);

        Bundle bundle = getIntent().getExtras();


        if (bundle != null){
            String value = bundle.getString("dob");

            LocalDate today = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                today = LocalDate.now();
            }
            LocalDate birthday = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                birthday = LocalDate.of(1987, 9, 24);
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Period period = Period.between(birthday, today);
            }


            resultAge.setText(value);

        }
    }
}