package com.example.elgani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import android.widget.ProgressBar;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        EditText usernameField = findViewById(R.id.usernameField);
//        EditText passwordField = findViewById(R.id.passwordField);
//        Button loginButton = findViewById(R.id.loginButton);
//        TextView register = findViewById(R.id.register);
//        // Hardcoded accounts
//        final String customerUsername = "Rania";
//        final String customerPassword = "123456789";
//
//        final String serviceProvider1Username = "fetima";
//        final String serviceProvider1Password = "987654321";
//        final String serviceProvider1Field = "Automated Media";
//
//        final String serviceProvider2Username = "AbdElkhalak";
//        final String serviceProvider2Password = "147258369";
//        final String serviceProvider2Field = "Architecture";
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String enteredUsername = usernameField.getText().toString().trim();
//                String enteredPassword = passwordField.getText().toString().trim();
//
//                if (enteredUsername.equals(customerUsername) && enteredPassword.equals(customerPassword)) {
//                    // Navigate to customer activity
//                    Intent intent = new Intent(LoginActivity.this, CustomerActivity.class);
//                    intent.putExtra("username", enteredUsername);
//                    startActivity(intent);
//                } else if (enteredUsername.equals(serviceProvider1Username) && enteredPassword.equals(serviceProvider1Password)) {
//                    // Navigate to service provider activity with field Automated Media
//                    Intent intent = new Intent(LoginActivity.this, ServiceProviderActivity.class);
//                    intent.putExtra("username", enteredUsername);
//                    intent.putExtra("field", serviceProvider1Field);
//                    startActivity(intent);
//                } else if (enteredUsername.equals(serviceProvider2Username) && enteredPassword.equals(serviceProvider2Password)) {
//                    // Navigate to service provider activity with field Architecture
//                    Intent intent = new Intent(LoginActivity.this, ServiceProviderActivity.class);
//                    intent.putExtra("username", enteredUsername);
//                    intent.putExtra("field", serviceProvider2Field);
//                    startActivity(intent);
//                } else {
//                    // Invalid credentials
//                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//
//            }
//        });
//    }



        // creating variables for our edittext,
        // button, textview and progressbar.
        private EditText email, password;
        private Button loginButton;
        private TextView responseTV;
        private ProgressBar loadingPB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            // initializing our views
            email = findViewById(R.id.usernameField);
            password = findViewById(R.id.passwordField);
            loginButton = findViewById(R.id.loginButton);
            responseTV = findViewById(R.id.idTVResponse);
            loadingPB = findViewById(R.id.idLoadingPB);

            // adding on click listener to our button.
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // validating if the text field is empty or not.
                    if (email.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // calling a method to post the data and passing our name and job.
                    postData(email.getText().toString(), password.getText().toString());
                }
            });
            TextView registerTextView = findViewById(R.id.register);
            registerTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to the RegistrationActivity
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }

        private void postData(String name, String job) {

            // below line is for displaying our progress bar.
            loadingPB.setVisibility(View.VISIBLE);

            // on below line we are creating a retrofit
            // builder and passing our base url
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.245.183:8080")
                    // as we are sending data in json format so
                    // we have to add Gson converter factory
                    .addConverterFactory(GsonConverterFactory.create())
                    // at last we are building our retrofit builder.
                    .build();
            // below line is to create an instance for our retrofit api class.
            RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

            // passing data from our text fields to our modal class.
            DataModal modal = new DataModal(email.getText().toString(), password.getText().toString());

            // calling a method to create a post and passing our modal class.
            Call<User> call = retrofitAPI.login(modal);

            // on below line we are executing our method.
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    // this method is called when we get response from our api.
                    Toast.makeText(LoginActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();

                    // below line is for hiding our progress bar.
                    loadingPB.setVisibility(View.GONE);

                    // on below line we are setting empty text
                    // to our both edit text.
                    password.setText("");
                    email.setText("");

                    // we are getting response from our body
                    // and passing it to our modal class.
                    User responseFromAPI = response.body();

                    // on below line we are getting our data from modal class and adding it to our string.
                    String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getfullname() + "\n" + "id : " + responseFromAPI.getId() + "Email : " + responseFromAPI.getEmail();

                    // below line we are setting our
                    // string to our text view.
                    responseTV.setText(responseString);

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    // setting text to our text view when
                    // we get error response from API.
                    responseTV.setText("Error found is : " + t.getMessage());

                }


            });
        }
    }

