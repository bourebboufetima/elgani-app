package com.example.elgani;

public class DataModalCahierdecharge {
    // string variables for our name and job
    private String name;
    private String description;

    public DataModalCahierdecharge(String name, String description) {
        this.name = name;

        this.description = description;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
}
