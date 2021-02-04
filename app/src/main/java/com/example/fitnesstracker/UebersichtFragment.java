package com.example.fitnesstracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class UebersichtFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uebersicht, container, false);
        TableLayout tableLayout = (TableLayout) view.findViewById(R.id.tableLayout);

        for (int i = 0; i < 5; i++) {
            View tableRow = inflater.inflate(R.layout.table_item, null, false);
            TextView uebung = (TextView) tableRow.findViewById(R.id.uebung);
            TextView anzWiederholungen = (TextView) tableRow.findViewById(R.id.anzWiederholungen);
            TextView gewicht = (TextView) tableRow.findViewById(R.id.gewicht);
            TextView datum = (TextView) tableRow.findViewById(R.id.datum);

            uebung.setText("Brust");
            anzWiederholungen.setText("3");
            gewicht.setText("55kg");
            datum.setText("04-02-2021");
            tableLayout.addView(tableRow);

        }
        return view;
    }
}
