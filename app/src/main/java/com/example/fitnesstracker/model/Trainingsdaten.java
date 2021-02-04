package com.example.fitnesstracker.model;

import com.orm.SugarRecord;

public class Trainingsdaten extends SugarRecord {
    String uebung;
    int wiederholungen;
    int gewicht;
    String datum;

    public String getUebung() {
        return uebung;
    }

    public void setUebung(String uebung) {
        this.uebung = uebung;
    }

    public int getWiederholungen() {
        return wiederholungen;
    }

    public void setWiederholungen(int wiederholungen) {
        this.wiederholungen = wiederholungen;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Trainingsdaten() {

    }

    public Trainingsdaten( String uebung, int wiederholungen, int gewicht, String datum) {
        this.uebung = uebung;
        this.wiederholungen = wiederholungen;
        this.gewicht = gewicht;
        this.datum = datum;
    }
}
