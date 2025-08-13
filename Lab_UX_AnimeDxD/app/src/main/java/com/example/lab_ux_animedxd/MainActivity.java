package com.example.lab_ux_animedxd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Set layout "Rumah"
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        // Tampilkan fragment awal (HomePage) saat aplikasi pertama kali dibuka
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new homePage()).commit();
        }

//        setContentView(R.layout.fragment_home_page);
//        setContentView(R.layout.fragment_list_page);

//      Ini bagian untuk carousel
//        List<Carousel> carousels = new ArrayList<>();
//        carousels.add(new Carousel(R.drawable.cover1));
//        carousels.add(new Carousel(R.drawable.sakamoto));
//        carousels.add(new Carousel(R.drawable.blackclover));
//
//        ViewFlipper keliling = findViewById(R.id.carouselFlipper);
//        for(Carousel carousel : carousels){
//            View container = LayoutInflater.from(this).inflate(R.layout.isi_carousel,keliling,false);
//            ImageView image = container.findViewById(R.id.isi_carousel);
//
//            image.setImageResource(carousel.getImage());
//            keliling.addView(container);
//        }
//        keliling.setFlipInterval(5000);
//        keliling.setAutoStart(true);
//        keliling.setInAnimation(this , android.R.anim.slide_in_left);
//        keliling.setOutAnimation(this , android.R.anim.fade_out);
//
////      Tab Layout
//        TabLayout tabLayout = findViewById(R.id.tabLayout);
//        ViewPager2 viewPager = findViewById(R.id.viewPager);
//
//        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
//        adapter.addFragment(new newsFragment(), "News");
//        adapter.addFragment(new mangaFragment(), "Manga List");
//
//        viewPager.setAdapter(adapter);
//
//        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
//            tab.setText(adapter.getPageTitle(position));
//        }).attach();

//      Ini untuk List
//      ListView listView =findViewById(R.id.listView);


    }
    private final BottomNavigationView.OnItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.nav_home) { // ID dari file menu
                    selectedFragment = new homePage();
                } else if (itemId == R.id.nav_list) { // ID dari file menu
                    selectedFragment = new listPage();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                }
                return true;
            };

}