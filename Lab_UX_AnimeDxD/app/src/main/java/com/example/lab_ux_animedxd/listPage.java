package com.example.lab_ux_animedxd;

import android.os.Bundle;

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

public class listPage extends Fragment {

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
        isiLists.add(new isiList("Black Clover" , "Hai aku keren" , R.drawable.blackclover2) );
        isiLists.add(new isiList("Bochi The Rock" , "Hai aku pemain musik" , R.drawable.bochi) );
        isiLists.add(new isiList("Black Clover" , "Hai aku keren" , R.drawable.eliteclassroom) );
        isiLists.add(new isiList("Black Clover" , "Hai aku keren" , R.drawable.blackclover2) );
        isiLists.add(new isiList("Black Clover" , "Hai aku keren" , R.drawable.blackclover2) );
        isiLists.add(new isiList("Black Clover" , "Hai aku keren" , R.drawable.blackclover2) );

        adapter = new listViewAdapter(getContext(), isiLists);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);


    }
}