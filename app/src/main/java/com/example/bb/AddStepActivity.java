package com.example.bb;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.bb.Fragments.AddStepHomeFragment;
import com.example.bb.Fragments.CleanserFragment;
import com.example.bb.Fragments.HomeFragment;
import com.example.bb.Fragments.MoisturizerFragment;
import com.example.bb.Fragments.SunProtectionFragment;
// Author:Gaye Çolakoğlu

//This activity contains multiple fragments in order to communicate
// between these fragments and another activity's fragments we need to write this activity
public class AddStepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_step);

        // set the opening fragment to the HomeFragment()
        getSupportFragmentManager().beginTransaction().replace(R.id.addStep_frameLayout,new AddStepHomeFragment()).commit();


    }





}