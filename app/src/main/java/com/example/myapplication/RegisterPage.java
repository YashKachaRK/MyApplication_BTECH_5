package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);

        EditText nameR= (EditText) findViewById(R.id.nameRegister);
        EditText emailR= (EditText) findViewById(R.id.emailRegister);
        RadioGroup genG= (RadioGroup) findViewById(R.id.genderGroup);
        EditText phoner= (EditText) findViewById(R.id.phoneRegister);
        EditText passwordr= (EditText) findViewById(R.id.passwordRegister);
        EditText confpasswordr= (EditText) findViewById(R.id.confPasswordRegister);
        Button btn = (Button) findViewById(R.id.btnRegister);
        TextView gotoloigin = (TextView) findViewById(R.id.gotologin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameR.getText().toString().trim();
                String email = emailR.getText().toString().trim();
                String phone = phoner.getText().toString().trim();
                String password = passwordr.getText().toString();
                String confirmPassword = confpasswordr.getText().toString();

                int selectedGenderId = genG.getCheckedRadioButtonId();

                if (name.isEmpty()) {
                    nameR.setError("Please enter your full name");
                    nameR.requestFocus();
                    return;
                }

                if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailR.setError("Please enter a valid email");
                    emailR.requestFocus();
                    return;
                }

                if (selectedGenderId == -1) {
                    Toast.makeText(RegisterPage.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (phone.isEmpty() || phone.length() != 10) {
                    phoner.setError("Enter a valid 10-digit phone number");
                    phoner.requestFocus();
                    return;
                }

                if (password.isEmpty() || password.length() < 6) {
                    passwordr.setError("Password must be at least 6 characters");
                    passwordr.requestFocus();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    confpasswordr.setError("Passwords do not match");
                    confpasswordr.requestFocus();
                    return;
                }

                Toast.makeText(RegisterPage.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                
                Intent intent = new Intent(RegisterPage.this , MainActivity.class);
                startActivity(intent);
            }
        });

        gotoloigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}