package com.example.fitnesstracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fitnesstracker.model.Trainingsdaten;

import java.util.List;

public class UebersichtFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uebersicht, container, false);
        TableLayout tableLayout = (TableLayout) view.findViewById(R.id.tableLayout);

        List<Trainingsdaten> trainingsdatens = Trainingsdaten.listAll(Trainingsdaten.class);

        for (Trainingsdaten trainingsdaten : trainingsdatens) {

            View tableRow = inflater.inflate(R.layout.table_item, null, false);
            TextView uebung = (TextView) tableRow.findViewById(R.id.uebung);
            TextView anzWiederholungen = (TextView) tableRow.findViewById(R.id.anzWiederholungen);
            TextView gewicht = (TextView) tableRow.findViewById(R.id.gewicht);
            TextView datum = (TextView) tableRow.findViewById(R.id.datum);

            uebung.setText(""+trainingsdaten.getUebung());
            anzWiederholungen.setText(""+trainingsdaten.getWiederholungen());
            gewicht.setText(""+trainingsdaten.getGewicht());
            datum.setText(""+trainingsdaten.getDatum());
            tableLayout.addView(tableRow);
        }
        return view;
    }
}
