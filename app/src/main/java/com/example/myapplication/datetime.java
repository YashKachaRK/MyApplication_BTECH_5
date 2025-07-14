package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;
import java.util.Calendar;

public class datetime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_datetime);
        Button pickdate = (Button) findViewById(R.id.pickdate);
        Button picktime = (Button) findViewById(R.id.picktime);

        TextView t1 = (TextView) findViewById(R.id.t1);
        TextView t2 = (TextView) findViewById(R.id.t2);

        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int year  = calendar.get(Calendar.YEAR);
                int month  = calendar.get(Calendar.MONTH);
                int day  = calendar.get(Calendar.DAY_OF_MONTH);
                int day_of_Month = calendar.get(Calendar.DAY_OF_WEEK);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        datetime.this,
                        (datePicker, selectedYear, selectedMonth, selectedDay  ) -> {

                            String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                            t1.setText(date);
//                            Toast.makeText(datetime.this, "Selected Date: " + date, Toast.LENGTH_SHORT).show();

                        },
                        year, month, day);

                datePickerDialog.show();

            }
        });

        picktime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int Hours = calendar.get(Calendar.HOUR_OF_DAY);
                int Min = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        datetime.this,
                        (timePicker, selectedHour, selectedMinute) -> {
                            String time = String.format("%02d:%02d", selectedHour, selectedMinute);
                            t2.setText(time);
                        },
                        Hours, Min, false // 24 kalak mate
                );
                timePickerDialog.show();

            }
        });

    }
}