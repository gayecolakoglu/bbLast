package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bb.R;

public class KnowProductFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_know_product, container, false);

        Button btnContinue = (Button) view.findViewById(R.id.btnContinue_in_KnowProduct);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_KnowProduct);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new KnowSkincareIngredientsFragment());
                fragmentTransaction.commit();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new KnowRoutinesFragment());
                fragmentTransaction.commit();
            }
        });

        return view;

    }
}