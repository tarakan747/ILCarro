package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class BookedPeriodDateDto {
    @SerializedName("end_date_time")
    String endDateTime;

    @SerializedName("start_date_time")
    String startDateTime;

    public BookedPeriodDateDto() {
    }

    public BookedPeriodDateDto(String endDateTime, String startDateTime) {
        this.endDateTime = endDateTime;
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {return endDateTime;}

    public String getStartDateTime() {return startDateTime;}

    @Override
    public String toString() {
        return "BookedPeriodDateDto{" +
                "endDateTime='" + endDateTime + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                '}';
    }
}
