package com.example.fitnesstracker.model;

import com.orm.SugarRecord;

public class Fortschritt extends SugarRecord {
    String pathToPicture;
    String date;

    public Fortschritt() {
    }

    public Fortschritt(String pathToPicture, String date) {
        this.pathToPicture = pathToPicture;
        this.date = date;
    }
}
