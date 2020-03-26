package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class RegistrationDto {
    @SerializedName("first_name")
    String firstName;
    @SerializedName("second_name")
    String secondName;

    public RegistrationDto() {
    }

    public RegistrationDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.secondName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + secondName + '\'' +
                '}';
    }


}
