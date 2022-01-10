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

public class MainActivity<s, message> extends AppCompatActivity {


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();



    }

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
                        case R.id.navigation_signout:
                            //logine yolla
                         //   selectedFragment=new HomeFragment();
                            mAuth.signOut();
                            signOutUser();
                            activity = new SignInActivity();
                            break;
                    }



                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedFragment).commit();
                    return true;
                }

                private void signOutUser() {
                    Intent mainActivity = new Intent(MainActivity.this,SignInActivity.class);
                    mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainActivity);
                    finish();
                }
            };

}