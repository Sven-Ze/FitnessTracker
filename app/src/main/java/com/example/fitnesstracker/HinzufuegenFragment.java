package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fitnesstracker.model.Fortschritt;
import com.example.fitnesstracker.model.Trainingsdaten;

import java.util.List;

public class HinzufuegenFragment extends Fragment {

    private static String DATEREGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//imageButton

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hinzufuegen, container, false);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });


        Button fortschrittHinzufuegen = (Button) view.findViewById(R.id.HinzufuegenFortSchritt);
        fortschrittHinzufuegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = view.findViewById(R.id.dateiname);
                String path = textView.getText().toString();
                if (checkIfStringEmpty(path)) {
                    TextView meldung = (TextView) view.findViewById(R.id.FehlerFortschritt);
                    meldung.setText("Bitte Bild aufnehmen");
                    return;
                }
                EditText textboxDatum = (EditText) view.findViewById(R.id.DatumFortschritt);
                String datum = textboxDatum.getText().toString();

                if (datum.matches(DATEREGEX)) {
                    System.out.println("Richtig: " + datum);
                    TextView meldung = (TextView) view.findViewById(R.id.FehlerFortschritt);
                    Fortschritt fortschritt = new Fortschritt(path,datum);
                    fortschritt.save();
                    textboxDatum.setText("");
                    textView.setText("");
                    meldung.setText("");
                } else {
                    System.out.println("Falsch: " + datum);
                    TextView meldung = (TextView) view.findViewById(R.id.FehlerFortschritt);
                    meldung.setText("Falsches Datum eingegeben bitte neu eingeben");
                }

            }
        });

        Button trainingsDatenHinzufuegen = (Button) view.findViewById(R.id.ButtonTDHinzufuegen);
        trainingsDatenHinzufuegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checker = true;
                TextView meldung = (TextView) view.findViewById(R.id.fehlerTD);

                EditText textboxUebung = (EditText) view.findViewById(R.id.Uebung);
                String uebung = textboxUebung.getText().toString();
                if (uebung.isEmpty()) {
                    checker = false;
                    meldung.setText("Bitte Übung eingeben");
                    return;
                }

                EditText textboxDatum = (EditText) view.findViewById(R.id.DatumTDaten);
                String datum = textboxDatum.getText().toString();

                EditText textboxKg1 = (EditText) view.findViewById(R.id.GewichtSatz1);
                if (checkIfStringEmpty(textboxKg1.getText().toString())) {
                    meldung.setText("Bitte Kilos angeben beim 1.Satz");
                    return;
                }
                double kg1 = Double.parseDouble(textboxKg1.getText().toString());


                EditText textboxWied1 = (EditText) view.findViewById(R.id.WiedSatz1);
                if (checkIfStringEmpty(textboxWied1.getText().toString())) {
                    meldung.setText("Bitte Wiederholungen angeben beim 1.Satz");
                    return;
                }
                int wied1 = Integer.parseInt(textboxWied1.getText().toString());

                EditText textboxKg2 = (EditText) view.findViewById(R.id.GewichtSatz2);
                if (checkIfStringEmpty(textboxKg2.getText().toString())) {
                    meldung.setText("Bitte Kilos angeben beim 2.Satz");
                    return;
                }
                double kg2 = Double.parseDouble(textboxKg2.getText().toString());

                EditText textboxWied2 = (EditText) view.findViewById(R.id.WiedSatz2);
                if (checkIfStringEmpty(textboxWied2.getText().toString())) {
                    meldung.setText("Bitte Wiederholungen angeben beim 2.Satz");
                    return;
                }
                int wied2 = Integer.parseInt(textboxWied2.getText().toString());

                EditText textboxKg3 = (EditText) view.findViewById(R.id.GewichtSatz3);
                if (checkIfStringEmpty(textboxKg3.getText().toString())) {
                    meldung.setText("Bitte Kilos angeben beim 3.Satz");
                    return;
                }
                double kg3 = Double.parseDouble(textboxKg3.getText().toString());

                EditText textboxWied3 = (EditText) view.findViewById(R.id.WiedSatz3);
                if (checkIfStringEmpty(textboxWied3.getText().toString())) {
                    meldung.setText("Bitte Wiederholungen angeben beim 3.Satz");
                    return;
                }
                int wied3 = Integer.parseInt(textboxWied3.getText().toString());

                if (datum.matches(DATEREGEX)) {
                    Trainingsdaten trainingsdaten = new Trainingsdaten(uebung, (wied1 + wied2 + wied3) / 3, (int) (kg1 + kg2 + kg3) / 3, datum);
                    trainingsdaten.save();
                    textboxDatum.setText("");
                    textboxKg1.setText("");
                    textboxKg2.setText("");
                    textboxKg3.setText("");
                    textboxUebung.setText("");
                    textboxWied1.setText("");
                    textboxWied2.setText("");
                    textboxWied3.setText("");
                    List<Trainingsdaten> td = Trainingsdaten.listAll(Trainingsdaten.class);
                    Log.d("DATABASE", "" + td.size());
                    meldung.setText("");
                } else {
                    System.out.println("Falsch: " + datum);
                    meldung.setText("Falsches Datum eingegeben bitte neu eingeben");
                }
            }
        });
        String pfad = null;
        try {
            pfad = getArguments().getString("pfadText");
        } catch (Exception e) {

        }
        TextView pfadNamenAnz = (TextView) view.findViewById(R.id.dateiname);

        if (pfad != null) {
            pfadNamenAnz.setText(pfad);
        }

        return view;
    }

    public boolean checkIfStringEmpty(String stringtoCheck) {
        if (stringtoCheck.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
