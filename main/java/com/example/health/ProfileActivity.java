package com.example.health;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private EditText nameInput, ageInput, heightInput, weightInput;
    private Button saveProfileButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        saveProfileButton = findViewById(R.id.saveProfileButton);

        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
        loadProfile();

        saveProfileButton.setOnClickListener(view -> saveProfile());
    }

    private void loadProfile() {
        String name = sharedPreferences.getString("name", "");
        String age = sharedPreferences.getString("age", "");
        String height = sharedPreferences.getString("height", "");
        String weight = sharedPreferences.getString("weight", "");

        nameInput.setText(name);
        ageInput.setText(age);
        heightInput.setText(height);
        weightInput.setText(weight);
    }

    private void saveProfile() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameInput.getText().toString());
        editor.putString("age", ageInput.getText().toString());
        editor.putString("height", heightInput.getText().toString());
        editor.putString("weight", weightInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show();
    }
}