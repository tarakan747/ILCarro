package com.example.ilcarroappl.presentation.main.view;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ilcarroappl.R;
import com.example.ilcarroappl.presentation.main.view.viewPager.adapter.ViewPagerAdapters;
import com.example.ilcarroappl.data.dto.CarForUsersDto;
import com.example.ilcarroappl.presentation.main.presenter.MainFragPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFrag extends MvpAppCompatFragment implements MainView {
    @InjectPresenter
    MainFragPresenter presenter;

    @BindView(R.id.inputLocation)
    EditText location;
    @BindView(R.id.inputFrom)
    EditText from;
    @BindView(R.id.inputTill)
    EditText till;
    @BindView(R.id.btnRed)
    Button redBtn;
    @BindView(R.id.bestCarsVP)
    ViewPager vp;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.myProgress)
    ProgressBar progressBarView;

    private Unbinder unbinder;

    private AlertDialog alertDialog;


    public MainFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_firs__screen, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter.showViewPager();
        return view;
    }


    @OnClick(R.id.btnRed)
    void onClickRedCtn() {
        String a = location.getText().toString();
        String b = till.getText().toString();
        String c = from.getText().toString();
        Toast.makeText(requireContext(), a + b + c, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressVP() {
        progressBar.setVisibility(View.VISIBLE);
        vp.setEnabled(false);
    }

    @Override
    public void hideProgressVP() {
        progressBar.setVisibility(View.GONE);
        vp.setEnabled(true);
    }

    @Override
    public void showProgress() {
        Log.d("Progress", "showProgress:1 ");
        progressBarView.setVisibility(View.VISIBLE);
        Log.d("Progress", "showProgress:2 ");
        location.setEnabled(false);
        from.setEnabled(false);
        till.setEnabled(false);
        redBtn.setEnabled(false);
        vp.setEnabled(false);

    }

    @Override
    public void hideProgress() {
        location.setEnabled(true);
        from.setEnabled(true);
        till.setEnabled(true);
        redBtn.setEnabled(true);
        vp.setEnabled(true);
        progressBarView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        alertDialog = new AlertDialog.Builder(requireContext())
                .setTitle("Error")
                .setMessage(error)
                .setCancelable(false)
                .setPositiveButton("OK", null)
                .create();
        alertDialog.show();
    }

    @Override
    public void hideError() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    @Override
    public void showNextView() {

    }

    @Override
    public void showViewPager(List<CarForUsersDto> list) {
        ViewPagerAdapters adapter = new ViewPagerAdapters(getFragmentManager(), list);
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(adapter);
    }

}
