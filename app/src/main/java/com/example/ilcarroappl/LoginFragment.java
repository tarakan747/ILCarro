package com.example.ilcarroappl;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    EditText email, password;
    Button yalla;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        email = view.findViewById(R.id.inputEmail);
        password = view.findViewById(R.id.inputPassword);
        yalla = view.findViewById(R.id.yallaBtnFrag);
        yalla.setOnClickListener(v -> {
            Toast.makeText(view.getContext(), password.getText().toString(), Toast.LENGTH_LONG).show();
        });
        return view;
    }
}
