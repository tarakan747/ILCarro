package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class ReservedPeriodDto {
    @SerializedName("end_date_time")
    String endDateTime;

    @SerializedName("start_date_time")
    String startDateTime;

    public ReservedPeriodDto() {
    }

    public ReservedPeriodDto(String endDateTime, String startDateTime) {
        this.endDateTime = endDateTime;
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    @Override
    public String toString() {
        return "ReservedPeriodDto{" +
                "endDateTime='" + endDateTime + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                '}';
    }
}
