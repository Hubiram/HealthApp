package com.example.health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private Button loginButton, signupButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        loginButton.setOnClickListener(view -> loginUser());
        signupButton.setOnClickListener(view -> signupUser());
    }

    private void loginUser() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (sharedPreferences.contains(email)) {
            String savedPassword = sharedPreferences.getString(email, "");
            if (savedPassword.equals(password)) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No account found, please sign up", Toast.LENGTH_SHORT).show();
        }
    }

    private void signupUser() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        sharedPreferences.edit().putString(email, password).apply();
        Toast.makeText(this, "Account created! Please log in", Toast.LENGTH_SHORT).show();
    }
}