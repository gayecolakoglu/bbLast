package com.example.bb.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bb.AddStepActivity;
import com.example.bb.MainActivity;
import com.example.bb.R;

public class KnowSkincareIngredientsFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_know_skincare_ingredients, container, false);

        Button btnContinue = (Button) view.findViewById(R.id.btnContinue_in_KnowIngredients);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_KnowIngredients);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new KnowProductFragment());
                fragmentTransaction.commit();
            }
        });


        return  view;
    }
}