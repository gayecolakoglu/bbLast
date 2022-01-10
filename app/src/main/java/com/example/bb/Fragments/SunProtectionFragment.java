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

        sun1 = (ImageButton) view.findViewById(R.id.sun1);
        sun2 = (ImageButton) view.findViewById(R.id.sun2);
        sun3 = (ImageButton) view.findViewById(R.id.sun3);

        //her bir imgBtn için setOnCLickListener yap , tıklandığında morning ya da nighttan addStepe basılmasına
        // göre database o ürünü  morning ya da night routine atsın

        Button btnForward = (Button) view.findViewById(R.id.btnForward_in_SunProtectionFragment);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_SunProtectionFragment);

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