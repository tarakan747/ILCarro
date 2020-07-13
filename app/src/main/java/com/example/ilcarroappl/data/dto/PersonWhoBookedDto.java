package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class PersonWhoBookedDto {
    @SerializedName("email")
    String email;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("phone")
    String phone;
    @SerializedName("second_name")
    String secondName;

    public PersonWhoBookedDto() {
    }

    public PersonWhoBookedDto(String email, String firstName, String phone, String secondName) {
        this.email = email;
        this.firstName = firstName;
        this.phone = phone;
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "PersonWhoBookedDto{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
