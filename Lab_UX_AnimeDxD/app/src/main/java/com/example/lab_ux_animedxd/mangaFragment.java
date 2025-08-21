package com.example.lab_ux_animedxd;

import android.os.Bundle;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link mangaFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class mangaFragment extends Fragment{

    RecyclerView recyclerView;

    mangaViewAdapter adapter;

    List<isiManga> isiMangas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manga, container, false);
        recyclerView = view.findViewById(R.id.haList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        isiMangas = new ArrayList<>();
        isiMangas.add(new isiManga("Wind Breaker" , "\n" +
                "Jay Jo, a quiet honor student, is secretly a top-notch street bike racer. Along with the Hummingbird Crew, he pursues freedom and speed, facing challenges on the streets and in life.", R.drawable.windbreakerwebtoon) );
        isiMangas.add(new isiManga("Weak Hero" , "Weak Hero is a story of revenge, justice, and survival in a brutal world, where true strength isn't always about muscle, but about courage and intelligence.", R.drawable.weakhero) );
        isiMangas.add(new isiManga("Hero Ticket" , "A world where power can be bought, and lives are risked for the sake of being a \"hero.\" For Jaeha Jung, a hero's ticket isn't just a chance… but a path to truth and revenge.", R.drawable.heroticket) );
        isiMangas.add(new isiManga("Sakamoto Days" , "\n" +
                "A former legendary assassin now lives a peaceful life… until the past comes knocking at the door. Now, with apron and gun, Taro Sakamoto is back in action — for his family.", R.drawable.sakamoto) );
        isiMangas.add(new isiManga("One Piece" , "Monkey D. Luffy sets sail to become the Pirate King and find the legendary treasure, One Piece. Along with the Straw Hat Pirates, he explores a sea full of dangers, secrets, and big dreams.", R.drawable.onepiece) );


        adapter = new mangaViewAdapter(getContext(), isiMangas);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

    }

}







