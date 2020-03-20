package com.example.ilcarroappl.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ilcarroappl.BestCarFrag;
import com.example.ilcarroappl.data.dto.CarForUsersDto;


import java.util.List;

public class ViewPagerAdapters extends FragmentStatePagerAdapter {
    List<CarForUsersDto> bestCar;

    public ViewPagerAdapters(@NonNull FragmentManager fm, List<CarForUsersDto> bestCar) {
        super(fm);
        this.bestCar = bestCar;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return BestCarFrag.of(bestCar, position);
    }

    @Override
    public int getCount() {
        return bestCar.size();
    }
}


