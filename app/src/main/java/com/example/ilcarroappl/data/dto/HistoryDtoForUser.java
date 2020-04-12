package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class HistoryDtoForUser {
    @SerializedName("booked_period")
    HistoryPeriodDto bookedPeriod;
    @SerializedName("serial_number")
    String serialNumber;

    public HistoryDtoForUser() {
    }

    public HistoryDtoForUser(HistoryPeriodDto bookedPeriod, String serialNumber) {
        this.bookedPeriod = bookedPeriod;
        this.serialNumber = serialNumber;
    }

    public HistoryPeriodDto getBookedPeriod() {
        return bookedPeriod;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "HistoryDtoForUser{" +
                "bookedPeriod=" + bookedPeriod +
                ", serial_number='" + serialNumber + '\'' +
                '}';
    }
}
