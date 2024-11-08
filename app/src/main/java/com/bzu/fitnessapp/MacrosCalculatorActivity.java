package com.bzu.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MacrosCalculatorActivity extends AppCompatActivity {

    private EditText dailyCaloriesInput;
    private Button calculateMacrosButton;
    private TextView macrosResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macros_calculator);

        dailyCaloriesInput = findViewById(R.id.dailyCaloriesInput);
        calculateMacrosButton = findViewById(R.id.calculateMacrosButton);
        macrosResultText = findViewById(R.id.macrosResultText);

        calculateMacrosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMacros();
            }
        });
    }

    private void calculateMacros() {
        String dailyCaloriesStr = dailyCaloriesInput.getText().toString();

        if (dailyCaloriesStr.isEmpty()) {
            Toast.makeText(this, "Please enter your daily calories", Toast.LENGTH_SHORT).show();
            return;
        }

        double dailyCalories = Double.parseDouble(dailyCaloriesStr);

        //define macro ratios
        double proteinRatio = 0.20; //20% of total calories from protein
        double fatRatio = 0.25;     //25% of total calories from fat
        double carbsRatio = 0.55;   //55% of total calories from carbs

        //calculate calories from each macronutrient
        double proteinCalories = dailyCalories * proteinRatio;
        double fatCalories = dailyCalories * fatRatio;
        double carbsCalories = dailyCalories * carbsRatio;

        //convert calories to grams (1g of protein=4 calories, 1g of fat=9 calories, 1g of carbs=4 calories)
        double proteinGrams = proteinCalories / 4;
        double fatGrams = fatCalories / 9;
        double carbsGrams = carbsCalories / 4;

        //similar to C programing language->
        String resultText = String.format("Protein: %.1f g\nFat: %.1f g\nCarbs: %.1f g",
                proteinGrams, fatGrams, carbsGrams);
        macrosResultText.setText(resultText);
    }
}
