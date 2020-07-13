package com.example.ilcarroappl.data.main;

import com.example.ilcarroappl.data.dto.CarForUsersDto;

import java.util.List;

import io.reactivex.Completable;

public interface MainRepo {
    Completable onSearch(String location, String dateStart, String dateEnd);

    Completable onViewPager();

    List<CarForUsersDto> getList();
}
