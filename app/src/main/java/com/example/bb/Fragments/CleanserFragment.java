package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.bb.R;

public class CleanserFragment extends Fragment {
    View view;

    ImageButton celenes;
    ImageButton cerave;
    ImageButton simple;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cleanser, container, false);

        celenes = (ImageButton) view.findViewById(R.id.cleanser1);
        cerave = (ImageButton) view.findViewById(R.id.cleanser2);
        simple = (ImageButton) view.findViewById(R.id.cleanser3);

        int clickedButtonID = view.getId();

        Button btnForward = (Button) view.findViewById(R.id.btnForward_in_CleanserFragment);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_CleanserFragment);

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Seçilen ürünü gündüz ya da gece rutinine, database kaydetmeli.

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.addStepHome_frameLayout,new AddStepHomeFragment());
                fragmentTransaction.commit();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.addStepHome_frameLayout,new AddStepHomeFragment());
                fragmentTransaction.commit();
            }
        });

        return  view;
    }
}