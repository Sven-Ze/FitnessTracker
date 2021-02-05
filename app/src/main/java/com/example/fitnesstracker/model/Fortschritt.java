package com.example.fitnesstracker.model;

import com.orm.SugarRecord;

public class Fortschritt extends SugarRecord {
    String pathToPicture;
    String date;

    public String getPathToPicture() {
        return pathToPicture;
    }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Fortschritt() {
    }

    public Fortschritt(String pathToPicture, String date) {
        this.pathToPicture = pathToPicture;
        this.date = date;
    }
}
