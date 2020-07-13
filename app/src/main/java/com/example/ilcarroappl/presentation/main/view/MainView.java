package com.example.ilcarroappl.presentation.main.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.ilcarroappl.data.dto.CarForUsersDto;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void showProgressVP();

    void hideProgressVP();

    void showProgress();

    void hideProgress();

    @StateStrategyType(SingleStateStrategy.class)
    void showError(String error);

    @StateStrategyType(SingleStateStrategy.class)
    void hideError();

    @StateStrategyType(SingleStateStrategy.class)
    void showNextView();

    @StateStrategyType(SingleStateStrategy.class)
    void showViewPager(List<CarForUsersDto> list);
}
