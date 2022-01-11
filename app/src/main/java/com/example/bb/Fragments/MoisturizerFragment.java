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
public class MoisturizerFragment extends Fragment {
    View view;

    ImageButton moisturizer1;
    ImageButton moisturizer2;
    ImageButton moisturizer3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_moisturizer, container, false);

        // We get the necessary widgets
        moisturizer1 = (ImageButton) view.findViewById(R.id.moisturizer1);
        moisturizer2 = (ImageButton) view.findViewById(R.id.moisturizer2);
        moisturizer3 = (ImageButton) view.findViewById(R.id.moisturizer3);
        Button btnForward = (Button) view.findViewById(R.id.btnForward_in_MoisturizerFragment);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_MoisturizerFragment) ;

        //her bir imgBtn için setOnCLickListener yap , tıklandığında morning ya da nighttan addStepe basılmasına
        // göre database o ürünü  morning ya da night routine atsın

        // get the clicked button id to understand if we are gonna add product morning or night routine.
        int clickedRoutine = view.getId();

        moisturizer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add this product to the clickedRoutine database
            }
        });

        moisturizer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add this product to the clickedRoutine database
            }
        });
        moisturizer3.setOnClickListener(new View.OnClickListener() {
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