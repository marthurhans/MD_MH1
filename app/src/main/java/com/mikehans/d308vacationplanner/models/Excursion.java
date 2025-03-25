package com.mikehans.d308vacationplanner.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "excursions")
public class Excursion {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String description;
    public String date;
    public int vacationId;

    public Excursion(String title, String description, String date, int vacationId) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.vacationId = vacationId;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", vacationId=" + vacationId +
                '}';
    }

}

