package com.example.health;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private Button assessmentButton, profileButton, bmiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        assessmentButton = findViewById(R.id.assessmentButton);
        profileButton = findViewById(R.id.profileButton);
        bmiButton = findViewById(R.id.bmiButton);

        assessmentButton.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, AssessmentActivity.class)));
        profileButton.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, ProfileActivity.class)));
        bmiButton.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, BMICalculatorActivity.class)));
    }
}