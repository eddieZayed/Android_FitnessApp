package com.bzu.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutTrackerActivity extends AppCompatActivity {

    private Button btnCardioWorkouts, btnGymWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_tracker);

        btnCardioWorkouts = findViewById(R.id.btnCardioWorkouts);
        btnGymWorkouts = findViewById(R.id.btnGymWorkouts);

        btnCardioWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutTrackerActivity.this, CardioWorkoutsActivity.class);
                startActivity(intent);
            }
        });

        btnGymWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutTrackerActivity.this, GymWorkoutsActivity.class);
                startActivity(intent);
            }
        });
    }
}
