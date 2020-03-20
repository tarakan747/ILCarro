package com.example.ilcarroappl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilcarroappl.data.dto.CarForUsersDto;
import com.example.ilcarroappl.dto.CarDto;
import com.example.ilcarroappl.dto.CarListDto;
import com.squareup.picasso.Picasso;


import java.io.InputStream;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestCarFrag extends Fragment {

    private static String nameCar, priceCar, seat, doors, manual, imgUrl;
    TextView nameCarTxt, priceCarTxt, seatTxt, doorsTxt, manualTxt;
    ImageView photoCar;

    public BestCarFrag() {
        // Required empty public constructor
    }


    public static Fragment of(List<CarForUsersDto> bestCar, int pos) {
        BestCarFrag fragment = new BestCarFrag();
        CarForUsersDto car = bestCar.get(pos);
        nameCar = car.getMake() + " " + car.getModel() + " " + car.getYear();
        priceCar = car.getPricePerDay() + " $/day";
        seat = car.getSeats().toString();
        doors = car.getDoors().toString();
        List<String> img = car.getImageUrl();
        imgUrl = img.get(0);
        Log.d("MY_TAG", "of: " + imgUrl);
        manual = car.getGear();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_best_car, container, false);
        init(view);
        Log.d("MY_TAG", "onCreateView: " + imgUrl);
        Picasso.get().load(imgUrl).into(photoCar);
        nameCarTxt.setText(nameCar);
        priceCarTxt.setText(priceCar);
        seatTxt.setText(seat);
        doorsTxt.setText(doors);
        manualTxt.setText(manual);

        return view;
    }

    private void init(View view) {
        photoCar = view.findViewById(R.id.photoCarImg);
        nameCarTxt = view.findViewById(R.id.nameCarTxt);
        priceCarTxt = view.findViewById(R.id.priceCarTxt);
        seatTxt = view.findViewById(R.id.seatTxt);
        doorsTxt = view.findViewById(R.id.doorsTxt);
        manualTxt = view.findViewById(R.id.manualTxt);

    }

}
