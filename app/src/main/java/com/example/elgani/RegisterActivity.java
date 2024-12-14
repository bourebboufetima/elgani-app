package com.example.elgani;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText fullNameField, emailField, phoneField;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);  // Link the activity to its layout

        // Initialize the views
        fullNameField = findViewById(R.id.fullNameField);
        emailField = findViewById(R.id.emailField);
        phoneField = findViewById(R.id.phoneField);
        saveButton = findViewById(R.id.saveButton);  // Find the button by its ID

        // Set onClickListener for the save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the information (example: show a toast message)
                String fullName = fullNameField.getText().toString();
                String email = emailField.getText().toString();
                String phone = phoneField.getText().toString();

                // You can add your logic here (e.g., save data to the database or show a success message)
                Intent intent = new Intent(RegisterActivity.this, RoleSelectionActivity.class);
                // Optionally, you can add extra data to pass to RoleSelectionActivity
                // intent.putExtra("username", fullName);

                // Start RoleSelectionActivity
                startActivity(intent);
                finish();
            }
        });
    }
}