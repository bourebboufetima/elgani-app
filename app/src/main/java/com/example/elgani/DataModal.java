package com.example.elgani;

public class DataModal {
    // Fields for user signup details
//    private String username;
//    private String phone;
    private String email;
    private String password;

    // Constructor
    public DataModal(String email,  String password) {
//        this.username = username;
//        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
