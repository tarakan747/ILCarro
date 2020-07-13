package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class StatisticsDto {
    @SerializedName("rating")
    String rating;

    @SerializedName("trips")
    String trips;

    public StatisticsDto() {
    }

    public StatisticsDto(String rating, String trips) {
        this.rating = rating;
        this.trips = trips;
    }

    public String getRating() {
        return rating;
    }

    public String getTrips() {
        return trips;
    }

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "rating='" + rating + '\'' +
                ", trips='" + trips + '\'' +
                '}';
    }
}
