package com.mikehans.d308vacationplanner.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vacation_table")
public class Vacation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String hotel;
    private String startDate;
    private String endDate;

    // Constructor
    public Vacation(String title, String hotel, String startDate, String endDate) {
        this.title = title;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getHotel() { return hotel; }
    public void setHotel(String hotel) { this.hotel = hotel; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
}

