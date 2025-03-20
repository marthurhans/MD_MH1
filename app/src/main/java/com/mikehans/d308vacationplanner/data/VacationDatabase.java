package com.mikehans.d308vacationplanner.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mikehans.d308vacationplanner.models.Vacation;

@Database(entities = {Vacation.class}, version = 1, exportSchema = false)
public abstract class VacationDatabase extends RoomDatabase {

    public abstract VacationDao vacationDao();

}

