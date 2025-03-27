package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mikehans.d308vacationplanner.data.VacationDatabase;
import com.mikehans.d308vacationplanner.models.Excursion;
import com.mikehans.d308vacationplanner.models.Vacation;

public class ExcursionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion);

        EditText titleInput = findViewById(R.id.editTextExcursionTitle);
        EditText dateInput = findViewById(R.id.editTextExcursionDate);
        Button addButton = findViewById(R.id.buttonAddExcursion);

        addButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString().trim();
            String date = dateInput.getText().toString().trim();

            if (title.isEmpty()) {
                Toast.makeText(this, "Please enter an excursion title.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!ValidationUtils.isValidDate(date)) {
                Toast.makeText(this, "Please enter the date in YYYY-MM-DD format.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            int vacationId = getIntent().getIntExtra("vacationId", -1);
            if (vacationId == -1) {
                Toast.makeText(this, "Invalid vacation ID. Cannot add excursion.", Toast.LENGTH_SHORT).show();
                return;
            }

            VacationDatabase db = VacationDatabase.getInstance(this);
            Vacation associatedVacation = db.vacationDao().getVacationById(vacationId);

            String vacationStart = associatedVacation.getStartDate();
            String vacationEnd = associatedVacation.getEndDate();

            if (!ValidationUtils.isDateRangeValid(vacationStart, date) ||
                    !ValidationUtils.isDateRangeValid(date, vacationEnd)) {
                Toast.makeText(this, "Excursion date must be within vacation range (" + vacationStart + " to " + vacationEnd + ").",
                        Toast.LENGTH_LONG).show();
                return;
            }

            Excursion excursion = new Excursion(title, date, vacationId);

            db.excursionDao().insert(excursion);
            Log.d("Vacation_DB", "Excursion saved: " + excursion);
            Toast.makeText(this, "Excursion added!", Toast.LENGTH_SHORT).show();

            finish();
        });
    }
}
