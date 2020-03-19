package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarForUsersDto {

    @SerializedName("about")
    String about;

    @SerializedName("booked_periods")
    List<BookedPeriodDateDto> bookedPeriods;

    @SerializedName("car_class")
    String carClass;

    @SerializedName("comments")
    List<CommentDto> comments;

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
    OwnerDtoForCar owner;

    @SerializedName("pick_up_place")
    PickUpPlaceDto pickUpPlace;

    @SerializedName("price_per_day")
    Double pricePerDay;

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

    public CarForUsersDto() {
    }

    public CarForUsersDto(String about, List<BookedPeriodDateDto> bookedPeriods, String carClass, List<CommentDto> comments, Double distanceIncluded, Integer doors, String engine, List<String> features, String fuel, Float fuelConsumption, String gear, Integer horsepower, List<String> imageUrl, String make, String model, OwnerDtoForCar owner, PickUpPlaceDto pickUpPlace, Double pricePerDay, List<ReservedPeriodDto> reservedPeriods, Integer seats, String serialNumber, StatisticsDto statistics, Integer torque, String wheelsDrive, String year) {
        this.about = about;
        this.bookedPeriods = bookedPeriods;
        this.carClass = carClass;
        this.comments = comments;
        this.distanceIncluded = distanceIncluded;
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
        this.owner = owner;
        this.pickUpPlace = pickUpPlace;
        this.pricePerDay = pricePerDay;
        this.reservedPeriods = reservedPeriods;
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

    public List<BookedPeriodDateDto> getBookedPeriods() {
        return bookedPeriods;
    }

    public String getCarClass() {
        return carClass;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public Double getDistanceIncluded() {
        return distanceIncluded;
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

    public OwnerDtoForCar getOwner() {
        return owner;
    }

    public PickUpPlaceDto getPickUpPlace() {
        return pickUpPlace;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public List<ReservedPeriodDto> getReservedPeriods() {
        return reservedPeriods;
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
        return "CarForUsersDto{" +
                "about='" + about + '\'' +
                ", bookedPeriods=" + bookedPeriods +
                ", carClass='" + carClass + '\'' +
                ", comments=" + comments +
                ", distanceIncluded=" + distanceIncluded +
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
                ", owner=" + owner +
                ", pickUpPlace=" + pickUpPlace +
                ", pricePerDay=" + pricePerDay +
                ", reservedPeriods=" + reservedPeriods +
                ", seats=" + seats +
                ", serialNumber='" + serialNumber + '\'' +
                ", statistics=" + statistics +
                ", torque=" + torque +
                ", wheelsDrive='" + wheelsDrive + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
