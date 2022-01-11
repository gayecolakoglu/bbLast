package com.example.bb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//Author: Gaye Çolakoğlu
public class SignInActivity extends AppCompatActivity {
    private EditText email, password;
    //firebase
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // We get the necessary widgets
        email =findViewById(R.id.email_in_SignInActivity);
        password =findViewById(R.id.password_in_SignInActivity);
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_register = findViewById(R.id.btn_Register_in_SignInActivity);

        //firebase init
        mAuth=FirebaseAuth.getInstance();

        // check classic terms for login button click
        btn_login.setOnClickListener(v -> {
            String email= this.email.getText().toString().trim();
            String password= this.password.getText().toString().trim();

            if(email.isEmpty())
            {
                this.email.setError("Email is empty");
                this.email.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                this.email.setError("Enter the valid email");
                this.email.requestFocus();
                return;
            }
            if(password.isEmpty())
            {
                this.password.setError("Password is empty");
                this.password.requestFocus();
                return;
            }
            if(password.length()<6)
            {
                this.password.setError("Length of password is more than 6");
                this.password.requestFocus();
                return;
            }
            // if nothing is wrong then change activity to Welcome activty else make a toast
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    startActivity(new Intent(SignInActivity.this, WelcomeActivity.class));
                }
                else
                {
                    Toast.makeText(SignInActivity.this,
                            "Please Check Your login Credentials",
                            Toast.LENGTH_SHORT).show();
                }

            });
        });

        // if register button is clicked then change the activity to the Register activity
        btn_register.setOnClickListener(v -> startActivity(new Intent(SignInActivity.this,RegisterActivity.class )));
    }

}