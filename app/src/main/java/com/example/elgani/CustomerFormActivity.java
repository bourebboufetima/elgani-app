package com.example.elgani;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



    public class CustomerFormActivity extends AppCompatActivity {

        private EditText nameField, descriptionField;
        private TextView receivedText;
        private Button sendButton, submitButton;
        private ProgressBar loadingPB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_customer_form);

            // Initialize Views
            nameField = findViewById(R.id.nameField);
            descriptionField = findViewById(R.id.descriptionField);
            receivedText = findViewById(R.id.receivedText);
            sendButton = findViewById(R.id.sendButton);
            submitButton = findViewById(R.id.submitButton);
            loadingPB = findViewById(R.id.idLoadingPB);

            // Send to Gemini API Button Click

            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // validating if the text field is empty or not.
                    if (nameField.getText().toString().isEmpty() && descriptionField.getText().toString().isEmpty()) {
                        Toast.makeText(CustomerFormActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // calling a method to post the data and passing our name and job.
                    postData(nameField.getText().toString(), descriptionField.getText().toString());
                }

            });
            // Submit Button Click
            submitButton.setOnClickListener(v -> {
                Intent intent = new Intent(CustomerFormActivity.this, ClientOffersActivity.class);

                // Pass data to ActivityClientOffers
                String cahierDeCharge = receivedText.getText().toString();
                intent.putExtra("cahier_de_charge", cahierDeCharge);

                startActivity(intent);
            });




        }

        private void postData(String name, String description) {

            // below line is for displaying our progress bar.
            loadingPB.setVisibility(View.VISIBLE);

            // on below line we are creating a retrofit
            // builder and passing our base url
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://192.168.245.183:8080")
                    // as we are sending data in json format so
                    // we have to add Gson converter factory
                    .addConverterFactory(GsonConverterFactory.create())
                    // at last we are building our retrofit builder.
                    .build();
            // below line is to create an instance for our retrofit api class.
            RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

            // passing data from our text fields to our modal class.
            DataModalCahierdecharge modal = new DataModalCahierdecharge(name, description);

            // calling a method to create a post and passing our modal class.
            Call<Content> call = retrofitAPI.generate(modal);

            // on below line we are executing our method.
            call.enqueue(new Callback<Content>() {
                @Override
                public void onResponse(Call<Content> call, Response<Content> response) {
                    // this method is called when we get response from our api.
                    Toast.makeText(CustomerFormActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();

                    // below line is for hiding our progress bar.
                    loadingPB.setVisibility(View.GONE);

                    // on below line we are setting empty text
                    // to our both edit text.
                    descriptionField.setText("");
                    nameField.setText("");

                    // we are getting response from our body
                    // and passing it to our modal class.
                    Content responseFromAPI = response.body();

                    // on below line we are getting our data from modal class and adding it to our string.
                    String responseString = "Response Code : " + response.code() + "\nFile Name  : " + responseFromAPI.getname() + "\n" + "DescriptionField : " + responseFromAPI.getdescribtion();

                    // below line we are setting our
                    // string to our text view.
                    receivedText.setText(responseString);
                    // Enable the Submit Button

                    submitButton.setEnabled(true);

                }

                @Override
                public void onFailure(Call<Content> call, Throwable t) {
                    // setting text to our text view when
                    // we get error response from API.
                    receivedText.setText("Error found is : " + t.getMessage());


                }



            });
        }
    }




