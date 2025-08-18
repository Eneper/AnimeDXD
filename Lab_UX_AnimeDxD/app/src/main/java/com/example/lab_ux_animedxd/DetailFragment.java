package com.example.lab_ux_animedxd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends DialogFragment {

    // Kunci untuk mengambil data dari Bundle
    private static final String ARG_NAME = "ARG_NAME";
    private static final String ARG_GENRE = "ARG_GENRE";
    private static final String ARG_DESC = "ARG_DESC";
    private static final String ARG_IMAGE_ID = "ARG_IMAGE_ID";

    // Factory method untuk membuat fragment sambil mengirim data
    public static DetailFragment newInstance(String name, String genre, String description, int imageId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_GENRE, genre);
        args.putString(ARG_DESC, description);
        args.putInt(ARG_IMAGE_ID, imageId);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_App_FullScreenDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        if (getArguments() != null) {
            String name = getArguments().getString(ARG_NAME);
            String genre = getArguments().getString(ARG_GENRE);
            String description = getArguments().getString(ARG_DESC);
            int imageId = getArguments().getInt(ARG_IMAGE_ID);

            ImageView bannerImage = view.findViewById(R.id.land_image);
            ImageView posterImage = view.findViewById(R.id.port_image);
            TextView titleText = view.findViewById(R.id.detail_name);
            TextView genreText = view.findViewById(R.id.detail_genre);
            TextView synopsisText = view.findViewById(R.id.detail_synopsis);
            ImageButton backButton = view.findViewById(R.id.backButton);

            // Tampilkan data
            bannerImage.setImageResource(imageId);
            posterImage.setImageResource(imageId);
            titleText.setText(name);
            genreText.setText(genre);
            synopsisText.setText(description);

            // Fungsi tombol kembali
            backButton.setOnClickListener(v -> dismiss());


        }

        Button btnReview = view.findViewById(R.id.button_review); // Pastikan ID ini ada di fragment_detail.xml

        // Tambahkan OnClickListener
        btnReview.setOnClickListener(v -> {
            // Buat dan tampilkan dialog review
            reviewFragment reviewDialog = new reviewFragment();
            reviewDialog.show(getParentFragmentManager(), "ReviewDialog");
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }
}