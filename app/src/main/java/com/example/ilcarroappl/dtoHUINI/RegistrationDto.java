package com.example.ilcarroappl.dtoHUINI;

public class RegistrationDto {
    String first_name, second_name;

    public RegistrationDto() {
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "firstName='" + first_name + '\'' +
                ", lastName='" + second_name + '\'' +
                '}';
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return second_name;
    }

    public RegistrationDto(String firstName, String lastName) {
        this.first_name = firstName;
        this.second_name = lastName;
    }
}
