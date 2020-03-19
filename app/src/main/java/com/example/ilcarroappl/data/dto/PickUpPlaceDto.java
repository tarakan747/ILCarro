package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class PickUpPlaceDto {
    @SerializedName("latitude")
    Double latitude;

    @SerializedName("longitude")
    Double longitude;

    @SerializedName("place_id")
    String placeId;

    public PickUpPlaceDto() {
    }

    public PickUpPlaceDto(Double latitude, Double longitude, String placeId) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.placeId = placeId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getPlaceId() {
        return placeId;
    }

    @Override
    public String toString() {
        return "PickUpPlaceDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", placeId='" + placeId + '\'' +
                '}';
    }
}
