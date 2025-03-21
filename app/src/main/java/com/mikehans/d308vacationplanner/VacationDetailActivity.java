package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mikehans.d308vacationplanner.models.Vacation;

public class VacationDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_detail);

        Vacation vacation = (Vacation) getIntent().getSerializableExtra("vacation");

        if (vacation != null) {
            TextView titleView = findViewById(R.id.textViewTitle);
            TextView hotelView = findViewById(R.id.textViewHotel);
            TextView startDateView = findViewById(R.id.textViewStartDate);
            TextView endDateView = findViewById(R.id.textViewEndDate);

            titleView.setText("Title: " + vacation.getTitle());
            hotelView.setText("Hotel: " + vacation.getHotel());
            startDateView.setText("Start Date: " + vacation.getStartDate());
            endDateView.setText("End Date: " + vacation.getEndDate());
        }

    }
}
