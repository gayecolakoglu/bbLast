package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bb.R;

public class HomeFragment extends Fragment {

    View view;
    //default spinner seçimini databaseden çek koy.
    private String[] skinType={"Select your skin type","On the oilier side","Dry", "Normal","Combination"};
    private String[] skinSubtype={"Select your skin subtype","Redness-prone","Sensitive","Dehydrated","Acne-prone"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnSave = (Button) view.findViewById(R.id.btnSave_in_HomeFragment);

        //default spinner değeri olarak databasedekileri buraya ekle
        Spinner btnSelectSkinType = (Spinner) view.findViewById(R.id.spinner_SkinType_in_HomeFragment);
        Spinner btnSelectSkinSubtype = (Spinner) view.findViewById(R.id.spinner_SkinSubType_in_HomeFragment);

        ArrayAdapter dataAdapterForSkinType = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,skinType);
        ArrayAdapter  dataAdapterForSkinSubtype = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,skinSubtype);


        dataAdapterForSkinType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForSkinSubtype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        btnSelectSkinType.setAdapter(dataAdapterForSkinType);
        btnSelectSkinSubtype.setAdapter(dataAdapterForSkinSubtype);

        btnSelectSkinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(),skinType[position] , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnSelectSkinSubtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), skinSubtype[position], Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //seçilenleri database at
            }
        });

        return view;
    }
}