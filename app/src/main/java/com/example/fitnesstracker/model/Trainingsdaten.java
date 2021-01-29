package com.example.fitnesstracker.model;

import com.orm.SugarRecord;

public class Trainingsdaten extends SugarRecord {
    int ID;
    String uebung;
    int saetze;
    int wiederholungen;
    int gewicht;
    String datum;

    public Trainingsdaten() {
    }

    public Trainingsdaten(int ID, String uebung, int saetze, int wiederholungen, int gewicht, String datum) {
        this.ID = ID;
        this.uebung = uebung;
        this.saetze = saetze;
        this.wiederholungen = wiederholungen;
        this.gewicht = gewicht;
        this.datum = datum;
    }
}
