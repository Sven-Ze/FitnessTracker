package com.example.fitnesstracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.fitnesstracker.model.Fortschritt;

import java.util.List;

public class FortschrittFragment extends Fragment {

    ListView myList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fortschritt, container, false);

        final ListView list = view.findViewById(R.id.list1);

        List<Fortschritt> fortschritte = Fortschritt.listAll(Fortschritt.class);
        CustomAdapter customAdapter = new CustomAdapter(view.getContext(), fortschritte);
        list.setAdapter(customAdapter);


        return view;


    }


}
