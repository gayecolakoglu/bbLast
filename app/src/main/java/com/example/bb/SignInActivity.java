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

public class SignInActivity extends AppCompatActivity {
    private EditText email, password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email =findViewById(R.id.email_in_SignInActivity);
        password =findViewById(R.id.password_in_SignInActivity);
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_register = findViewById(R.id.btn_Register_in_SignInActivity);
        mAuth=FirebaseAuth.getInstance();
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
        btn_register.setOnClickListener(v -> startActivity(new Intent(SignInActivity.this,RegisterActivity.class )));
    }

}