package com.example.lab_ux_animedxd;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginFragment extends Fragment {

    // Interface untuk berkomunikasi dengan MainActivity
    public interface OnLoginSuccessListener {
        void onLoginSuccess();
    }
    private OnLoginSuccessListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginSuccessListener) {
            listener = (OnLoginSuccessListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnLoginSuccessListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText etUsname = view.findViewById(R.id.et_usname);
        EditText etPassword = view.findViewById(R.id.et_password);
        Button btnLogin = view.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> {
            String Username = etUsname.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (Username.equals("Carmen") && password.equals("123456")) {
                // Beri tahu MainActivity bahwa login sukses
                if (listener != null) {
                    listener.onLoginSuccess();
                }
            } else {
                Toast.makeText(getContext(), "Email atau password salah", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}