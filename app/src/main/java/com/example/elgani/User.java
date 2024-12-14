package com.example.elgani;

public class User {
    // Fields for user signup details
    private String fullname;
    private String phone;
    private String email;
    private String id;

    // Constructor
    public User(String fullname,  String password) {
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    // Getters and Setters
    public String getfullname() {
        return fullname;
    }

    public void setfullname(String fullname,String phone, String email ,String id) {

        this.fullname = fullname;
    }




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String password) {
        this.id = password;
    }

}
