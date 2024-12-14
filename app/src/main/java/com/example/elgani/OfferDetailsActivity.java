package com.example.elgani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OfferDetailsActivity extends AppCompatActivity {

    private EditText priceInput, timeInput;
    private Button submitOfferButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        // Initialize UI elements
        priceInput = findViewById(R.id.priceInput);
        timeInput = findViewById(R.id.timeInput);
        submitOfferButton = findViewById(R.id.submitOfferButton);

        // Handle submit button click
        submitOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = priceInput.getText().toString().trim();
                String time = timeInput.getText().toString().trim();

                if (price.isEmpty() || time.isEmpty()) {
                    Toast.makeText(OfferDetailsActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("OffersData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("price", price); // Save the price
                    editor.putString("time", time);   // Save the time
                    editor.apply(); // Commit the changes

                }
            }
        });

    }
}
