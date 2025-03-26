package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mikehans.d308vacationplanner.data.VacationDatabase;
import com.mikehans.d308vacationplanner.models.Excursion;

public class ExcursionDetailActivity extends AppCompatActivity {

    private EditText excursionTitleEditText;
    private EditText excursionDateEditText;
    private Button updateButton, deleteButton;

    private Excursion currentExcursion;
    private VacationDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_detail);

        excursionTitleEditText = findViewById(R.id.excursion_title_edittext);
        excursionDateEditText = findViewById(R.id.excursion_date_edittext);
        updateButton = findViewById(R.id.update_excursion_button);
        deleteButton = findViewById(R.id.delete_excursion_button);

        db = VacationDatabase.getInstance(this);

        currentExcursion = (Excursion) getIntent().getSerializableExtra("excursion");

        if (currentExcursion != null) {
            excursionTitleEditText.setText(currentExcursion.getTitle());
            excursionDateEditText.setText(currentExcursion.getDate());
        }

        updateButton.setOnClickListener(v -> updateExcursion());
        deleteButton.setOnClickListener(v -> deleteExcursion());
    }

    private void updateExcursion() {
        String newTitle = excursionTitleEditText.getText().toString().trim();
        String newDate = excursionDateEditText.getText().toString().trim();

        if (newTitle.isEmpty() || newDate.isEmpty()) {
            Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show();
            return;
        }

        currentExcursion.setTitle(newTitle);
        currentExcursion.setDate(newDate);

        db.excursionDao().update(currentExcursion);
        Toast.makeText(this, "Excursion updated", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void deleteExcursion() {
        db.excursionDao().delete(currentExcursion);
        Toast.makeText(this, "Excursion deleted", Toast.LENGTH_SHORT).show();
        finish();
    }
}

