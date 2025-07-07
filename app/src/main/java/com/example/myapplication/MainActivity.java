package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText email_login= (EditText) findViewById(R.id.emailLogin);
        EditText password_login= (EditText) findViewById(R.id.passwordLogin);
        Button btn_login = (Button) findViewById(R.id.btnLogin);
        TextView gotor =(TextView) findViewById(R.id.goToRegister);
        TextView gotoforgot =(TextView) findViewById(R.id.gotoforgot);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = email_login.getText().toString().trim();
                String password = password_login.getText().toString();

                if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email_login.setError("Please enter a valid email");
                    email_login.requestFocus();
                    return;
                }
                if (password.isEmpty() || password.length() < 6) {
                    password_login.setError("Password must be at least 6 characters");
                    password_login.requestFocus();
                    return;
                }
                Intent intent = new Intent(MainActivity.this , HomePage.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext() ,"Going HomePage", Toast.LENGTH_SHORT).show();

            }
        });

        gotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this ,RegisterPage.class );
                startActivity(intent);
                Toast.makeText(getApplicationContext() ,"Going RegisterPage", Toast.LENGTH_SHORT).show();

            }
        });


        gotoforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this ,ForgotPassword.class );
                startActivity(intent);
                Toast.makeText(getApplicationContext() ,"Going Forgot Password Page", Toast.LENGTH_SHORT).show();

            }
        });

        }
    }
