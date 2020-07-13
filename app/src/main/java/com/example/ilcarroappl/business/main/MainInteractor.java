package com.example.ilcarroappl.business.main;

import com.example.ilcarroappl.data.dto.CarForUsersDto;

import java.util.List;

import io.reactivex.Completable;

public interface MainInteractor {
    Completable onSearch(String location, String dateStart, String dateEnd);

    Completable onViewPager();

    List<CarForUsersDto> getList();
}
