package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bb.R;

public class AddStepHomeFragment extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_step_home, container, false);

        Button btnCleanser = (Button)view.findViewById(R.id.cleanser);
        Button btnMoisturizer = (Button)view.findViewById(R.id.moisturizer);
        Button btnSunProtection = (Button)view.findViewById(R.id.sunProtection);

        TextView txt= (TextView) view.findViewById(R.id.stepName);


        btnCleanser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ilgili ürünleri databaseden çekip fragmenta atmalı
                replaceFragment(new CleanserFragment());
                btnCleanser.setVisibility(View.GONE);
                btnMoisturizer.setVisibility(View.GONE);
                btnSunProtection.setVisibility(View.GONE);
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
                txt.setVisibility(View.GONE);
            }
        });

        return view;
    }


    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.addStepHome_frameLayout,fragment);
        fragmentTransaction.commit();

    }

}