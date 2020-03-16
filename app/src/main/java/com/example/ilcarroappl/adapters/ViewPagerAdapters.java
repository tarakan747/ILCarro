package com.example.ilcarroappl.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ilcarroappl.BestCarFrag;
import com.example.ilcarroappl.R;
import com.example.ilcarroappl.dto.CarDto;
import com.example.ilcarroappl.dto.CarListDto;

import java.util.List;

public class ViewPagerAdapters extends FragmentStatePagerAdapter {
    List<CarDto> bestCar;

    public ViewPagerAdapters(@NonNull FragmentManager fm, List<CarDto> bestCar) {
        super(fm);
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


