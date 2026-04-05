package com.example.viewgroupapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button callButton = findViewById(R.id.btnCall);
        Button emailButton = findViewById(R.id.btnEmail);

        // Dummy data for testing
        String phoneNumber = "555-123-4567";
        String emailAddress = "professor@college.edu";

        callButton.setOnClickListener(v -> {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(dialIntent);
        });

        emailButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + emailAddress));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry from Campus App");
            startActivity(emailIntent);
        });
    }
}