package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class OwnerDto {
    @SerializedName("first_name")
    String firstName;
    @SerializedName("registration_date")
    String registrationDate;
    @SerializedName("second_name")
    String secondName;

    public OwnerDto() {
    }

    public OwnerDto(String firstName, String registrationDate, String secondName) {
        this.firstName = firstName;
        this.registrationDate = registrationDate;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "firstName='" + firstName + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
