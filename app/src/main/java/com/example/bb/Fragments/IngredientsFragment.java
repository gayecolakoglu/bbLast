package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bb.R;
import com.example.bb.SignInActivity;
//Author:Gaye Çolakoğlu
public class IngredientsFragment extends Fragment {
    View view;

    public IngredientsFragment(){}; //Required empty public Constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ingredients, container, false);


        // make item list for our ingredients list
        String[] list1Items = {"Alpha-hydroxy acids (AHAs)",
                                "Hyaluronic acid",
                                "Copper peptide",
                                "DMAE (dimethylaminoethanol)"};

        String[] list2Items = {"Copper peptide",
                "Polyhydroxy acids",
                "Retinoids",
                "Kojic acid"};

        String[] list3Items = {"Alpha-lipoic acid",
                "L-ascorbic acid",
                "Beta-hydroxy acid (salicylic acid)",
                "Hydroquinone"};


        // Get listViews by ther id
        // Create ArrayAdapter for our list items
        ListView list1 = (ListView) view.findViewById(R.id.list1);
        ArrayAdapter<String> list1Adapter = new ArrayAdapter<String>(
            getActivity(),
            android.R.layout.simple_list_item_1,
                list1Items
        );

        ListView list2 = (ListView) view.findViewById(R.id.list2);
        ArrayAdapter<String> list2Adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list2Items
        );

        ListView list3 = (ListView) view.findViewById(R.id.list3);
        ArrayAdapter<String> list3Adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list3Items
        );

        // setting the adapters to our listViews
        list1.setAdapter(list1Adapter);
        list2.setAdapter(list2Adapter);
        list3.setAdapter(list3Adapter);


        // get the incoming message from other fragment
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");

        // Arrange the visibility by incoming message which is clicked button information
        switch (bundle.getString("key")){
            case "btn1":
                list2.setVisibility(View.GONE);
                list3.setVisibility(View.GONE);
                break;
            case "btn2":
                list1.setVisibility(View.GONE);
                list3.setVisibility(View.GONE);
                break;
            case "btn3":
                list1.setVisibility(View.GONE);
                list2.setVisibility(View.GONE);
                break;

        }

        return  view;
    }
}