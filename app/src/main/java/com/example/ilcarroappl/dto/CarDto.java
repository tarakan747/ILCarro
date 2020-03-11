package com.example.ilcarroappl.dto;

import java.util.List;

public class CarDto {
    String about;
    List<BookedPeriodsDto> booked_periods;
    String car_class;
    List<CommentsDto> comments;
    Double distance_included;
    Integer doors;
    String engine;
    List<String> features;
    String fuel;
    Double fuel_consumption;
    String gear;
    Integer horsepower;
    List<String> image_url;
    String make;
    String model;
    List<OwnerDto> owner;
    List<PickUpPlaceDto> pick_up_place;
    Double price_per_day;
    Integer seats;
    String serial_number;
    List<StatisticsDto> statistics;
    Double torque;
    String wheels_drive;
    String year;

    public String getAbout() {
        return about;
    }

    public List<BookedPeriodsDto> getBooked_periods() {
        return booked_periods;
    }

    public String getCar_class() {
        return car_class;
    }

    public List<CommentsDto> getComments() {
        return comments;
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

    public Double getFuel_consumption() {
        return fuel_consumption;
    }

    public String getGear() {
        return gear;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public List<String> getImage_url() {
        return image_url;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public List<OwnerDto> getOwner() {
        return owner;
    }

    public List<PickUpPlaceDto> getPick_up_place() {
        return pick_up_place;
    }

    public Double getPrice_per_day() {
        return price_per_day;
    }

    public Integer getSeats() {
        return seats;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public List<StatisticsDto> getStatistics() {
        return statistics;
    }

    public Double getTorque() {
        return torque;
    }

    public String getWheels_drive() {
        return wheels_drive;
    }

    public String getYear() {
        return year;
    }

    public CarDto() {
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "about='" + about + '\'' +
                ", booked_periods=" + booked_periods +
                ", car_class='" + car_class + '\'' +
                ", comments=" + comments +
                ", distance_included=" + distance_included +
                ", doors=" + doors +
                ", engine='" + engine + '\'' +
                ", features=" + features +
                ", fuel='" + fuel + '\'' +
                ", fuel_consumption=" + fuel_consumption +
                ", gear='" + gear + '\'' +
                ", horsepower=" + horsepower +
                ", image_url=" + image_url +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", owner=" + owner +
                ", pick_up_place=" + pick_up_place +
                ", price_per_day=" + price_per_day +
                ", seats=" + seats +
                ", serial_number='" + serial_number + '\'' +
                ", statistics=" + statistics +
                ", torque=" + torque +
                ", wheels_drive='" + wheels_drive + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public CarDto(String about, List<BookedPeriodsDto> booked_periods,
                  String car_class, List<CommentsDto> comments,
                  Double distance_included, Integer doors, String engine,
                  List<String> features, String fuel, Double fuel_consumption,
                  String gear, Integer horsepower, List<String> image_url, String make,
                  String model, List<OwnerDto> owner, List<PickUpPlaceDto> pick_up_place,
                  Double price_per_day, Integer seats, String serial_number,
                  List<StatisticsDto> statistics, Double torque, String wheels_drive, String year) {
        this.about = about;
        this.booked_periods = booked_periods;
        this.car_class = car_class;
        this.comments = comments;
        this.distance_included = distance_included;
        this.doors = doors;
        this.engine = engine;
        this.features = features;
        this.fuel = fuel;
        this.fuel_consumption = fuel_consumption;
        this.gear = gear;
        this.horsepower = horsepower;
        this.image_url = image_url;
        this.make = make;
        this.model = model;
        this.owner = owner;
        this.pick_up_place = pick_up_place;
        this.price_per_day = price_per_day;
        this.seats = seats;
        this.serial_number = serial_number;
        this.statistics = statistics;
        this.torque = torque;
        this.wheels_drive = wheels_drive;
        this.year = year;
    }
}
