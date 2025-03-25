package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.mikehans.d308vacationplanner.data.VacationDatabase;
import com.mikehans.d308vacationplanner.models.Vacation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class VacationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_detail);

        Vacation vacation = (Vacation) getIntent().getSerializableExtra("vacation");

        if (vacation != null) {
            EditText titleInput = findViewById(R.id.editTextTitle);
            EditText hotelInput = findViewById(R.id.editTextHotel);
            EditText startInput = findViewById(R.id.editTextStartDate);
            EditText endInput = findViewById(R.id.editTextEndDate);
            Button saveButton = findViewById(R.id.buttonSaveChanges);

            titleInput.setText(vacation.getTitle());
            hotelInput.setText(vacation.getHotel());
            startInput.setText(vacation.getStartDate());
            endInput.setText(vacation.getEndDate());

            saveButton.setOnClickListener(v -> {
                String updatedTitle = titleInput.getText().toString().trim();
                String updatedHotel = hotelInput.getText().toString().trim();
                String updatedStart = startInput.getText().toString().trim();
                String updatedEnd = endInput.getText().toString().trim();

                if (!isValidDate(updatedStart) || !isValidDate(updatedEnd)) {
                    Toast.makeText(this, "Please enter dates in YYYY-MM-DD format.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!isDateRangeValid(updatedStart, updatedEnd)) {
                    Toast.makeText(this, "End date must be after start date.", Toast.LENGTH_SHORT).show();
                    return;
                }


                vacation.setTitle(updatedTitle);
                vacation.setHotel(updatedHotel);
                vacation.setStartDate(updatedStart);
                vacation.setEndDate(updatedEnd);

                VacationDatabase db = Room.databaseBuilder(getApplicationContext(),
                                VacationDatabase.class, "vacation_db")
                        .allowMainThreadQueries()
                        .build();

                db.vacationDao().update(vacation);

                Toast.makeText(this, "Vacation updated!", Toast.LENGTH_SHORT).show();
                finish();
            });
        }
    }

    private boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    private boolean isDateRangeValid(String start, String end) {
        try {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            return endDate.isAfter(startDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}

