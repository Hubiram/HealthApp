package com.example.health;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity {
    private EditText heightInput, weightInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(view -> calculateBMI());
    }

    private void calculateBMI() {
        try {
            float height = Float.parseFloat(heightInput.getText().toString()) / 100;  // cm to meters
            float weight = Float.parseFloat(weightInput.getText().toString());

            float bmi = weight / (height * height);
            resultText.setText("Your BMI: " + String.format("%.2f", bmi));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid height and weight", Toast.LENGTH_SHORT).show();
        }
    }
}