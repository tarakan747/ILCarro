package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDtoForUser {
    @SerializedName("booked_cars")
    List<BookedCarsDtoForUser> bookedCars;
    @SerializedName("comments")
    List<CommentDto> comment;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("history")
    List<HistoryDtoForUser> history;
    @SerializedName("own_cars")
    List<OwnerCarDtoForUser> ownCars;
    @SerializedName("photo")
    String photo;
    @SerializedName("registration_date")
    String registrationDate;
    @SerializedName("second_name")
    String secondName;

    public UserDtoForUser() {
    }

    public UserDtoForUser(List<BookedCarsDtoForUser> bookedCars, List<CommentDto> comment, String firstName, List<HistoryDtoForUser> history, List<OwnerCarDtoForUser> ownCars, String photo, String registrationDate, String secondName) {
        this.bookedCars = bookedCars;
        this.comment = comment;
        this.firstName = firstName;
        this.history = history;
        this.ownCars = ownCars;
        this.photo = photo;
        this.registrationDate = registrationDate;
        this.secondName = secondName;
    }

    public List<BookedCarsDtoForUser> getBookedCars() {
        return bookedCars;
    }

    public List<CommentDto> getComment() {
        return comment;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<HistoryDtoForUser> getHistory() {
        return history;
    }

    public List<OwnerCarDtoForUser> getOwnCars() {
        return ownCars;
    }

    public String getPhoto() {
        return photo;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "UserDtoForUser{" +
                "bookedCars=" + bookedCars +
                ", comment=" + comment +
                ", firstName='" + firstName + '\'' +
                ", history=" + history +
                ", ownCars=" + ownCars +
                ", photo='" + photo + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
