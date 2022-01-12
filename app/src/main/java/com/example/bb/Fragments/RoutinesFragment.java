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
import com.example.bb.Fragments.MorningFragment;
import com.example.bb.Fragments.NightFragment;
import com.example.bb.MainActivity;
import com.example.bb.R;
//Author:Gaye Çolakoğlu
public class RoutinesFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_routines, container, false);

        // We get the necessary widgets
        Button morning = (Button) view.findViewById(R.id.morning);
        Button night = (Button) view.findViewById(R.id.night);
        Button addStepBtn = (Button) view.findViewById(R.id.addStepBtn);

        // set the opening fragment to the HomeFragment()
        replaceFragment(new MorningFragment());


        // open clicked btn's fragment
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key","morning".toString());

                MorningFragment newFragment = new MorningFragment();
                newFragment.setArguments(bundle);

                // set opening fragments to the IngredientsFragment
                getFragmentManager().beginTransaction().replace(R.id.routines_frameLayout,newFragment).commit();
            }
        });
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key","night".toString());

                NightFragment newFragment = new NightFragment();
                newFragment.setArguments(bundle);

                // set opening fragments to the IngredientsFragment
                getFragmentManager().beginTransaction().replace(R.id.routines_frameLayout,newFragment).commit();

            }
        });


        // open clicked activity
        addStepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AddStepActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    // function for changing fragment with clicked one
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.routines_frameLayout,fragment);
        fragmentTransaction.commit();

    }
}