package com.bzu.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class CaloriesCalculatorActivity extends AppCompatActivity {

    private EditText ageInput, weightInput, heightInput;
    private RadioGroup genderRadioGroup;
    private Spinner activityLevelSpinner;
    private Button calculateCaloriesButton;
    private TextView caloriesResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_calculator);

        ageInput = findViewById(R.id.ageInput);
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        activityLevelSpinner = findViewById(R.id.activityLevelSpinner);
        calculateCaloriesButton = findViewById(R.id.calculateCaloriesButton);
        caloriesResultText = findViewById(R.id.caloriesResultText);

        String[] activityLevels = {"Sedentary", "Lightly Active", "Moderately Active", "Very Active", "Super Active"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, activityLevels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityLevelSpinner.setAdapter(adapter);

        calculateCaloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });
    }

    private void calculateCalories() {
        String ageStr = ageInput.getText().toString();
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);
        double bmr; // Basal Metabolic Rate: which is
        // number of calories your body needs to maintain basic physiological functions

        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedGenderId == R.id.radioMale) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        String activityLevel = activityLevelSpinner.getSelectedItem().toString();
        double activityMultiplier;
        switch (activityLevel) {
            case "Sedentary":
                activityMultiplier = 1.2;
                break;
            case "Lightly Active":
                activityMultiplier = 1.375;
                break;
            case "Moderately Active":
                activityMultiplier = 1.55;
                break;
            case "Very Active":
                activityMultiplier = 1.725;
                break;
            case "Super Active":
                activityMultiplier = 1.9;
                break;
            default:
                activityMultiplier = 1.0;
        }

        double dailyCalories = bmr * activityMultiplier;
        String resultText = String.format("Your daily calorie needs: %.0f kcal", dailyCalories);
        caloriesResultText.setText(resultText);
    }
}
