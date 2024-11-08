package com.bzu.fitnessapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GymWorkoutsActivity extends AppCompatActivity {

    private RadioGroup muscleGroupRadioGroup;
    private Button btnShowGymWorkouts;
    private ListView gymListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_workouts);

        muscleGroupRadioGroup = findViewById(R.id.muscleGroupRadioGroup);
        btnShowGymWorkouts = findViewById(R.id.btnShowGymWorkouts);
        gymListView = findViewById(R.id.gymListView);

        btnShowGymWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWorkouts();
            }
        });
    }

    private void showWorkouts() {
        List<Workout> gymWorkouts = getGymWorkouts();
        List<String> workoutDisplayList = new ArrayList<>();

        for (int i = 0; i < gymWorkouts.size(); i++) {
            Workout workout = gymWorkouts.get(i);
            workoutDisplayList.add((i + 1) + ". " + workout.getName() + " (" + workout.getDuration() + " mins, " + workout.getCaloriesBurned() + " cal)");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, workoutDisplayList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.BLACK);
                return view;
            }
        };

        gymListView.setAdapter(adapter);

        gymListView.setOnItemClickListener((parent, view, position, id) -> {
            Workout selectedWorkout = gymWorkouts.get(position);
            Toast.makeText(GymWorkoutsActivity.this,
                    "Selected: " + selectedWorkout.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    private List<Workout> getGymWorkouts() {
        WorkoutMockupDA workoutMockupDA = new WorkoutMockupDA();
        List<Workout> allWorkouts = workoutMockupDA.getWorkouts();
        List<Workout> filteredWorkouts = new ArrayList<>();

        int selectedId = muscleGroupRadioGroup.getCheckedRadioButtonId();
        String selectedMuscle = "";

        if (selectedId == R.id.radioChest) {
            selectedMuscle = "Chest";
        } else if (selectedId == R.id.radioBiceps) {
            selectedMuscle = "Biceps";
        } else if (selectedId == R.id.radioTriceps) {
            selectedMuscle = "Triceps";
        } else if (selectedId == R.id.radioBack) {
            selectedMuscle = "Back";
        } else if (selectedId == R.id.radioLegs) {
            selectedMuscle = "Legs";
        } else if (selectedId == R.id.radioShoulders) {
            selectedMuscle = "Shoulders";
        }

        for (Workout workout : allWorkouts) {
            if (workout.getType().equalsIgnoreCase("Gym") && workout.getTargetedMuscles().contains(selectedMuscle)) {
                filteredWorkouts.add(workout);
            }
        }
        return filteredWorkouts;
    }
}
