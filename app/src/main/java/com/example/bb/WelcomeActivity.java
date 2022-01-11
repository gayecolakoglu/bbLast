package com.example.bb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.bb.Fragments.AddStepHomeFragment;
import com.example.bb.Fragments.WelcomeFragment;
//Author:Gaye Çolakoğlu

//This activity is written to show once-introductory fragments
// for those who are logging into the application for the first time.
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String tutorialKey = "SOME_KEY";
        Boolean firstTime = getPreferences(MODE_PRIVATE).getBoolean(tutorialKey, true);
        // if user logged in for the first time then start welcome fragments
        if (firstTime) {
            getSupportFragmentManager().beginTransaction().replace(R.id.welcomeActivity_frameLayout,new WelcomeFragment()).commit();
            getPreferences(MODE_PRIVATE).edit().putBoolean(tutorialKey, false).apply();
        }
        // else go to directly home page
        else{
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}