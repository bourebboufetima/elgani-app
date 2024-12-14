package com.example.elgani;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RoleSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection);

        findViewById(R.id.customerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Customer Activity
                Intent intent = new Intent(RoleSelectionActivity.this, CustomerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.serviceProviderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Service Provider Activity
                //Intent intent = new Intent(RoleSelectionActivity.this, ServiceProviderActivity.class);
                Intent intent = new Intent(RoleSelectionActivity.this, Provider.class);
                startActivity(intent);
            }
        });
    }
}
