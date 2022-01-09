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

public class DescribeSkinFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_describe_skin, container, false);

        Button btnContinue = (Button) view.findViewById(R.id.btnContinue_in_DescribeSkin);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_DescribeSkin);
        Button btnSelectSkinType = (Button) view.findViewById(R.id.btn_SelectSkinType);
        Button btnSelectSkinSubtype = (Button) view.findViewById(R.id.btn_SelectSkinSubtype);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new KnowRoutinesFragment());
                fragmentTransaction.commit();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new WelcomeFragment());
                fragmentTransaction.commit();
            }
        });

        btnSelectSkinType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new SelectSkinTypeFragment());
                fragmentTransaction.commit();
            }
        });

        btnSelectSkinSubtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new SelectSkinSubtypeFragment());
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}