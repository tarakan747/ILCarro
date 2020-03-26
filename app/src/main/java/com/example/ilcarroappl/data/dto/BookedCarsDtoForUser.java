package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class BookedCarsDtoForUser {
    @SerializedName("booked_period")
    BookedPeriodDto bookedPeriod;
    @SerializedName("serial_number")
    String serial_number;


    public BookedCarsDtoForUser() {
    }

    public BookedCarsDtoForUser(BookedPeriodDto bookedPeriod, String serial_number) {
        this.bookedPeriod = bookedPeriod;
        this.serial_number = serial_number;
    }

    public BookedPeriodDto getBookedPeriod() {
        return bookedPeriod;
    }

    public String getSerial_number() {
        return serial_number;
    }

    @Override
    public String toString() {
        return "BookedCarsDtoForUser{" +
                "bookedPeriod=" + bookedPeriod +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }
}
