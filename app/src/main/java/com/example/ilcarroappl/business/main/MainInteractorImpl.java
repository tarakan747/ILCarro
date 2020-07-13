package com.example.ilcarroappl.business.main;

import com.example.ilcarroappl.data.dto.CarForUsersDto;
import com.example.ilcarroappl.data.main.MainRepo;

import java.util.List;

import io.reactivex.Completable;

public class MainInteractorImpl implements MainInteractor {
    MainRepo repo;

    public MainInteractorImpl(MainRepo repo) {
        this.repo = repo;
    }

    @Override
    public Completable onSearch(String location, String dateStart, String dateEnd) {
        return null;
    }

    @Override
    public Completable onViewPager() {
        try {
            return repo.onViewPager();
        } catch (Throwable throwable) {
            return Completable.error(throwable);
        }
    }

    public List<CarForUsersDto> getList(){
        return repo.getList();
    }
}
