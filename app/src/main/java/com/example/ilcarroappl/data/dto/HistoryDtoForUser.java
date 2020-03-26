package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class HistoryDtoForUser {
    @SerializedName("booked_period")
    HistoryPeriodDto bookedPeriod;
    @SerializedName("serial_number")
    String serial_number;

    public HistoryDtoForUser() {
    }

    public HistoryDtoForUser(HistoryPeriodDto bookedPeriod, String serial_number) {
        this.bookedPeriod = bookedPeriod;
        this.serial_number = serial_number;
    }

    public HistoryPeriodDto getBookedPeriod() {
        return bookedPeriod;
    }

    public String getSerial_number() {
        return serial_number;
    }

    @Override
    public String toString() {
        return "HistoryDtoForUser{" +
                "bookedPeriod=" + bookedPeriod +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }
}
