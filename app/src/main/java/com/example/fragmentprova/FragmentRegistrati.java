package com.example.fragmentprova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class FragmentRegistrati extends Fragment {

    EditText email;
    EditText password;
    EditText repassword;

    ImageButton btnRegistrati;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrati, container, false);

        email = view.findViewById(R.id.rEmail);
        password = view.findViewById(R.id.rPassword);
        repassword = view.findViewById(R.id.repassword);

        btnRegistrati = view.findViewById(R.id.btnRRegister);

        btnRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInserita = email.getText().toString();
                String passwordInserita = password.getText().toString();
                String repasswordInserita = repassword.getText().toString();
            }
        });

        return view;
    }
}
