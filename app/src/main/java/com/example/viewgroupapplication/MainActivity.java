package com.example.viewgroupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Setup the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.departmentsRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // 2. Create some dummy categories
        List<String> categories = Arrays.asList(
                "Engineering", "Arts & Science", "Business",
                "Nursing", "Law", "Emergency Contacts"
        );

        // 3. Attach the Adapter
        DepartmentAdapter adapter = new DepartmentAdapter(categories);
        recyclerView.setAdapter(adapter);

        // 4. Clickable Search Bar
        View searchBar = findViewById(R.id.searchBarView);
        searchBar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        });
    }
}