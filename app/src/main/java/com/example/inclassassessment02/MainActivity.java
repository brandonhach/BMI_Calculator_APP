package com.example.inclassassessment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewWeightVal, textViewHeightVal, textViewBMIVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fetch view
        textViewWeightVal = findViewById(R.id.textViewWeightVal);
        textViewHeightVal = findViewById(R.id.textViewHeightVal);
        textViewBMIVal = findViewById(R.id.textViewBMIVal);

        // button that sends user to registration activity
        findViewById(R.id.buttonSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        // button that sends user to profile
        findViewById(R.id.buttonViewProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                if(getIntent() != null && getIntent().hasExtra(RegistrationActivity.KEY_PROFILE)){
                    Profile profile = (Profile) getIntent().getSerializableExtra(RegistrationActivity.KEY_PROFILE);
                    intent.putExtra(RegistrationActivity.KEY_PROFILE, profile);
                }
                startActivity(intent);
            }
        });

        // button reset value
        findViewById(R.id.buttonResetRegis).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textViewWeightVal.setText("N/A");
                textViewHeightVal.setText("N/A");
                textViewBMIVal.setText("");
                Toast.makeText(MainActivity.this, "Resetted!", Toast.LENGTH_SHORT).show();
            }
        });

        // if intent contains profile then setText
        if(getIntent() != null && getIntent().hasExtra(RegistrationActivity.KEY_PROFILE)){
            Profile profile = (Profile) getIntent().getSerializableExtra(RegistrationActivity.KEY_PROFILE);
            textViewWeightVal.setText(String.valueOf(profile.getWeight()) + " lbs");
            textViewHeightVal.setText(String.valueOf(profile.getHeight()) + " inches");
            textViewBMIVal.setText(String.valueOf(profile.getBmi()));
        }
    }
}