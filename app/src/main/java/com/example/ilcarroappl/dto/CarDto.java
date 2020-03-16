package com.example.ilcarroappl.dto;

import java.util.List;

public class CarDto {
    String about;
    List<BookedPeriodsDto> booked_periods;
    String car_class;
    List<CommentsDto> comments;
    double distance_included;
    int doors;
    String engine;
    List<String> features;
    String fuel;
    float fuel_consumption;
    String gear;
    int horsepower;
    List<String> image_url;
    String make;
    String model;
    List<OwnerDto> owner;
    List<PickUpPlaceDto> pick_up_place;
    double price_per_day;
    List<ReservedPeriodDto> reserved_periods;
    int seats;
    String serial_number;
    List<StatisticsDto> statistics;
    int torque;
    String wheels_drive;
    String year;

    public CarDto() {
    }

    public CarDto(String about, List<BookedPeriodsDto> booked_periods, String car_class,
                  List<CommentsDto> comments, double distance_included, int doors, String engine,
                  List<String> features, String fuel, float fuel_consumption, String gear,
                  int horsepower, List<String> image_url, String make, String model,
                  List<OwnerDto> owner, List<PickUpPlaceDto> pick_up_place, double price_per_day,
                  List<ReservedPeriodDto> reserved_periods, int seats, String serial_number,
                  List<StatisticsDto> statistics, int torque, String wheels_drive, String year) {
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
        this.reserved_periods = reserved_periods;
        this.seats = seats;
        this.serial_number = serial_number;
        this.statistics = statistics;
        this.torque = torque;
        this.wheels_drive = wheels_drive;
        this.year = year;
    }

//    public CarDto(String serial_number, String make, String model, String year, String engine,
//                  String fuel, String gear, String wheels_drive, int horsepower, int torque,
//                  int doors, int seats, String car_class, float fuel_consumption, List<String> features,
//                  double price_per_day, double distance_included, String about, List<PickUpPlaceDto> pick_up_place,
//                  List<String> image_url, List<OwnerDto> owner, List<BookedPeriodsDto> booked_periods,
//                  List<ReservedPeriodDto> reserved_periods, List<StatisticsDto> statistics, List<CommentsDto> comments) {
//        this.about = about;
//        this.booked_periods = booked_periods;
//        this.car_class = car_class;
//        this.comments = comments;
//        this.distance_included = distance_included;
//        this.doors = doors;
//        this.engine = engine;
//        this.features = features;
//        this.fuel = fuel;
//        this.fuel_consumption = fuel_consumption;
//        this.gear = gear;
//        this.horsepower = horsepower;
//        this.image_url = image_url;
//        this.make = make;
//        this.model = model;
//        this.owner = owner;
//        this.pick_up_place = pick_up_place;
//        this.price_per_day = price_per_day;
//        this.reserved_periods = reserved_periods;
//        this.seats = seats;
//        this.serial_number = serial_number;
//        this.statistics = statistics;
//        this.torque = torque;
//        this.wheels_drive = wheels_drive;
//        this.year = year;
//    }

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
                ", reserved_periods=" + reserved_periods +
                ", seats=" + seats +
                ", serial_number='" + serial_number + '\'' +
                ", statistics=" + statistics +
                ", torque=" + torque +
                ", wheels_drive='" + wheels_drive + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

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

    public double getDistance_included() {
        return distance_included;
    }

    public int getDoors() {
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

    public float getFuel_consumption() {
        return fuel_consumption;
    }

    public String getGear() {
        return gear;
    }

    public int getHorsepower() {
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

    public double getPrice_per_day() {
        return price_per_day;
    }

    public List<ReservedPeriodDto> getReserved_periods() {
        return reserved_periods;
    }

    public int getSeats() {
        return seats;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public List<StatisticsDto> getStatistics() {
        return statistics;
    }

    public int getTorque() {
        return torque;
    }

    public String getWheels_drive() {
        return wheels_drive;
    }

    public String getYear() {
        return year;
    }
}
