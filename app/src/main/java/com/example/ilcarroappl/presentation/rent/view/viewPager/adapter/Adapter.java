package com.example.ilcarroappl.presentation.rent.view.viewPager.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ilcarroappl.data.dto.CarsFiltersDto;

import java.util.List;

public class Adapter extends FragmentPagerAdapter {

    List<CarsFiltersDto> list;

    public Adapter(@NonNull FragmentManager fm, List<CarsFiltersDto> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }
}
