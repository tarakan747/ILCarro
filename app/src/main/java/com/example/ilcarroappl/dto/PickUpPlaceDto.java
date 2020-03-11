package com.example.ilcarroappl.dto;

public class PickUpPlaceDto {
    Double latitude;
    Double longitude;
    String place_id;

    @Override
    public String toString() {
        return "PickUpPlaceDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", place_id='" + place_id + '\'' +
                '}';
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getPlace_id() {
        return place_id;
    }

    public PickUpPlaceDto(Double latitude, Double longitude, String place_id) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.place_id = place_id;
    }

    public PickUpPlaceDto() {
    }
}
