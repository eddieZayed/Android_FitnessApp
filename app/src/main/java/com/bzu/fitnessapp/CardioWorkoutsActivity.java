package com.bzu.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CardioWorkoutsActivity extends AppCompatActivity {

    private ListView cardioListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_workouts);

        cardioListView = findViewById(R.id.cardioListView);
        List<Workout> cardioWorkouts = getCardioWorkouts();

        // Create a custom ArrayAdapter
        ArrayAdapter<Workout> adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, cardioWorkouts) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(getResources().getColor(android.R.color.black)); //set text color to black
                textView.setText((position + 1) + ". " + cardioWorkouts.get(position).getName() + " (" +
                        cardioWorkouts.get(position).getDuration() + " mins, " +
                        cardioWorkouts.get(position).getCaloriesBurned() + " cal)");
                return view;
            }
        };
        cardioListView.setAdapter(adapter);

        cardioListView.setOnItemClickListener((parent, view, position, id) -> {
            Workout selectedWorkout = cardioWorkouts.get(position);
            Toast.makeText(CardioWorkoutsActivity.this,
                    "Selected: " + selectedWorkout.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    private List<Workout> getCardioWorkouts() {
        WorkoutMockupDA workoutMockupDA = new WorkoutMockupDA();
        List<Workout> allWorkouts = workoutMockupDA.getWorkouts();
        List<Workout> filteredWorkouts = new ArrayList<>();

        for (Workout workout : allWorkouts) {
            if (workout.getType().equalsIgnoreCase("Cardio")) {
                filteredWorkouts.add(workout);
            }
        }
        return filteredWorkouts;
    }
}
