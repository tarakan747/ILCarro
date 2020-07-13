package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OwnerCarDtoForUser {
    @SerializedName("about")
    String about;
    @SerializedName("booked_periods")
    List<BookedPeriodDto> bookedPeriods;
    @SerializedName("car_class")
    String carClass;
    @SerializedName("distance_included")
    Double distance_included;
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
    @SerializedName("pick_up_place")
    PickUpPlaceDto pickUpPlace;
    @SerializedName("price_per_day")
    Double pricePerDay;
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

    public OwnerCarDtoForUser() {
    }

    public OwnerCarDtoForUser(String about, List<BookedPeriodDto> bookedPeriods, String carClass, Double distance_included, Integer doors, String engine, List<String> features, String fuel, Float fuelConsumption, String gear, Integer horsepower, List<String> imageUrl, String make, String model, PickUpPlaceDto pickUpPlace, Double pricePerDay, Integer seats, String serialNumber, StatisticsDto statistics, Integer torque, String wheelsDrive, String year) {
        this.about = about;
        this.bookedPeriods = bookedPeriods;
        this.carClass = carClass;
        this.distance_included = distance_included;
        this.doors = doors;
        this.engine = engine;
        this.features = features;
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.gear = gear;
        this.horsepower = horsepower;
        this.imageUrl = imageUrl;
        this.make = make;
        this.model = model;
        this.pickUpPlace = pickUpPlace;
        this.pricePerDay = pricePerDay;
        this.seats = seats;
        this.serialNumber = serialNumber;
        this.statistics = statistics;
        this.torque = torque;
        this.wheelsDrive = wheelsDrive;
        this.year = year;
    }

    public String getAbout() {
        return about;
    }

    public List<BookedPeriodDto> getBookedPeriods() {
        return bookedPeriods;
    }

    public String getCarClass() {
        return carClass;
    }

    public Double getDistance_included() {
        return distance_included;
    }

    public Integer getDoors() {
        return doors;
    }

    public String getEngine() {
        return engine;
    }

    public List<String> getFeatures() {
        return features;
    }

    public String getFuel() {
        return fuel;
    }

    public Float getFuelConsumption() {
        return fuelConsumption;
    }

    public String getGear() {
        return gear;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public PickUpPlaceDto getPickUpPlace() {
        return pickUpPlace;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public Integer getSeats() {
        return seats;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public StatisticsDto getStatistics() {
        return statistics;
    }

    public Integer getTorque() {
        return torque;
    }

    public String getWheelsDrive() {
        return wheelsDrive;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "OwnerCarDtoForUser{" +
                "about='" + about + '\'' +
                ", bookedPeriods=" + bookedPeriods +
                ", carClass='" + carClass + '\'' +
                ", distance_included=" + distance_included +
                ", doors=" + doors +
                ", engine='" + engine + '\'' +
                ", features=" + features +
                ", fuel='" + fuel + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", gear='" + gear + '\'' +
                ", horsepower=" + horsepower +
                ", imageUrl=" + imageUrl +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", pickUpPlace=" + pickUpPlace +
                ", pricePerDay=" + pricePerDay +
                ", seats=" + seats +
                ", serialNumber='" + serialNumber + '\'' +
                ", statistics=" + statistics +
                ", torque=" + torque +
                ", wheelsDrive='" + wheelsDrive + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
