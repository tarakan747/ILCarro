package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarsFiltersDto {
    @SerializedName("about")
    String about;
    @SerializedName("booked_periods")
    BookedPeriodDateDto bookedPeriods;
    @SerializedName("car_class")
    String carClass;
    @SerializedName("comments")
    List<CommentDtoForFilters> comments;
    @SerializedName("distance_included")
    Double distanceIncluded;
    @SerializedName("doors")
    Integer doors;
    @SerializedName("engine")
    String engine;
    @SerializedName("features")
    List<String> features;
    @SerializedName("fuel")
    String fuel;
    @SerializedName("fuel_consumption")
    Float fuelConsumption;
    @SerializedName("gear")
    String gear;
    @SerializedName("horsepower")
    Integer horsepower;
    @SerializedName("image_url")
    List<String> imageUrl;
    @SerializedName("make")
    String make;
    @SerializedName("model")
    String model;
    @SerializedName("owner")
    OwnerDto owner;
    @SerializedName("pick_up_place")
    PickUpPlaceDto pickUpPlace;
    @SerializedName("price_per_day")
    Double price;
    @SerializedName("reserved_periods")
    List<ReservedPeriodDto> reservedPeriods;
    @SerializedName("seats")
    Integer seats;
    @SerializedName("serial_number")
    String serialNumber;
    @SerializedName("statistics")
    StatisticsDto statistics;
    @SerializedName("torque")
    Integer torque;
    @SerializedName("wheels_drive")
    String wheelsDrive;
    @SerializedName("year")
    String year;
}
