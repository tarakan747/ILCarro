package com.example.ilcarroappl.dto;

public class OwnerDto {
    String first_name;
    String registration_date;
    String second_name;

    @Override
    public String toString() {
        return "OwnerDto{" +
                "first_name='" + first_name + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }

    public OwnerDto() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public String getSecond_name() {
        return second_name;
    }

    public OwnerDto(String first_name, String registration_date, String second_name) {
        this.first_name = first_name;
        this.registration_date = registration_date;
        this.second_name = second_name;
    }
}
