package com.example.bmrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    EditText age,height,weight,neck,waist;
    Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        neck = findViewById(R.id.neck);
        waist = findViewById(R.id.waist);
        Calculate = findViewById(R.id.Calculate);



        Calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final int Age = parseInt(age.getText().toString());
                final double Height = parseDouble(height.getText().toString());
                final double Weight = parseDouble(weight.getText().toString());
                final double Neck = parseDouble(neck.getText().toString());
                final double Waist = parseDouble(waist.getText().toString());
                final double calculation = Weight/(Height*Height*Height);
                Intent i = new Intent(MainActivity.this,ResultActivity.class);
                i.putExtra("cal",calculation);
                startActivity(i);
            }
        });


    }


    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}