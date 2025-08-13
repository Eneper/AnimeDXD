package com.example.lab_ux_animedxd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {


    private Context context;
    private List<Carousel> imageList;
//    private static final String TAG = "CarouselDebug"; // Tag untuk filter Log
    public CarouselAdapter(Context context, List<Carousel> imageList) {
        this.context = context;
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.isi_carousel, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        Carousel carousel = imageList.get(position);

        holder.imageView.setImageResource(carousel.getImageResourceId());


    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class CarouselViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.isi_carousel);
        }
    }
}
