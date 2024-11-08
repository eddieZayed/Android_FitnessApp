package com.bzu.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnWorkoutTracker, btnBMICalculator, btnCaloriesCalculator, btnMacrosCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWorkoutTracker = findViewById(R.id.btnWorkoutTracker);
        btnBMICalculator = findViewById(R.id.btnBMICalculator);
        btnCaloriesCalculator = findViewById(R.id.btnCaloriesCalculator);
        btnMacrosCalculator = findViewById(R.id.btnMacrosCalculator);

        btnWorkoutTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorkoutTrackerActivity.class);
                startActivity(intent);
            }
        });

        btnBMICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BMICalculatorActivity.class);
                startActivity(intent);
            }
        });

        btnCaloriesCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaloriesCalculatorActivity.class);
                startActivity(intent);
            }
        });

        btnMacrosCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MacrosCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
