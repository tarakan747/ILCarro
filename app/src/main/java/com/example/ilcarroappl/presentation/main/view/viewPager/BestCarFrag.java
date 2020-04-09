package com.example.ilcarroappl.presentation.main.view.viewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilcarroappl.R;
import com.example.ilcarroappl.data.dto.CarForUsersDto;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestCarFrag extends Fragment {

    String nameCar, priceCar, seat, doors, manual, imgUrl;

    @BindView(R.id.nameCarTxt)
    TextView nameCarTxt;
    @BindView(R.id.priceCarTxt)
    TextView priceCarTxt;
    @BindView(R.id.seatTxt)
    TextView seatTxt;
    @BindView(R.id.doorsTxt)
    TextView doorsTxt;
    @BindView(R.id.manualTxt)
    TextView manualTxt;
    @BindView(R.id.photoCarImg)
    ImageView photoCar;

    private Unbinder unbinder;


    public BestCarFrag() {}


    public static Fragment of(CarForUsersDto car) {
        BestCarFrag fragment = new BestCarFrag();
        fragment.nameCar = car.getMake() + " \n" + car.getModel() + " " + car.getYear();
        fragment.priceCar = car.getPricePerDay() + " $/day";
        fragment.seat = car.getSeats().toString();
        fragment.doors = car.getDoors().toString();
        List<String> img = car.getImageUrl();
        fragment.imgUrl = img.get(0);
        fragment.manual = car.getGear();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_best_car, container, false);
        unbinder = ButterKnife.bind(this, view);

        Picasso.get().load(imgUrl).into(photoCar);
        nameCarTxt.setText(nameCar);
        priceCarTxt.setText(priceCar);
        seatTxt.setText(seat);
        doorsTxt.setText(doors);
        manualTxt.setText(manual);

        return view;
    }
}
