package com.example.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
public class signup extends AppCompatActivity {
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText number = findViewById(R.id.number);
        EditText password = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.cnfrmpassword);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        Button signupButton = findViewById(R.id.signup);
        signupButton.setOnClickListener(view -> {
            String userNameInput = username.getText().toString().trim();
            String emailInput = email.getText().toString().trim();
            String numberInput = number.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();
            String confirmPasswordInput = confirmPassword.getText().toString().trim();
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedGenderId);
            String genderInput = selectedGender != null ? selectedGender.getText().toString() : "Not selected";
            if (userNameInput.isEmpty() || emailInput.isEmpty() || numberInput.isEmpty()
                    || passwordInput.isEmpty() || confirmPasswordInput.isEmpty() || selectedGender == null) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!passwordInput.equals(confirmPasswordInput)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!usernames.contains(userNameInput)) {
                usernames.add(userNameInput);
                passwords.add(passwordInput);
                Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show();
                username.setText("");
                email.setText("");
                number.setText("");
                password.setText("");
                confirmPassword.setText("");
                genderGroup.clearCheck();
                Intent intent = new Intent(signup.this, login.class);
                intent.putStringArrayListExtra("usernames", usernames);
                intent.putStringArrayListExtra("passwords", passwords);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Username already exists!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

