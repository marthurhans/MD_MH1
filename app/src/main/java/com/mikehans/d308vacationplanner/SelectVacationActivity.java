package com.mikehans.d308vacationplanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.mikehans.d308vacationplanner.data.VacationDatabase;
import com.mikehans.d308vacationplanner.models.Vacation;

import java.util.List;

public class SelectVacationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_vacation);

        VacationDatabase db = VacationDatabase.getInstance(this);
        List<Vacation> vacations = db.vacationDao().getAllVacations();

        LinearLayout layout = findViewById(R.id.vacationListLayout);

        // MIKE - FIX THIS
        if (layout == null) {
            layout = findViewById(android.R.id.content);
        }

        for (Vacation vacation : vacations) {
            Button button = new Button(this);
            button.setText(
                    vacation.getTitle() + "\n" +
                            vacation.getHotel() + "\n" +
                            vacation.getStartDate() + " to " + vacation.getEndDate()
            );
            button.setOnClickListener(v -> {
                Intent intent = new Intent(SelectVacationActivity.this,
                        VacationDetailActivity.class);
                intent.putExtra("vacation", vacation);
                startActivity(intent);
            });

            layout.addView(button);
        }
    }
}

