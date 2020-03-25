package com.example.ilcarroappl.dtoHUINI;

public class StatisticsDto {
    String rating;
    String trips;

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "rating='" + rating + '\'' +
                ", trips='" + trips + '\'' +
                '}';
    }

    public String getRating() {
        return rating;
    }

    public String getTrips() {
        return trips;
    }

    public StatisticsDto(String rating, String trips) {
        this.rating = rating;
        this.trips = trips;
    }
}
