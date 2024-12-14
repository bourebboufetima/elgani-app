package com.example.elgani;

public class Content {
    // Fields for user signup details
    private String describtion;
    private String name;


    // Constructor
    public Content(String describtion , String name) {
        this.describtion = describtion;
        this.name = name;

    }

    // Getters and Setters
    public String getdescribtion() {
        return describtion;
    }

    public void setdescribtion(String describtion) {

        this.describtion = describtion;
    }
    public String getname() {
        return name;
    }

    public void setname(String name) {

        this.name = name;
    }

}
