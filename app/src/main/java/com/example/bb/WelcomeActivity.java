package com.example.bb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.bb.Fragments.AddStepHomeFragment;
import com.example.bb.Fragments.WelcomeFragment;

public class WelcomeActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Boolean firstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

       /* sharedPreferences = getSharedPreferences("WelcomeActivity",MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime",true);

        if (firstTime){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            firstTime = false;
            editor.putBoolean("firstTime",firstTime);
            editor.apply();

            getSupportFragmentManager().beginTransaction().replace(R.id.welcomeActivity_frameLayout,new WelcomeFragment()).commit();
        }else {
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
        }*/


    }

    @Override
    protected void onResume() {
        super.onResume();
        String tutorialKey = "SOME_KEY";
        Boolean firstTime = getPreferences(MODE_PRIVATE).getBoolean(tutorialKey, true);
        if (firstTime) {
            getSupportFragmentManager().beginTransaction().replace(R.id.welcomeActivity_frameLayout,new WelcomeFragment()).commit(); // here you do what you want to do - an activity tutorial in my case
            getPreferences(MODE_PRIVATE).edit().putBoolean(tutorialKey, false).apply();
        }else{
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}