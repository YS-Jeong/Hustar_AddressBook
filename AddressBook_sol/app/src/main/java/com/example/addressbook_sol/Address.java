package com.example.addressbook_sol;

public class Address {
    // Member Variable----------------------------
    private String name;
    private String phone;
    private String email;

    // Constructor Method -----------------------
    public Address(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter / Setter Method---------------------

    // Custom Method----------------------------
    public String getInfo(){
        return "Name: " + this.name + " Telnum: " + this.phone + " Email: " + this.email + "\n";
    }
}
