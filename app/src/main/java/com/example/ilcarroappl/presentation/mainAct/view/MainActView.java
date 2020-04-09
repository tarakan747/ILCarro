package com.example.ilcarroappl.presentation.mainAct.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainActView extends MvpView {

    @StateStrategyType(SingleStateStrategy.class)
    void showError(String error);

    @StateStrategyType(SingleStateStrategy.class)
    void checkPermissions();

    @StateStrategyType(SingleStateStrategy.class)
    void navigationSetting();

    @StateStrategyType(SingleStateStrategy.class)
    void toolbarSetting();

    @StateStrategyType(SingleStateStrategy.class)
    void getLocationUpd();

}
