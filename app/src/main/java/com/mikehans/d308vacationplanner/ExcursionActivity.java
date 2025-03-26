package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mikehans.d308vacationplanner.data.VacationDatabase;
import com.mikehans.d308vacationplanner.models.Excursion;

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

            // MIKE - FIX THIS LATER
            int vacationId = getIntent().getIntExtra("vacationId", -1);

            Excursion excursion = new Excursion(title, date, vacationId);

            VacationDatabase db = VacationDatabase.getInstance(this);

            db.excursionDao().insert(excursion);
            Log.d("Vacation_DB", "Excursion saved: " + excursion);
            Toast.makeText(this, "Excursion added!", Toast.LENGTH_SHORT).show();

        });
    }
}
