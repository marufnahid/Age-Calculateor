package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeResult extends AppCompatActivity {

    TextView resultAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_result);

        resultAge = findViewById(R.id.resultAge);

        Bundle bundle = getIntent().getExtras();

//        Log.println(Log.ASSERT, "helloworld", String.valueOf(bundle));


        if (bundle != null) {
            String dob = bundle.getString("dob");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
            LocalDate birthDate = LocalDate.parse(dob, formatter);


            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(birthDate, currentDate);
            int days = period.getDays();
            int months = period.getMonths();
            int year = period.getYears();

            resultAge.setText( "Your age is " + String.valueOf(year) + " years " + String.valueOf(months) + " months "  + days +" days.");

        }
    }
}