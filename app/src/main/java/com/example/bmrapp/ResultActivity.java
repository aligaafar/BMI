package com.example.bmrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView result;
    double calculation;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textView2);

      calculation = getIntent().getExtras().getDouble("cal");
      st = Double.toString(calculation);

      result.setText(st);

    }
}