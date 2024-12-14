package com.example.elgani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientOffersActivity extends AppCompatActivity {

    private TextView priceTextView, timeTextView;
    private Button confirmOfferButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_offers);

        // Initialize UI elements
        priceTextView = findViewById(R.id.priceTextView);
        timeTextView = findViewById(R.id.timeTextView);
        confirmOfferButton = findViewById(R.id.confirmOfferButton);

        SharedPreferences sharedPreferences = getSharedPreferences("OffersData", MODE_PRIVATE);

        String price = sharedPreferences.getString("price", "N/A"); // Default value is "N/A"
        String time = sharedPreferences.getString("time", "N/A");   // Default value is "N/A"

// Display the retrieved values
        priceTextView.setText("Price: " + price);
        timeTextView.setText("Time: " + time + " days");


        // Handle confirm button click
        confirmOfferButton.setOnClickListener(v -> {
            // Notify the user
            Intent intent = new Intent(this, ChatActivity.class);

            startActivity(intent);

            // Close activity (optional)
            finish();
        });


    }
}
