package com.example.health;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AssessmentActivity extends AppCompatActivity {
    private EditText assessmentInput;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        assessmentInput = findViewById(R.id.assessmentInput);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(view -> saveAssessment());
    }

    private void saveAssessment() {
        String assessmentData = assessmentInput.getText().toString();
        // Save assessment data (use SQLite or SharedPreferences)
        // For simplicity, let's just show a toast
        Toast.makeText(this, "Assessment saved: " + assessmentData, Toast.LENGTH_SHORT).show();
    }
}