package com.example.ilcarroappl.dto;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class CarListDto {
    @SerializedName("auto")
    List<CarDto> auto;

    public CarListDto() {
    }

    public CarListDto(List<CarDto> cars) {
        this.auto = cars;
    }

    public List<CarDto> getCars() {
        return auto;
    }

    public void setCars(List<CarDto> cars) {
        this.auto = cars;
    }

    @Override
    public String toString() {
        return "CarListDto{" +
                "cars=" + auto +
                '}';
    }

}
