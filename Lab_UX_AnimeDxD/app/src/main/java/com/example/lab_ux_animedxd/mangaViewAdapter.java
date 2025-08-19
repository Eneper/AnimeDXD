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

public class mangaViewAdapter extends RecyclerView.Adapter<mangaViewAdapter.mangaHolder>  {
    private Context context;

    private List<isiManga> gambar;

    public mangaViewAdapter(Context context, List<isiManga> gambar) {
        this.context = context;
        this.gambar = gambar;
    }

    @NonNull
    @Override
    public mangaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manga_list, parent , false);

        return new mangaHolder(view , listener);
    }

    @Override
    public void onBindViewHolder(@NonNull mangaHolder holder, int position) {
        isiManga isi = gambar.get(position);
        holder.imgCover.setImageResource(isi.getImageResourceId());
        holder.name.setText(isi.getName());
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

    static class mangaHolder extends RecyclerView.ViewHolder{

        ImageView imgCover, landImg;

        TextView name , desc ;

        public mangaHolder(@NonNull View itemView , OnItemClickListener listener) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.gambar_list);
            name = itemView.findViewById(R.id.item_name);
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






