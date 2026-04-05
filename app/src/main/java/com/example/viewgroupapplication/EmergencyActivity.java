package com.example.viewgroupapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmergencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        RecyclerView recyclerView = findViewById(R.id.emergencyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create dummy data
        List<EmergencyContact> emergencyList = new ArrayList<>();
        emergencyList.add(new EmergencyContact("Campus Police (Urgent)", "911"));
        emergencyList.add(new EmergencyContact("Campus Security (Non-Emergency)", "555-123-4567"));
        emergencyList.add(new EmergencyContact("Medical Center / Ambulance", "555-987-6543"));
        emergencyList.add(new EmergencyContact("Mental Health Crisis Hotline", "555-111-2222"));

        // Initialize and set the adapter
        EmergencyAdapter adapter = new EmergencyAdapter(emergencyList);
        recyclerView.setAdapter(adapter);
    }
}