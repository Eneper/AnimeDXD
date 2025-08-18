package com.example.lab_ux_animedxd;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class listPage extends Fragment implements listViewAdapter.OnItemClickListener {

    RecyclerView recyclerView;

    listViewAdapter adapter;

    List<isiList> isiLists;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_page, container, false);
        recyclerView = view.findViewById(R.id.haList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        isiLists = new ArrayList<>();
        isiLists.add(new isiList("Attack on Titan" , "Action, Dark Fantasy, Tragedy" ," In a world surrounded by giant walls to protect against man-eating Titans, Eren Yeager joins the military for revenge after his mother's death. His journey uncovers a dark conspiracy behind the Titans' existence.", R.drawable.anime_aot, R.drawable.land_aot) );
        isiLists.add(new isiList("Death Note" , "Psychological Thriller, Mystery, Supernatural" ,"Light Yagami finds the Death Note and uses it to kill criminals. His actions trigger a tense cat-and-mouse game with a brilliant international detective named L, who tries to uncover his identity.", R.drawable.anime_deathnote, R.drawable.land_deathnote) );
        isiLists.add(new isiList("Fullmetal Alchemist" , "Action, Adventure, Fantasy, Steampunk" ,"After failing to revive their mother with forbidden alchemy, Edward and Alphonse Elric search for the Philosopher's Stone. Their quest uncovers a vast military conspiracy and the true origin of the stone.\n", R.drawable.anime_fullmetal, R.drawable.land_fullmetal) );
        isiLists.add(new isiList("Steins;Gate" , "Science Fiction, Psychological Thriller" ," Rintarou Okabe discovers that his modified microwave can send messages to the past. This discovery throws him into a dangerous conspiracy, forcing him to leap across timelines to save his friends.", R.drawable.anime_steins , R.drawable.land_steins) );
        isiLists.add(new isiList("Sakamoto Days" , "Action, Comedy" ,"Taro Sakamoto, the ultimate assassin, retired for a peaceful family life. Now overweight and running a convenience store, he must protect his new life from old enemies, all without breaking his promise to his wife: never kill again.", R.drawable.anime_sakamoto, R.drawable.land_sakamoto) );
        isiLists.add(new isiList("Mob Psycho 100" , "Action, Comedy, Supernatural" ," Shigeo \"Mob\" Kageyama is an incredibly powerful esper trying to live a normal life. He suppresses his emotions, but when they reach 100%, an unimaginable power is unleashed.", R.drawable.anime_mob , R.drawable.land_mob) );
        isiLists.add(new isiList("Vinland Saga" , "Action, Adventure, Historical Drama" ,"Thorfinn joins the mercenary group of Askeladd to get revenge for his father's death. His journey takes him into the war for the English throne, while exploring the meaning of a warrior's life.", R.drawable.anime_vinland , R.drawable.land_vinl) );
        isiLists.add(new isiList("Jujutsu kaisen" , "Action, Dark Fantasy, Supernatural" ," Yuji Itadori swallows a cursed talisman and becomes the vessel for Sukuna. He joins the Jujutsu High to fight against Cursed Spirits while being hunted, all to protect his loved ones from harm.", R.drawable.anime_jujutsu, R.drawable.land_jujutsu) );


        adapter = new listViewAdapter(getContext(), isiLists , this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

    }

    @Override
    public void onItemClick(int position) {
        isiList clickedItem = isiLists.get(position);

        DetailFragment detailFragment = DetailFragment.newInstance(
                clickedItem.getName(),
                clickedItem.getGenre(),
                clickedItem.getDescription(),
                clickedItem.getImageResourceId(),
                clickedItem.getlandImage()
        );

//        requireActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.activity_container, detailFragment)
//                // KRUSIAL: Baris ini memastikan fragment sebelumnya disimpan
//                .addToBackStack(null)
//                .commit();
        detailFragment.show(getParentFragmentManager(), "DetailFragmentDialog");
    }
}