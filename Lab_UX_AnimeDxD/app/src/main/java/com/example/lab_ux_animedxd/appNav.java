package com.example.lab_ux_animedxd;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class appNav extends Fragment {

    private String  loggedIn;

    public static appNav newInstance(String username) {
        appNav fragment = new appNav();
        Bundle args = new Bundle();
        args.putString("USERNAME_KEY", username); // Gunakan key yang konsisten
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. Ambil username dari arguments saat fragment dibuat
        if (getArguments() != null) {
            loggedIn = getArguments().getString("USERNAME_KEY");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_nav, container, false);

        BottomNavigationView bottomNav = view.findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        // Load halaman home sebagai default
        if (savedInstanceState == null) {
            homePage homeFrag = homePage.newInstance(loggedIn);
            loadFragment(homeFrag);
        }

        return view;
    }
    private void loadFragment(Fragment fragment) {
        // Gunakan getChildFragmentManager untuk mengelola fragment di dalam fragment
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private final BottomNavigationView.OnItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.nav_home) {
                    selectedFragment = new homePage();
                } else if (itemId == R.id.nav_list) {
                    selectedFragment = new listPage();
                }else if (itemId == R.id.nav_about) {
                    selectedFragment = new about();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                }
                return true;
            };

}