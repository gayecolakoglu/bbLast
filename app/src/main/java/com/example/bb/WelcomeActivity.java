package com.example.bb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bb.Fragments.AddStepHomeFragment;
import com.example.bb.Fragments.WelcomeFragment;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportFragmentManager().beginTransaction().replace(R.id.welcomeActivity_frameLayout,new WelcomeFragment()).commit();
    }
}