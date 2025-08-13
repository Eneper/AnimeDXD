package com.example.lab_ux_animedxd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link newsFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class newsFragment extends Fragment {

    private Handler autoScrollHandler = new Handler();
    private Runnable autoScrollRunnable;
    private static final long SCROLL_DELAY = 5000L;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- Buat Carousel ---
        ViewPager2 carouselViewPager = view.findViewById(R.id.carouselViewPager);
        // Isi gambarnyaaa
        List<Carousel> carousels = new ArrayList<>();
        carousels.add(new Carousel(R.drawable.cover1));
        carousels.add(new Carousel(R.drawable.sakamoto));
        carousels.add(new Carousel(R.drawable.blackclover));

        CarouselAdapter adapter = new CarouselAdapter(carousels);
        carouselViewPager.setAdapter(adapter);

        autoScrollRunnable = () -> {
            int currentItem = carouselViewPager.getCurrentItem();
            int nextItem = currentItem + 1;

            // Jika sudah di item terakhir, kembali ke awal
            if (nextItem >= adapter.getItemCount()) {
                nextItem = 0;
            }

            carouselViewPager.setCurrentItem(nextItem, true); // 'true' untuk animasi geser mulus

            // Jadwalkan eksekusi berikutnya
            autoScrollHandler.postDelayed(autoScrollRunnable, SCROLL_DELAY);
        };
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

    @Override
    public void onResume() {
        super.onResume();
        autoScrollHandler.postDelayed(autoScrollRunnable, SCROLL_DELAY);
    }

    // Hentikan auto-scroll saat fragment tidak lagi terlihat
    @Override
    public void onPause() {
        super.onPause();
        autoScrollHandler.removeCallbacks(autoScrollRunnable);
    }
}