package com.example.elgani;




import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

// Define the interface for API endpoints
public interface RetrofitAPI {

    // User signup endpoint
//    @POST("/signup")
//    Call<ResponseBody> signup(@Body DataModalsignup user);

    // User login endpoint
    @POST("/login")
    Call<User> login(@Body  DataModal  modal);

    @POST("/generate")
    Call<Content> generate(@Body  DataModalCahierdecharge  modal);

    // Fetch all users endpoint
//    @GET("/users")
//    Call<List<User>> getUsers();
}

