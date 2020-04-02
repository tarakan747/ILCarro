package com.example.ilcarroappl.presentation.rent.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilcarroappl.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RentFrag extends Fragment {

    public RentFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rent, container, false);
    }
}
