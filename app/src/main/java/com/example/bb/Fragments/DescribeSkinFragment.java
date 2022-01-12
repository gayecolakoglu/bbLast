package com.example.bb.Fragments;
//Author: Gaye Çolakoğlu
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.example.bb.RegisterActivity;
import com.example.bb.SignInActivity;
import com.example.bb.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class DescribeSkinFragment extends Fragment {
    View view;
    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //Storage
    StorageReference storageReference;

    // Lists for our spinners data
    private String[] skinType={"Select your skin type","On the oilier side","Dry", "Normal","Combination"};
    private String[] skinSubtype={"Select your skin subtype","Redness-prone","Sensitive","Dehydrated","Acne-prone"};

    private FirebaseStorage firebaseStorage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_describe_skin, container, false);


        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        storageReference = firebaseStorage.getInstance().getReference(); //firabase store ref

        // We get the necessary widgets
        Button btnContinue = (Button) view.findViewById(R.id.btnContinue_in_DescribeSkin);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_DescribeSkin);
        Button btnSave = (Button) view.findViewById(R.id.btnSave_in_DescribeSkin);
        Spinner btnSelectSkinType = (Spinner) view.findViewById(R.id.spinner_SelectSkinType);
        Spinner btnSelectSkinSubtype = (Spinner) view.findViewById(R.id.spinner_SelectSkinSubtype);

        // Create Adapter for our spinners
        ArrayAdapter dataAdapterForSkinType = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,skinType);
        ArrayAdapter  dataAdapterForSkinSubtype = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,skinSubtype);

        // Create DropDown for our spinners
        dataAdapterForSkinType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForSkinSubtype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Setting Adapter for our spinners
        btnSelectSkinType.setAdapter(dataAdapterForSkinType);
        btnSelectSkinSubtype.setAdapter(dataAdapterForSkinSubtype);


        // Make toast when item selected from spinners
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


        // Continue with next fragment with btnClick
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.welcomeFragment_frameLayout,new KnowRoutinesFragment());
                fragmentTransaction.commit();
            }
        });

        // Turn back to the last fragment by btnClick
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

                String TxtskinSubtype = btnSelectSkinSubtype.getSelectedItem().toString();
                String TxtskinType = btnSelectSkinType.getSelectedItem().toString();
                HashMap<String,Object> result = new HashMap<>();
                result.put("skinType",TxtskinType);
                result.put("skinSubtype",TxtskinSubtype);

                databaseReference.child(user.getUid()).updateChildren(result)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                //updated so dismiss progress

                                Toast.makeText(getActivity(),"Updated",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //failed show error

                                Toast.makeText(getActivity(),""+e.getMessage(),Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
        return view;
    }
}