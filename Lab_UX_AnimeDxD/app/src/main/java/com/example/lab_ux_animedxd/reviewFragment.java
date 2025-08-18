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
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class reviewFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        // Inisialisasi komponen UI dari layout dialog
        RatingBar ratingBar = view.findViewById(R.id.rating_bar);
        EditText etComment = view.findViewById(R.id.et_comment);
        Button btnSubmit = view.findViewById(R.id.btn_submit);

        // Aksi tombol Kirim
        btnSubmit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String comment = etComment.getText().toString();

            if (rating == 0.0f) {
                // Jika belum ada bintang yang dipilih
                Toast.makeText(getContext(), "Harap berikan rating bintang", Toast.LENGTH_SHORT).show();
                return; // Hentikan eksekusi
            }

            if (comment.isEmpty()) {
                // Jika komentar kosong
                etComment.setError("Komentar tidak boleh kosong");
                return; // Hentikan eksekusi
            }
            
            String reviewMessage = "Rating: " + rating + " | Komentar: " + comment;
            Toast.makeText(getContext(), reviewMessage, Toast.LENGTH_LONG).show();

            // Tutup dialog setelah mengirim
            dismiss();
        });

        return view;
    }

    // Mengatur agar dialog tidak bisa ditutup dengan klik di luar area
    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(false);
        }
    }
}