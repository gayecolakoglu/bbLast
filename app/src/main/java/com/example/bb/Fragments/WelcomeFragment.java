package com.example.bb.Fragments;
// Author: Gaye Çolakoğlu
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bb.R;

public class WelcomeFragment extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // We get the necessary widgets according to the ids
        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        Button btnContinue = (Button)view.findViewById(R.id.btnContinue_in_Welcome);
        EditText password = (EditText) view.findViewById(R.id.password_in_Welcome);
        EditText email = (EditText) view.findViewById(R.id.email_in_Welcome);
        TextView txtWelcome = (TextView) view.findViewById(R.id.txtWelcome);
        TextView skinTypeConcerns = (TextView) view.findViewById(R.id.skinType_concerns);
        TextView skinType = (TextView) view.findViewById(R.id.skinType);
        TextView skinSubtype = (TextView) view.findViewById(R.id.skinSubType);

        //datadan userın password ve emailini çek.EditTexte yerleştir
        //vakit varsa düzenleyebilmesi için save changes butonu ekle


        // go to the next fragment with btnClick
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //For change fragments
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new DescribeSkinFragment());
                fragmentTransaction.commit();

                // we do not want to see these widgets at our next fragments
                // so make them GONE
                btnContinue.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                email.setVisibility(View.GONE);
                txtWelcome.setVisibility(View.GONE);
                skinTypeConcerns.setVisibility(View.GONE);
                skinType.setVisibility(View.GONE);
                skinSubtype.setVisibility(View.GONE);
            }
        });

        return view;
    }
}