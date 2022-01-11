package com.example.bb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bb.Fragments.HomeFragment;
import com.example.bb.Fragments.ProductsFragment;
import com.example.bb.Fragments.RoutinesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
// Author: Gaye Çolakoğlu
public class MainActivity<s, message> extends AppCompatActivity {
    //create mAuth for access database
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        //Create bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // set the opening fragment to the HomeFragment()
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();

    }

    // open the clicked fragment by getting it's id
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    Activity activity = null;

                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selectedFragment=new HomeFragment();
                            break;
                        case R.id.navigation_routines:
                            selectedFragment=new RoutinesFragment();
                            break;
                        case R.id.navigation_products:
                            selectedFragment=new ProductsFragment();
                            break;
                        // signout and change activity to SignInAcivity
                        case R.id.navigation_signout:
                            mAuth.signOut();
                            signOutUser();
                            activity = new SignInActivity();
                            break;
                    }


                    //for change fragment with clicked one
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedFragment).commit();
                    return true;
                }

                // function for sigonut fragment: change activity to SignInActivity if clicked.
                private void signOutUser() {
                    Intent mainActivity = new Intent(MainActivity.this,SignInActivity.class);
                    mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainActivity);
                    finish();
                }
            };

}