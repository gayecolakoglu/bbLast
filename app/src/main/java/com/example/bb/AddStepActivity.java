package com.example.bb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.bb.Fragments.AddStepHomeFragment;
import com.example.bb.Fragments.CleanserFragment;
import com.example.bb.Fragments.MoisturizerFragment;
import com.example.bb.Fragments.SunProtectionFragment;

public class AddStepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_step);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.addStep_frameLayout, new AddStepHomeFragment());
        fragmentTransaction.commit();
    }
}