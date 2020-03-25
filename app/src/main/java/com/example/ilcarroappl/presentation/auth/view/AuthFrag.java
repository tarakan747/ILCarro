package com.example.ilcarroappl.presentation.auth.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.ilcarroappl.R;
import com.example.ilcarroappl.presentation.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthFrag extends Fragment {

    private boolean swap;

    //ToolBar btn
    @BindView(R.id.swapBtn)
    Button swapBtn;
    @BindView(R.id.closeBtn)
    Button closeBtn;

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

    Unbinder unbinder;

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
        
        return view;
    }


    @OnClick(R.id.swapBtn)
    void onClickSwapBtn() {
        if (!swap) {
            loginFrame.setVisibility(View.VISIBLE);
            registrationFrame.setVisibility(View.GONE);
            swapBtn.setText("Sign up");
        } else {
            loginFrame.setVisibility(View.GONE);
            registrationFrame.setVisibility(View.VISIBLE);
            swapBtn.setText("Log in");
        }
        this.swap = !swap;
    }

    @OnClick(R.id.closeBtn)
    void onClickCloseBtn() {
        getFragmentManager().beginTransaction()
                .remove(this)
                .commit();
    }
}
