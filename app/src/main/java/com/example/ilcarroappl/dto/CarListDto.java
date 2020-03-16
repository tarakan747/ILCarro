package com.example.ilcarroappl.dto;

import java.util.List;

public class CarListDto {
    List<CarDto> cars;

    public CarListDto() {
    }

    public CarListDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarListDto{" +
                "cars=" + cars +
                '}';
    }

}
