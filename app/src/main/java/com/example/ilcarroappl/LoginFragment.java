package com.example.ilcarroappl;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    EditText email, password;
    Button yalla, close, signUp;
    TextView click;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        email = view.findViewById(R.id.inputEmail);
        click = view.findViewById(R.id.click_frag);
        password = view.findViewById(R.id.inputPassword);
        yalla = view.findViewById(R.id.yallaBtnFrag);
        close = view.findViewById(R.id.close_btn_login_frag);
        signUp = view.findViewById(R.id.signUpBtnFrag);

        yalla.setOnClickListener(v -> {
            //TODO
        });

        signUp.setOnClickListener(v -> {
            //TODO
        });

        close.setOnClickListener(v -> {
            //TODO
        });
        return view;
    }
}
