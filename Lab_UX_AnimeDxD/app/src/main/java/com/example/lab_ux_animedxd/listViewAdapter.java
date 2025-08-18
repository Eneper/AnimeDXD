package com.example.lab_ux_animedxd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class listViewAdapter extends RecyclerView.Adapter<listViewAdapter.listHolder> {

    private Context context;

    private List<isiList> gambar;

    public listViewAdapter(Context context, List<isiList> gambar, OnItemClickListener listener) {
        this.context = context;
        this.gambar = gambar;
        this.listener = listener;
    }

    @NonNull
    @Override
    public listHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent , false);

        return new listHolder(view , listener);
    }

    @Override
    public void onBindViewHolder(@NonNull listHolder holder, int position) {
        isiList isi = gambar.get(position);
        holder.imgCover.setImageResource(isi.getImageResourceId());
        holder.name.setText(isi.getName());
        holder.genre.setText((isi.getGenre()));
        holder.desc.setText(isi.getDescription());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return gambar.size();
    }

    static class listHolder extends RecyclerView.ViewHolder{

        ImageView imgCover, landImg;

        TextView name , desc , genre;

        public listHolder(@NonNull View itemView , OnItemClickListener listener) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.gambar_list);
            name = itemView.findViewById(R.id.item_name);
            genre = itemView.findViewById(R.id.item_genre);
            desc = itemView.findViewById(R.id.item_desc);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    listener.onItemClick(position);
                }
            });
        }

    }

    //Ini buat ngatur item bisa di klik
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener listener;
}
