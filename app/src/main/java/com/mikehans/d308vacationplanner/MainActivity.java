package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.mikehans.d308vacationplanner.data.VacationDatabase;
import com.mikehans.d308vacationplanner.models.Vacation;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VacationDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                        VacationDatabase.class, "vacation_db")
                .allowMainThreadQueries()
                .build();

        EditText editTitle = findViewById(R.id.editTextVacationTitle);
        EditText editHotel = findViewById(R.id.editTextHotel);
        EditText editStartDate = findViewById(R.id.editTextStartDate);
        EditText editEndDate = findViewById(R.id.editTextEndDate);
        Button saveButton = findViewById(R.id.buttonSaveVacation);
        Button deleteButton = findViewById(R.id.buttonDeleteVacation);

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
                clearInputFields(editTitle, editHotel, editStartDate, editEndDate);
            }

            List<Vacation> vacations = db.vacationDao().getAllVacations();
            for (Vacation vac : vacations) {
                Log.d("VACATION_DB", vac.toString());
            }
        });

        deleteButton.setOnClickListener(v -> {
            List<Vacation> vacations = db.vacationDao().getAllVacations();

            if (vacations.isEmpty()) {
                Toast.makeText(this, "No vacations to delete!", Toast.LENGTH_SHORT).show();
            } else {
                Vacation vacationToDelete = vacations.get(vacations.size() - 1);

                if (hasExcursions(vacationToDelete)) {
                    Toast.makeText(this, "Cannot delete: Excursions exist for this vacation!", Toast.LENGTH_LONG).show();
                } else {
                    db.vacationDao().delete(vacationToDelete);
                    Toast.makeText(this, "Vacation deleted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearInputFields(EditText title, EditText hotel, EditText startDate, EditText endDate) {
        title.setText("");
        hotel.setText("");
        startDate.setText("");
        endDate.setText("");
    }

    // MIKE - FIX THIS LATER - Excursion always 'false' (to currently allow vacation deletions)
    private boolean hasExcursions(Vacation vacation) {
        return false;
    }
}


