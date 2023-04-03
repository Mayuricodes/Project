package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.database.BankDatabase;

public class MainActivity extends AppCompatActivity {
    EditText firstname,mobileno,email,pin;
    Button registerbtn;
    public final static String MSG = "msg";
    public final static String CSG = "msg";
    public final static String DSC = "msg";
    public final static String ABC = "msg";
    public final static String PSM = "msg";

    BankDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new BankDatabase(this);
        firstname = findViewById(R.id.first_name);
        mobileno = findViewById(R.id.Mobile_no);
        pin = findViewById(R.id.pin);
        email = findViewById(R.id.email);


        registerbtn = findViewById(R.id.Registration);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                String nametxt = firstname.getText().toString();
                String mobilenotxt = mobileno.getText().toString();
                String emailtxt = email.getText().toString();
                String pintxt = pin.getText().toString();



                db.insertData(nametxt, emailtxt, mobilenotxt, pintxt);


                Toast.makeText(MainActivity.this, "Dear " +nametxt+" Thank-you for registration !!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    private void checkDataEntered() {
        //to check validity of first name
        if (isEmpty(firstname)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }
        //to check validity of lastname
        if (isEmpty(mobileno)) {
            mobileno.setError("Last name is required!");
        }
        //to check validity of email
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }

        if (isEmpty(pin)) {
           pin.setError("Last name is required!");
        }
    }
}