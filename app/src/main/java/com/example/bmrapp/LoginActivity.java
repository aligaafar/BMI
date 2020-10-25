package com.example.bmrapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    TextView createAccount;
    FirebaseAuth auth;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        createAccount = findViewById(R.id.createAccount);
        login = findViewById(R.id.login);
        auth = FirebaseAuth.getInstance();
        pb = findViewById(R.id.progressBar2);


        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {

                                         String Email = email.getText().toString().trim();
                                         String Password = password.getText().toString().trim();

                                         if (TextUtils.isEmpty(Email)) {
                                             email.setError("Email is required.");
                                             return;
                                         }

                                         if (TextUtils.isEmpty(Password)) {
                                             password.setError("Password is required.");
                                             return;
                                         }

                                         if (Password.length() < 8) {
                                             password.setError("Password must have at least 8 characters.");
                                             return;
                                         }

                                         pb.setVisibility(View.VISIBLE);

                                         auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                                                        @Override
                                                                                                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                                                            if (task.isSuccessful()) {
                                                                                                                                Toast.makeText(LoginActivity.this, "Logged in successfully.", Toast.LENGTH_SHORT).show();
                                                                                                                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                                                                                                            } else {
                                                                                                                                Toast.makeText(LoginActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                                                                            }
                                                                                                                        }
                                         }
                                         );

                                     }
                                 }
        );

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

    }
}
