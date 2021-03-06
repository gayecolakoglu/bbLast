package com.example.bb.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bb.MainActivity;
import com.example.bb.R;
//Author: Gaye Çolakoğlu
public class AddStepHomeFragment extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_step_home, container, false);

        // We get the necessary widgets
        Button btnCleanser = (Button)view.findViewById(R.id.cleanser);
        Button btnMoisturizer = (Button)view.findViewById(R.id.moisturizer);
        Button btnSunProtection = (Button)view.findViewById(R.id.sun);
        Button btnSave = (Button)view.findViewById(R.id.btnSave_in_SkinType);
        TextView txt= (TextView) view.findViewById(R.id.stepName);


        // change fragments and make some widgets GONE with btnClick
        btnCleanser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new CleanserFragment());
                btnCleanser.setVisibility(View.GONE);
                btnMoisturizer.setVisibility(View.GONE);
                btnSunProtection.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
                txt.setVisibility(View.GONE);
            }
        });
        btnMoisturizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MoisturizerFragment());
                btnMoisturizer.setVisibility(View.GONE);
                btnCleanser.setVisibility(View.GONE);
                btnSunProtection.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
                txt.setVisibility(View.GONE);
            }
        });
        btnSunProtection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SunProtectionFragment());
                btnCleanser.setVisibility(View.GONE);
                btnMoisturizer.setVisibility(View.GONE);
                btnSunProtection.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
                txt.setVisibility(View.GONE);
            }
        });

        // get the necessary data from database for morning and night routines also display them in MorningFragment and NightFragment
        // change the activity to the MainActivity
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save tıkladığında  kişinin morning ya da nighttan add stepe basılmasını kontrol edip
                // ona göre  databaseden routinesleri RoutinesFragmenta morning ve night olarak atsın .

                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    // function for changing fragment with clicked one
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.addStepHome_frameLayout,fragment);
        fragmentTransaction.commit();

    }

}