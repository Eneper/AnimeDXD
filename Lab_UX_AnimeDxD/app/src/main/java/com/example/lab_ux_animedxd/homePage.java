package com.example.lab_ux_animedxd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
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

    private ExoPlayer player;
    private PlayerView playerView;
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
        playerView = view.findViewById(R.id.video_player_view);


    }

    private void initializePlayer() {
        player = new ExoPlayer.Builder(requireContext()).build();
        playerView.setPlayer(player);

        // Buat item media dari URL video
        // Ganti URL ini dengan URL video Anda atau gunakan dari folder raw
        MediaItem mediaItem = MediaItem.fromUri("");

        // Set item media ke player dan siapkan
        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();
    }

    // Metode untuk melepaskan player saat tidak dibutuhkan
    private void releasePlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    // --- Manajemen Siklus Hidup (Sangat Penting!) ---

    @Override
    public void onStart() {
        super.onStart();
        // Inisialisasi player saat fragment dimulai/terlihat
        initializePlayer();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (player != null) {
            // Lanjutkan pemutaran jika aplikasi kembali dari background
            player.play();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (player != null) {
            // Jeda pemutaran saat aplikasi di-pause
            player.pause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // Hancurkan player saat fragment tidak lagi terlihat untuk menghemat resource
        releasePlayer();
    }



}