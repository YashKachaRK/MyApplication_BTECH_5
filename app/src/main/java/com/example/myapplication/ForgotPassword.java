package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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

import org.w3c.dom.Text;

public class ForgotPassword extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        EditText emailid = (EditText) findViewById(R.id.enteremailid);
        EditText newpassword = (EditText) findViewById(R.id.newpassword);
        EditText repassword = (EditText) findViewById(R.id.reenterpassword);
        Button gotologin = (Button)findViewById(R.id.forgot_login_btn);
        TextView gotologinpage_textview = (TextView)  findViewById(R.id.gotologin_forgot);


        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPassword.this , MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext() ,"Success", Toast.LENGTH_SHORT).show();
            }
        });

        gotologinpage_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPassword.this , MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext() ,"Success", Toast.LENGTH_SHORT).show();


            }
        });




    }
}