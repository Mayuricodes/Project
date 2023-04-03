package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.database.BankDatabase;

public class LoginPage extends AppCompatActivity {
    EditText id,pswd;
    Button btn, reg;

    BankDatabase database = new BankDatabase(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

      //  getActionBar().setTitle("Login");

        id = findViewById(R.id.lgnid);
        pswd = findViewById(R.id.lgnpswd);

        btn = findViewById(R.id.sbbtn);
        reg = findViewById(R.id.reg_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getMobile = id.getText().toString();
                String getpin = pswd.getText().toString();
                if (getMobile.isEmpty() && getpin.isEmpty()){
                    Toast.makeText(LoginPage.this, "Empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean check = database.login(getMobile, getpin);

                    if (check){
                        startActivity(new Intent(LoginPage.this, UserDashboard.class));
                    }else{
                        Toast.makeText(LoginPage.this, "Wrong Credential !!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this , MainActivity.class));
            }
        });
    }
}