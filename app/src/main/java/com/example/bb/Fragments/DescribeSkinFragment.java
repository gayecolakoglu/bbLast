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
import android.widget.TextView;
import android.widget.Toast;

import com.example.bb.R;

public class DescribeSkinFragment extends Fragment {
    View view;
    private String[] skinType={"Select your skin type","On the oilier side","Dry", "Normal","Combination"};
    private String[] skinSubtype={"Select your skin subtype","Redness-prone","Sensitive","Dehydrated","Acne-prone"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_describe_skin, container, false);

        Button btnContinue = (Button) view.findViewById(R.id.btnContinue_in_DescribeSkin);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_DescribeSkin);
        Button btnSave = (Button) view.findViewById(R.id.btnSave_in_DescribeSkin);
        Spinner btnSelectSkinType = (Spinner) view.findViewById(R.id.spinner_SelectSkinType);
        Spinner btnSelectSkinSubtype = (Spinner) view.findViewById(R.id.spinner_SelectSkinSubtype);

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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //seçilenleri database at
            }
        });
        return view;
    }
}