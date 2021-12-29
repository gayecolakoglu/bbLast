package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bb.Fragments.MorningFragment;
import com.example.bb.Fragments.NightFragment;
import com.example.bb.R;

public class RoutinesFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_routines, container, false);
        Button morning = (Button) view.findViewById(R.id.morning);
        Button night = (Button) view.findViewById(R.id.night);
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MorningFragment());
            }
        });night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new NightFragment());
            }
        });
        return view;
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.routines_frameLayout,fragment);
        fragmentTransaction.commit();

    }
}