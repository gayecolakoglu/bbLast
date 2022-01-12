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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
//Author: Gaye Çolakoğlu

public class RegisterActivity extends AppCompatActivity{

    Button btn_register;
    EditText txtEmail, txtPassword;
    FirebaseAuth mAuth;
    TextView haveAnAccount;

    private Button register;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // We get the necessary widgets
        txtEmail =findViewById(R.id.email_in_RegisterActivity);
        txtPassword =findViewById(R.id.password_in_RegisterActivity);
        btn_register =findViewById(R.id.btnRegister_in_RegisterActivity);
        haveAnAccount = findViewById(R.id.haveAnAccount);

        //firebase init
        mAuth=FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();



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
                String email = txtEmail.getText().toString();
                String password= txtPassword.getText().toString();


                if(password.length()<6)
                {
                    txtPassword.setError("Length of the password should be more than 6");
                    txtPassword.requestFocus();
                    return;
                }

                if(email.isEmpty())
                {
                    txtEmail.setError("Email is empty");
                    txtEmail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    txtEmail.setError("Enter the valid email address");
                    txtEmail.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    txtPassword.setError("Enter the password");
                    txtPassword.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser user = mAuth.getCurrentUser();

                        String uid = user.getUid();
                        String email = user.getEmail();

                        Toast.makeText(RegisterActivity.this,"User created.\n"+user.getEmail(),Toast.LENGTH_LONG).show();

                        HashMap<Object,String> userCreatedInfos = new HashMap<>();
                        userCreatedInfos.put("email",email);
                        userCreatedInfos.put("password",password);
                        userCreatedInfos.put("uid",uid);  //Field'll edit in profile
                        userCreatedInfos.put("skinType","");  //Field'll edit in profile
                        userCreatedInfos.put("skinSubtype","");  //Field'll edit in profile
                        userCreatedInfos.put("morningCleanser","");   //Field'll edit in profile
                        userCreatedInfos.put("morningMoisturizer","");   //Field'll edit in profile
                        userCreatedInfos.put("morningSun","");   //Field'll edit in profile
                        userCreatedInfos.put("nightCleanser","");   //Field'll edit in profile
                        userCreatedInfos.put("nightMoisturizer","");   //Field'll edit in profile
                        userCreatedInfos.put("nightSun","");   //Field'll edit in profile

                        //Firebasedatabase instance
                        FirebaseDatabase database = FirebaseDatabase.getInstance();

                        //path to 'Users'
                        DatabaseReference reference = database.getReference("Users");
                        //put data within hashmap
                        reference.child(uid).setValue(userCreatedInfos);

                        Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //Go previous activity.
        return super.onSupportNavigateUp();
    }
}