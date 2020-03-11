package com.example.ilcarroappl.dto;

import java.util.List;

public class UserCarDto {
    String about;
    String car_class;
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
    List<PickUpPlaceDto> pick_up_place;
    Double price_per_day;
    Integer seats;
    String serial_number;
    Double torque;
    String wheels_drive;

    @Override
    public String toString() {
        return "UserCarDto{" +
                "about='" + about + '\'' +
                ", car_class='" + car_class + '\'' +
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
                ", pick_up_place=" + pick_up_place +
                ", price_per_day=" + price_per_day +
                ", seats=" + seats +
                ", serial_number='" + serial_number + '\'' +
                ", torque=" + torque +
                ", wheels_drive='" + wheels_drive + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCar_class() {
        return car_class;
    }

    public void setCar_class(String car_class) {
        this.car_class = car_class;
    }

    public Double getDistance_included() {
        return distance_included;
    }

    public void setDistance_included(Double distance_included) {
        this.distance_included = distance_included;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Double getFuel_consumption() {
        return fuel_consumption;
    }

    public void setFuel_consumption(Double fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public List<String> getImage_url() {
        return image_url;
    }

    public void setImage_url(List<String> image_url) {
        this.image_url = image_url;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<PickUpPlaceDto> getPick_up_place() {
        return pick_up_place;
    }

    public void setPick_up_place(List<PickUpPlaceDto> pick_up_place) {
        this.pick_up_place = pick_up_place;
    }

    public Double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(Double price_per_day) {
        this.price_per_day = price_per_day;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Double getTorque() {
        return torque;
    }

    public void setTorque(Double torque) {
        this.torque = torque;
    }

    public String getWheels_drive() {
        return wheels_drive;
    }

    public void setWheels_drive(String wheels_drive) {
        this.wheels_drive = wheels_drive;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public UserCarDto() {
    }

    public UserCarDto(String about, String car_class, Double distance_included, Integer doors, String engine,
                      List<String> features, String fuel, Double fuel_consumption, String gear, Integer horsepower,
                      List<String> image_url, String make, String model, List<PickUpPlaceDto> pick_up_place,
                      Double price_per_day, Integer seats, String serial_number, Double torque, String wheels_drive, String year) {
        this.about = about;
        this.car_class = car_class;
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
        this.pick_up_place = pick_up_place;
        this.price_per_day = price_per_day;
        this.seats = seats;
        this.serial_number = serial_number;
        this.torque = torque;
        this.wheels_drive = wheels_drive;
        this.year = year;
    }

    String year;
}
