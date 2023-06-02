package com.example.inclassassessment02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewWeightProfile,textViewHeightProfile, bmiVal;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //fetch view
        textViewWeightProfile = findViewById(R.id.textViewWeightProfile);
        textViewHeightProfile = findViewById(R.id.textView13);
        bmiVal = findViewById(R.id.bmiVal);

        // if intent contains profile then setText
        if(getIntent() != null && getIntent().hasExtra(RegistrationActivity.KEY_PROFILE)){
            Profile profile = (Profile) getIntent().getSerializableExtra(RegistrationActivity.KEY_PROFILE);
            textViewWeightProfile.setText(String.valueOf(profile.getWeight()) + " lbs");
            textViewHeightProfile.setText(String.valueOf(profile.getHeight()) + " inches");
            bmiVal.setText(String.valueOf(profile.getBmi()));
        }

    }

}
