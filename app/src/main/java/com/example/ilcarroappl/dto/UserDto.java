package com.example.ilcarroappl.dto;

import java.util.Arrays;

public class UserDto {
    String firstName;
    String lastName;
    String photo;
    String registrationDate;
    String[] comments;
    String[] own_cars;
    String[] bookedCars;
    String[] history;

    public UserDto(){

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String[] getComments() {
        return comments;
    }

    public String[] getOwn_cars() {
        return own_cars;
    }

    public String[] getBookedCars() {
        return bookedCars;
    }

    public String[] getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo='" + photo + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", comments=" + Arrays.toString(comments) +
                ", own_cars=" + Arrays.toString(own_cars) +
                ", bookedCars=" + Arrays.toString(bookedCars) +
                ", history=" + Arrays.toString(history) +
                '}';
    }

    public UserDto(String firstName, String lastName, String photo, String registrationDate, String[] comments, String[] own_cars, String[] bookedCars, String[] history) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.registrationDate = registrationDate;
        this.comments = comments;
        this.own_cars = own_cars;
        this.bookedCars = bookedCars;
        this.history = history;
    }
}
