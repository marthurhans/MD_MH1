package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.mikehans.d308vacationplanner.models.Vacation;
import com.mikehans.d308vacationplanner.data.VacationDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VacationDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                        VacationDatabase.class, "vacation_db")
                .allowMainThreadQueries() // TEMPORARY for testing (remove later)
                .build();

        EditText editTitle = findViewById(R.id.editTextVacationTitle);
        EditText editHotel = findViewById(R.id.editTextHotel);
        EditText editStartDate = findViewById(R.id.editTextStartDate);
        EditText editEndDate = findViewById(R.id.editTextEndDate);
        Button saveButton = findViewById(R.id.buttonSaveVacation);

        saveButton.setOnClickListener(v -> {
            String title = editTitle.getText().toString().trim();
            String hotel = editHotel.getText().toString().trim();
            String startDate = editStartDate.getText().toString().trim();
            String endDate = editEndDate.getText().toString().trim();

            if (title.isEmpty() || hotel.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
            } else {
                Vacation vacation = new Vacation(title, hotel, startDate, endDate);
                db.vacationDao().insert(vacation);
                Toast.makeText(this, "Vacation Saved!", Toast.LENGTH_SHORT).show();
            }

            List<Vacation> vacations = db.vacationDao().getAllVacations();
            for (Vacation vac : vacations) {
                Log.d("VACATION_DB", "Saved Vacation: " + vac.getTitle() +
                        " at " + vac.getHotel());
            }

        });
    }
}


