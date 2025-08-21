package com.example.lab_ux_animedxd;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
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

    private String username;

    public interface OnLogoutListener {
        void onLogout();
    }
    private OnLogoutListener logoutListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Pastikan MainActivity mengimplementasikan listener ini
        if (context instanceof OnLogoutListener) {
            logoutListener = (OnLogoutListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnLogoutListener");
        }
    }

    //Buat passing nama
    public static homePage newInstance(String username) {
        homePage fragment= new homePage();
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
            username = getArguments().getString("USERNAME_KEY");
        }
    }

    //Buat nampilin apa aja yang mau ditampilin di homepage
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

    //Buat nampilin apa yang ditampilin di tempat yang udah ditampilin
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playerView = view.findViewById(R.id.video_player_view);

        Session sessionManager = new Session(requireContext());
        String loggedInUsername = sessionManager.getUsername();

        TextView welcomeName = view.findViewById(R.id.usName);
        if(loggedInUsername != null && !loggedInUsername.isEmpty()){
            welcomeName.setText("Welcome, "+ loggedInUsername + "!");
        }else{
            welcomeName.setText("No name");
        }

        ImageButton menuButton = view.findViewById(R.id.logoutButton);
        menuButton.setOnClickListener(v -> showPopupMenu(v));

    }

    private void initializePlayer() {
        player = new ExoPlayer.Builder(requireContext()).build();
        playerView.setPlayer(player);

        // Dapatkan URI dari file di folder raw
        Uri videoUri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + R.raw.video);

        // Buat MediaItem dari URI
        MediaItem mediaItem = MediaItem.fromUri(videoUri);

        // Set item media ke player dan siapkan
        player.setMediaItem(mediaItem);
        player.prepare();

        // Mulai pemutaran
        player.play();
    }

    // Metode untuk melepaskan player saat tidak dibutuhkan
    private void releasePlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

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

    //Popup logout
    private void showPopupMenu(View anchorView) {
        // Buat instance PopupMenu
        final View rootView = requireActivity().getWindow().getDecorView().getRootView();
        final Drawable dim = new ColorDrawable(0x99000000);


        rootView.setForeground(dim);
//        PopupMenu popup = new PopupMenu(requireContext(), anchorView);

        // Hubungkan dengan file menu kita
        View popupView = LayoutInflater.from(getContext()).inflate(R.layout.logout_home, null);

        final PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        popupWindow.setOnDismissListener(() -> {
            // Hapus efek redup saat popup ditutup
            rootView.setForeground(null);
        });

        int xOffset = -200;
        int yOffset = 0; // Coba geser jauh ke bawah

        popupWindow.showAsDropDown(anchorView, xOffset, yOffset);

        // Atur listener untuk menangani klik pada item menu
        TextView tvLogout = popupView.findViewById(R.id.tv_logout);
        tvLogout.setOnClickListener(v -> {
            popupWindow.dismiss(); // Tutup popup
            if (logoutListener != null) {
                logoutListener.onLogout(); // Beri tahu MainActivity untuk logout
            }
        });
    }

}