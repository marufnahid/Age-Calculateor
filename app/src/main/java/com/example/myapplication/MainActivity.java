package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //
//
    TextView currentDate;
    TextView yourBirthDate;
    Calendar calendar;
    Button birthDateSelect;
    Button calculateAge;

    String val;

    DatePickerDialog datePickerDialog;
//    Date date;
//    CharSequence s  = DateFormat.getDateInstance().format("MMMM d, yyyy ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdf.format(calendar.getTime());
        currentDate = findViewById(R.id.currentDate);
        currentDate.setText(strDate);

        birthDateSelect = findViewById(R.id.birthDateSelect);
        yourBirthDate = findViewById(R.id.yourBirthDate);
        calculateAge = findViewById(R.id.calculateAge);

        birthDateSelect.setOnClickListener(this);
        calculateAge.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.birthDateSelect) {

            Calendar datePicker = Calendar.getInstance();
            int selectedYear = datePicker.get(Calendar.YEAR);
            int selectedMonth = datePicker.get(Calendar.MONTH);
            int selectedDay = datePicker.get(Calendar.DAY_OF_MONTH);

            datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            yourBirthDate.setText(i2 + "/" + (i1 + 1) + "/" + i);

                        }
                    }, selectedYear, selectedMonth, selectedDay
            );

            datePickerDialog.show();
        }

        if (view.getId() == R.id.calculateAge) {

            Intent intent = new Intent(MainActivity.this, AgeResult.class);
            String getValue = (String) yourBirthDate.getText();
            intent.putExtra("dob",getValue);
            startActivity(intent);
        }

    }
}