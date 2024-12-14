package com.example.elgani;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CahierListActivity extends AppCompatActivity implements CahierAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private CahierAdapter cahierAdapter;
    private List<String> cahierList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cahier_list);

        // Get the selected field from the intent
        String selectedField = getIntent().getStringExtra("selectedField");

        // Set the title dynamically
        TextView title = findViewById(R.id.cahierListTitle);
        title.setText("Projects for: " + selectedField);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.cahierRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch cahiers based on selectedField (for demo purposes, mock data is used)
        cahierList = fetchCahiersForField(selectedField);

        // Set up adapter
        cahierAdapter = new CahierAdapter(cahierList);
        recyclerView.setAdapter(cahierAdapter);
    }

    private List<String> fetchCahiersForField(String field) {
        // Mock data for demonstration
        List<String> mockData = new ArrayList<>();
        if (field.equals("Programmer")) {
            mockData.add("Programmer Project 1");
            mockData.add("Programmer Project 2");
        } else if (field.equals("Architecture")) {
            mockData.add("Architecture Project 1");
            mockData.add("Architecture Project 2");
        }
        return mockData;
    }
    @Override
    public void onItemClick(String professionName) {
        if (professionName.equals("Programmer Project 1")) {
            Intent intent = new Intent(this, OfferDetailsActivity.class);
            intent.putExtra("Programmer ", "Project 1");
            startActivity(intent);
        } else if (professionName.equals("Programmer Project 2")) {
            Intent intent = new Intent(this, OfferDetailsActivity.class);
            intent.putExtra("Programmer ", "Project 1");
            startActivity(intent);
        } else if (professionName.equals("Architecture Project 1")) {
            Intent intent = new Intent(this, OfferDetailsActivity.class);
            intent.putExtra("Architecture ", "Project 1");
            startActivity(intent);
        } else if (professionName.equals("Architecture Project 2")) {
            Intent intent = new Intent(this, OfferDetailsActivity.class);
            intent.putExtra("Architecture ", "Project 2");
            startActivity(intent);
        } else{
            Toast.makeText(this, professionName + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
