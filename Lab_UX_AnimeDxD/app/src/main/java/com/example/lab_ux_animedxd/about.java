package com.example.lab_ux_animedxd;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class about extends Fragment {

    public interface OnLogoutRequestListener {
        void onLogoutAbout();
    }
    private OnLogoutRequestListener logoutListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // 2. Pastikan MainActivity mengimplementasikan listener
        if (context instanceof OnLogoutRequestListener) {
            logoutListener = (OnLogoutRequestListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnLogoutRequestListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Session sessionManager = new Session(requireContext());
        String loggedInUsername = sessionManager.getUsername();

        TextView welcomeName = view.findViewById(R.id.usName);
        if(loggedInUsername != null && !loggedInUsername.isEmpty()){
            welcomeName.setText("Welcome, "+ loggedInUsername + "!");
        }else{
            welcomeName.setText("No name");
        }

        ImageButton menuButton = view.findViewById(R.id.menuButton);
        menuButton.setOnClickListener(v -> showLogoutPopup(view)); // Kirim 'view' sebagai anchor
    }

    private void showLogoutPopup(View view) {
        View popupView = LayoutInflater.from(getContext()).inflate(R.layout.logout_popup, null);

        int heightInDp = 50;

        float scale = getResources().getDisplayMetrics().density;
        int heightInPixels = (int) (heightInDp * scale + 0.5f);


        final PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                heightInPixels, true);

        // Setting popupwindow
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.showAtLocation(view, Gravity.TOP, 0, 0);


        TextView tvLogout = popupView.findViewById(R.id.logout_popup);
        tvLogout.setOnClickListener(v -> {
            popupWindow.dismiss();
            if (logoutListener != null) {
                logoutListener.onLogoutAbout();
            }
        });
    }




}