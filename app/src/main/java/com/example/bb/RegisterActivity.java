package com.example.bb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//Author: Rozerin Yıldız

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_register;
    EditText email, password;
    FirebaseAuth mAuth;
    TextView haveAnAccount;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // We get the necessary widgets
        email =findViewById(R.id.email_in_RegisterActivity);
        password =findViewById(R.id.password_in_RegisterActivity);
        btn_register =findViewById(R.id.btnRegister_in_RegisterActivity);
        haveAnAccount = findViewById(R.id.haveAnAccount);

        //firebase init
        mAuth=FirebaseAuth.getInstance();

        //register = (Button) findViewById(R.id.btnRegister_in_RegisterActivity);
        //register.setOnClickListener(this);

        // change activity to SignIn acivity if button clicked
        haveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = RegisterActivity.this.email.getText().toString().trim();
                String password= RegisterActivity.this.password.getText().toString().trim();
                if(email.isEmpty())
                {
                    RegisterActivity.this.email.setError("Email is empty");
                    RegisterActivity.this.email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    RegisterActivity.this.email.setError("Enter the valid email address");
                    RegisterActivity.this.email.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    RegisterActivity.this.password.setError("Enter the password");
                    RegisterActivity.this.password.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    RegisterActivity.this.password.setError("Length of the password should be more than 6");
                    RegisterActivity.this.password.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this,"You are successfully Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, SignInActivity.class));
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister_in_RegisterActivity:
                startActivity(new Intent(this, RegisterUser.class));
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //Go previous activity.
        return super.onSupportNavigateUp();
    }
}