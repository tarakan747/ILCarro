package com.example.ilcarroappl.presentation.auth.view;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ilcarroappl.R;
import com.example.ilcarroappl.presentation.auth.presentation.AuthPresenter;
import com.example.ilcarroappl.presentation.mainAct.presentation.MainActivityPresenter;
import com.example.ilcarroappl.presentation.mainAct.view.MainActView;
import com.example.ilcarroappl.presentation.mainAct.view.MainActivity;
import com.example.ilcarroappl.presentation.rent.view.RentFrag;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthFrag extends MvpAppCompatFragment implements AuthView {
    @InjectPresenter
    AuthPresenter presenter;

    private boolean swap;

    //ToolBar btn progress
    @BindView(R.id.swapBtn)
    Button swapBtn;
    @BindView(R.id.closeBtn)
    Button closeBtn;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    //Login Frame
    @BindView(R.id.loginFrame)
    ViewGroup loginFrame;
    @BindView(R.id.btnRedLoginFrame)
    Button btnLogin;
    @BindView(R.id.inputEmailLoginFrame)
    EditText inputEmailLogin;
    @BindView(R.id.inputPasswordLoginFrame)
    EditText inputPasswordLogin;

    //Registration Frame
    @BindView(R.id.registrationFrame)
    ViewGroup registrationFrame;
    @BindView(R.id.inputNameRegistrationFrame)
    EditText inputNameRegistration;
    @BindView(R.id.inputLastNameRegistrationFrame)
    EditText inputLastNameRegistration;
    @BindView(R.id.inputEmailRegistrationFrame)
    EditText inputEmailRegistration;
    @BindView(R.id.inputPasswordRegistrationFrame)
    EditText inputPasswordRegistration;
    @BindView(R.id.checkBoxRegistrationFrame)
    CheckBox checkBoxRegistration;
    @BindView(R.id.btnRedRegistrationFrame)
    Button btnRegistration;

    InputMethodManager imm;

    Unbinder unbinder;

    AlertDialog dialog;


    public AuthFrag() {
    }

    public AuthFrag(boolean swap) {
        this.swap = swap;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (swap) {
            loginFrame.setVisibility(View.VISIBLE);
            swapBtn.setText("Sign up");
        } else {
            registrationFrame.setVisibility(View.VISIBLE);
            swapBtn.setText("Log in");
        }
        imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.btnRedLoginFrame)
    void onLoginClick() {
        presenter.onLogin(inputEmailLogin.getText().toString(),
                inputPasswordLogin.getText().toString());
        toggleForced();
    }

    @Override
    @OnClick(R.id.swapBtn)
    public void onClickSwapBtn() {
        if (!swap) {
            loginFrame.setVisibility(View.VISIBLE);
            registrationFrame.setVisibility(View.GONE);
            swapBtn.setText("Sign up");
            inputEmailRegistration.setText("");
            inputNameRegistration.setText("");
            inputLastNameRegistration.setText("");
            inputPasswordRegistration.setText("");
            checkBoxRegistration.setChecked(false);
        } else {
            loginFrame.setVisibility(View.GONE);
            registrationFrame.setVisibility(View.VISIBLE);
            swapBtn.setText("Log in");
            inputEmailLogin.setText("");
            inputPasswordLogin.setText("");
        }
        this.swap = !swap;
    }

    @OnClick(R.id.closeBtn)
    void onClickCloseBtn() {
        getFragmentManager().beginTransaction()
                .remove(this)
                .commit();
        toggleForced();
    }

    @OnClick(R.id.btnRedRegistrationFrame)
    void onRegClick() {
        if (checkBoxRegistration.isChecked()) {
            presenter.onRegistration(inputNameRegistration.getText().toString(),
                    inputLastNameRegistration.getText().toString(),
                    inputEmailRegistration.getText().toString(),
                    inputPasswordRegistration.getText().toString());
        } else {
            Toast.makeText(requireContext(), "Please agree privacy policy", Toast.LENGTH_LONG).show();
        }
        toggleForced();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        loginFrame.setEnabled(false);
        registrationFrame.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        loginFrame.setEnabled(true);
        registrationFrame.setEnabled(true);
    }

    @Override
    public void toggleForced() {
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    @Override
    public void showError(String error) {
        dialog = new AlertDialog.Builder(requireContext())
                .setTitle("Error")
                .setMessage(error)
                .setPositiveButton("OK", null)
                .setCancelable(false)
                .create();
        dialog.show();
    }

    @Override
    public void hideError() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void showNextView() {
        getActivity().recreate();
        Objects.requireNonNull(getFragmentManager()).beginTransaction()
                .remove(this)
                .commit();
    }
}
