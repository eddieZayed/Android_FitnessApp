package com.bzu.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity {

    private EditText heightInput, weightInput;
    private Button calculateBMIButton;
    private TextView bmiResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        calculateBMIButton = findViewById(R.id.calculateBMIButton);
        bmiResultText = findViewById(R.id.bmiResultText);

        calculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Please enter height and weight", Toast.LENGTH_SHORT).show();
            return;
        }

        double height = Double.parseDouble(heightStr);
        double weight = Double.parseDouble(weightStr);

        //convert height from cm to meters for BMI calculation
        height = height / 100;
        double bmi = weight / (height * height);

        displayBMIResult(bmi);
    }

    private void displayBMIResult(double bmi) {
        String bmiCategory;
        if (bmi < 18.5) {
            bmiCategory = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            bmiCategory = "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            bmiCategory = "Overweight";
        } else {
            bmiCategory = "Obesity";
        }

        //the same in C or python
        //This is a placeholder for a floating-point number
        //the .1 specifies that the number should be formatted to one decimal place.
        String resultText = String.format("Your BMI: %.1f\n%s", bmi, bmiCategory);
        bmiResultText.setText(resultText);
    }
}
