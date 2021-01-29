package com.example.fitnesstracker.model;

import com.orm.SugarRecord;

public class Fortschritt extends SugarRecord {
    int ID;
    String pathToPicture;
    String date;

    public Fortschritt() {
    }

    public Fortschritt(int ID, String pathToPicture, String date) {
        this.ID = ID;
        this.pathToPicture = pathToPicture;
        this.date = date;
    }
}
