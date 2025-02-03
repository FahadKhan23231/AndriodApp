package com.example.wechat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;
    private EditText usernameField, passwordField;
    private Button loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        loginButton = findViewById(R.id.logbut);
        Intent intent = getIntent();
        usernames = intent.getStringArrayListExtra("usernames");
        passwords = intent.getStringArrayListExtra("passwords");

        if (usernames == null) {
            usernames = new ArrayList<>();
        }
        if (passwords == null) {
            passwords = new ArrayList<>();
        }


        loginButton.setOnClickListener(view -> {
            String enteredUsername = usernameField.getText().toString().trim();
            String enteredPassword = passwordField.getText().toString().trim();

            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            } else {
                validateLogin(enteredUsername, enteredPassword);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chats=new Intent(login.this,chatsrceen.class);
                startActivity(chats);
            }
        });
    }
    private void validateLogin(String enteredUsername, String enteredPassword) {
        // Check if the username exists and password matches
        int index = usernames.indexOf(enteredUsername);
        if (index != -1 && passwords.get(index).equals(enteredPassword)) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(login.this, chatsrceen.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
        }
    }
}
