package com.example.ilcarroappl.dto;

public class BookedPeriodsDto {
    String end_date_time;
    String start_date_time;

    @Override
    public String toString() {
        return "BookedPeriodsDto{" +
                "end_date_time='" + end_date_time + '\'' +
                ", start_date_time='" + start_date_time + '\'' +
                '}';
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public String getStart_date_time() {
        return start_date_time;
    }

    public BookedPeriodsDto() {
    }

    public BookedPeriodsDto(String end_date_time, String start_date_time) {
        this.end_date_time = end_date_time;
        this.start_date_time = start_date_time;
    }
}
