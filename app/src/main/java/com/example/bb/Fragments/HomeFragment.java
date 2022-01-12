package com.example.bb.Fragments;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bb.R;
import com.example.bb.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//Author: Gaye Çolakoğlu
public class HomeFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        // We get the necessary widgets

        TextView btnSelectSkinType = (TextView) view.findViewById(R.id.spinner_SkinType_in_HomeFragment);
        TextView btnSelectSkinSubtype = (TextView) view.findViewById(R.id.spinner_SkinSubType_in_HomeFragment);

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference uidRef = rootRef.child("Users").child(uid);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                String skinType =  user.getSkinType();
                btnSelectSkinType.setText(skinType);
                String skinSubtype =  user.getSkinSubtype();
                btnSelectSkinSubtype.setText(skinSubtype);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        uidRef.addListenerForSingleValueEvent(valueEventListener);



        return view;
    }
}