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
//Author:Rozerin Yıldız
public class SunProtectionFragment extends Fragment {

    View view;

    ImageButton sun1;
    ImageButton sun2;
    ImageButton sun3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sun_protection, container, false);

        // We get the necessary widgets
        sun1 = (ImageButton) view.findViewById(R.id.sun1);
        sun2 = (ImageButton) view.findViewById(R.id.sun2);
        sun3 = (ImageButton) view.findViewById(R.id.sun3);
        Button btnForward = (Button) view.findViewById(R.id.btnForward_in_SunProtectionFragment);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_SunProtectionFragment);

        //her bir imgBtn için setOnCLickListener yap , tıklandığında morning ya da nighttan addStepe basılmasına
        // göre database o ürünü  morning ya da night routine atsın

        // get the clicked button id to understand if we are gonna add product morning or night routine.
        int clickedRoutine = view.getId();


        sun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add this product to the clickedRoutine database
            }
        });

        sun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add this product to the clickedRoutine database
            }
        });

        sun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add this product to the clickedRoutine database
            }
        });


        // Go back to the AddStepHomeFragment with btnClick
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Seçilen ürünü database kaydetmeli ve Routines fragment kısmında display etmeli

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.addStepHome_frameLayout,new AddStepHomeFragment());
                fragmentTransaction.commit();
            }
        });

        // Go back to the AddStepHomeFragment with btnClick
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.addStepHome_frameLayout,new AddStepHomeFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}