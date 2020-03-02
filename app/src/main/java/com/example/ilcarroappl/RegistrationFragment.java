package com.example.ilcarroappl;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {
    CheckBox checkBox;
    Button login, close, yalla;
    EditText inputEmail, inputPassword, inputName, inputLastName;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        checkBox = view.findViewById(R.id.checkBox);

        yalla = view.findViewById(R.id.yalla_btn_reg_frag);
        login = view.findViewById(R.id.log_in_reg);
        close = view.findViewById(R.id.close_btn_reg_frag);

        inputEmail = view.findViewById(R.id.inputEmail);
        inputPassword = view.findViewById(R.id.inputPassword);
        inputName = view.findViewById(R.id.inputName);
        inputLastName = view.findViewById(R.id.inputLastName);

        login.setOnClickListener(v -> {
            getFragmentManager()
                    .beginTransaction()
                    .remove(this)
                    .replace(R.id.drawer_layout, new LoginFragment())
                    .commit();
        });
        return view;
    }
}
