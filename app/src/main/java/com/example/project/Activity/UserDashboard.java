package com.example.project.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.database.BankDatabase;
import com.google.android.material.button.MaterialButton;

public class UserDashboard extends AppCompatActivity {
    MaterialButton withdraw,deposit,history;
    BankDatabase bd;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        withdraw = findViewById(R.id.with_drawal);
        deposit = findViewById(R.id.deposit);
        history = findViewById(R.id.history);

        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WithdrawButtonClicked();
            }
        });

    }
    public void WithdrawButtonClicked(){
        // This method is used to set the title of AlertDialog create a alertbuilder.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Amount");
        builder.setTitle("Pin");

        // set the activity layout
         View view= getLayoutInflater().inflate(R.layout.customlayout, null);


        EditText amount ,pin;
            // send data from the AlertDialog to the Activity

            amount = view.findViewById(R.id.withdraw);
            pin = view.findViewById(R.id.pin);
            Button btn = view.findViewById(R.id.withdrawalbtn);

            btn.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {

                    withdraw.setText("amount:" + amount.getText().toString());
                    pin.setText("pin:" + pin.getText().toString());
                    dialog.dismiss();

                }

            });


            //set thia view to dialog
        builder.setView(view);
        //create dialog now
        dialog = builder.create();

        dialog.show();
    }


}