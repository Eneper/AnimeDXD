package com.example.lab_ux_animedxd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link homePage#newInstance} factory method to
// * create an instance of this fragment.
// */
public class homePage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        // == Tab Layout ==
        // === TabLayout + ViewPager2 ===
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPagerTabs = view.findViewById(R.id.viewPager);

        ViewPagerAdapter tabAdapter = new ViewPagerAdapter(requireActivity());
        tabAdapter.addFragment(new newsFragment(), "News");
        tabAdapter.addFragment(new mangaFragment(), "Manga List");

        viewPagerTabs.setAdapter(tabAdapter);

        new TabLayoutMediator(tabLayout, viewPagerTabs,
                (tab, position) -> tab.setText(tabAdapter.getPageTitle(position))
        ).attach();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        // --- Buat Carousel ---
//        ViewPager2 carouselViewPager = view.findViewById(R.id.carouselViewPager);
//        // Isi gambarnyaaa
//        List<Carousel> carousels = new ArrayList<>();
//        carousels.add(new Carousel(R.drawable.cover1));
//        carousels.add(new Carousel(R.drawable.sakamoto));
//        carousels.add(new Carousel(R.drawable.blackclover));
//
//        CarouselAdapter adapter = new CarouselAdapter(carousels);
//        carouselViewPager.setAdapter(adapter);
//
//        autoScrollRunnable = () -> {
//            int currentItem = carouselViewPager.getCurrentItem();
//            int nextItem = currentItem + 1;
//
//            // Jika sudah di item terakhir, kembali ke awal
//            if (nextItem >= adapter.getItemCount()) {
//                nextItem = 0;
//            }
//
//            carouselViewPager.setCurrentItem(nextItem, true); // 'true' untuk animasi geser mulus
//
//            // Jadwalkan eksekusi berikutnya
//            autoScrollHandler.postDelayed(autoScrollRunnable, SCROLL_DELAY);
//        };
//        for (Carousel carousel : carousels) {
//            View container = LayoutInflater.from(getContext()).inflate(R.layout.isi_carousel, keliling, false);
//            ImageView image = container.findViewById(R.id.isi_carousel);
//
//            image.setImageResource(carousel.getImage());
//            keliling.addView(container);
//        }
//        keliling.setFlipInterval(5000);
//        keliling.setAutoStart(true);
//        keliling.setInAnimation(getContext(), android.R.anim.slide_in_left);
//        keliling.setOutAnimation(getContext(), android.R.anim.fade_out);
//        keliling.startFlipping();
    }



}