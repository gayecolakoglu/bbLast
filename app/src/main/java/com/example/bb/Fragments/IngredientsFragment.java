package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bb.R;

public class IngredientsFragment extends Fragment {
    TextView txtMsg;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        txtMsg = (TextView) view.findViewById(R.id.txtMsg);
        Bundle bundle = getArguments();

        if (bundle != null) {
            System.out.println("111111111111111111");
            txtMsg.setText(String.valueOf(bundle.getString("key1")));
        }
        System.out.println("111111111111111111");

        return  view;
    }
}