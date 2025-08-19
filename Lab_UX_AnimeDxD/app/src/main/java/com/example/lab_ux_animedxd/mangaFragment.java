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
        isiMangas.add(new isiManga("Attack on Titan" , " In a world surrounded by giant walls to protect against man-eating Titans, Eren Yeager joins the military for revenge after his mother's death. His journey uncovers a dark conspiracy behind the Titans' existence.", R.drawable.anime_aot) );
        isiMangas.add(new isiManga("Death Note" , "Light Yagami finds the Death Note and uses it to kill criminals. His actions trigger a tense cat-and-mouse game with a brilliant international detective named L, who tries to uncover his identity.", R.drawable.anime_deathnote) );
        isiMangas.add(new isiManga("Fullmetal Alchemist" , "After failing to revive their mother with forbidden alchemy, Edward and Alphonse Elric search for the Philosopher's Stone. Their quest uncovers a vast military conspiracy and the true origin of the stone.\n", R.drawable.anime_fullmetal) );
        isiMangas.add(new isiManga("Steins;Gate" , " Rintarou Okabe discovers that his modified microwave can send messages to the past. This discovery throws him into a dangerous conspiracy, forcing him to leap across timelines to save his friends.", R.drawable.anime_steins) );
        isiMangas.add(new isiManga("Sakamoto Days" , "Taro Sakamoto, the ultimate assassin, retired for a peaceful family life. Now overweight and running a convenience store, he must protect his new life from old enemies, all without breaking his promise to his wife: never kill again.", R.drawable.anime_sakamoto) );
        isiMangas.add(new isiManga("Mob Psycho 100" , " Shigeo \"Mob\" Kageyama is an incredibly powerful esper trying to live a normal life. He suppresses his emotions, but when they reach 100%, an unimaginable power is unleashed.", R.drawable.anime_mob) );
        isiMangas.add(new isiManga("Vinland Saga" , "Thorfinn joins the mercenary group of Askeladd to get revenge for his father's death. His journey takes him into the war for the English throne, while exploring the meaning of a warrior's life.", R.drawable.anime_vinland) );
        isiMangas.add(new isiManga("Jujutsu kaisen" , " Yuji Itadori swallows a cursed talisman and becomes the vessel for Sukuna. He joins the Jujutsu High to fight against Cursed Spirits while being hunted, all to protect his loved ones from harm.", R.drawable.anime_jujutsu) );


        adapter = new mangaViewAdapter(getContext(), isiMangas);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

    }

}







