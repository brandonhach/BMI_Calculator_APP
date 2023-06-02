package com.example.inclassassessment02;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class RegistrationActivity extends AppCompatActivity {
    public static final String KEY_PROFILE = "PROFILE";
    EditText editTextWeight, editTextHeight;
    TextView bmiVal, textViewBMIVal;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // fetch view
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);

        // bring user back to the main activity
        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });


       //  button press then submit info
        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weight = editTextWeight.getText().toString();
                String height = editTextHeight.getText().toString();

                if(weight.isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Enter Weight!", Toast.LENGTH_SHORT).show();
                } else if(height.isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Enter Height!", Toast.LENGTH_SHORT).show();
                } else {
                    calculateBMI();
                }
            }
        });

    }

    public void calculateBMI() {
        double weight = Double.parseDouble(editTextWeight.getText().toString());
        double height = Double.parseDouble(editTextHeight.getText().toString());
        double bmi = Math.round((weight / Math.pow(height, 2) * 703) * 100.00) / 100.00;
        Profile profile = new Profile(height, weight, bmi);
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        intent.putExtra(KEY_PROFILE, profile);
        startActivity(intent);
    }


}
