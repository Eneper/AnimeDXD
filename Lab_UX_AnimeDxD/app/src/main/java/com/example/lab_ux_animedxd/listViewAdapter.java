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

    public listViewAdapter(Context context, List<isiList> gambar) {
        this.context = context;
        this.gambar = gambar;
    }

    @NonNull
    @Override
    public listHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent , false);

        return new listHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listHolder holder, int position) {
        isiList isi = gambar.get(position);
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

    static class listHolder extends RecyclerView.ViewHolder{

        ImageView imgCover;

        TextView name , desc;

        public listHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.gambar_list);
            name = itemView.findViewById(R.id.item_name);
            desc = itemView.findViewById(R.id.item_desc);
        }
    }

}
