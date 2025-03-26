package com.mikehans.d308vacationplanner;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mikehans.d308vacationplanner.data.VacationDatabase;
import com.mikehans.d308vacationplanner.models.Excursion;
import com.mikehans.d308vacationplanner.models.Vacation;

import java.util.List;

public class AllVacationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vacations);

        TextView output = findViewById(R.id.textViewAllVacations);

        VacationDatabase db = VacationDatabase.getInstance(this);

        List<Vacation> vacations = db.vacationDao().getAllVacations();

        StringBuilder display = new StringBuilder();

        for (Vacation vacation : vacations) {
            display.append("Vacation: ").append(vacation.getTitle()).append(" (ID: ").append(vacation.getId()).append(")\n")
                    .append("Hotel: ").append(vacation.getHotel()).append("\n")
                    .append("Dates: ").append(vacation.getStartDate()).append(" to ").append(vacation.getEndDate()).append("\n");

            List<Excursion> excursions = db.excursionDao().getExcursionsForVacation(vacation.getId());

            if (excursions.isEmpty()) {
                display.append("  - No excursions\n");
            } else {
                for (Excursion excursion : excursions) {
                    display.append("  • Title: ").append(excursion.getTitle()).append("\n")
                            .append("    Date:  ").append(excursion.getDate()).append("   [ID#")
                            .append(excursion.getId()).append("]\n");
                }
            }

            display.append("\n");
        }

        if (vacations.isEmpty()) {
            output.setText("No vacations found.");
        } else {
            output.setText(display.toString().trim());
        }
    }
}
