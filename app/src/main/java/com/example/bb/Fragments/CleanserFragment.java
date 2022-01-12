package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bb.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

//Author:Rozerin Yıldız
public class CleanserFragment extends Fragment {
    View view;

    public CleanserFragment(){}; //Required empty public Constructor

    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //Storage
    StorageReference storageReference;

    private FirebaseStorage firebaseStorage;

    ImageButton cleanser1;
    ImageButton cleanser2;
    ImageButton cleanser3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cleanser, container, false);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        storageReference = firebaseStorage.getInstance().getReference(); //firabase store ref



        // We get the necessary widgets
        Button btnForward = (Button) view.findViewById(R.id.btnForward_in_CleanserFragment);
        Button btnBack = (Button) view.findViewById(R.id.btnBack_in_CleanserFragment);
        cleanser1 = (ImageButton) view.findViewById(R.id.cleanser1);
        cleanser2 = (ImageButton) view.findViewById(R.id.cleanser2);
        cleanser3 = (ImageButton) view.findViewById(R.id.cleanser3);

        // get the clicked button id to understand if we are gonna add product morning or night routine.
        // get the incoming message from other fragment
        Bundle bundle = this.getArguments();

        cleanser1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {/*
                String cleanser = "cleanser1";
                HashMap<String,Object> result = new HashMap<>();
                String data = bundle.getString("key");
                System.out.println(data);



                switch (bundle.getString("key")){
                    case "night":
                        System.out.println("dddd");
                        result.put("nightCleanser",cleanser);
                        break;
                    case "morning":
                        System.out.println("eeeeee");
                        result.put("morningCleanser",cleanser);
                        break;
                }


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
            */}
        });

        cleanser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add this product to the clickedRoutine database
            }
        });

        cleanser3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add this product to the clickedRoutine database
            }
        });





        // Go back to the AddStepHomeFragment with btnClick
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Seçilen ürünü gündüz ya da gece rutinine, database kaydetmeli.

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.addStepHome_frameLayout,new AddStepHomeFragment());
                fragmentTransaction.commit();
            }
        });

        // Go back to the AddStepHomeFragment with btnClick
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.addStepHome_frameLayout,new AddStepHomeFragment());
                fragmentTransaction.commit();
            }
        });

        return  view;
    }
}