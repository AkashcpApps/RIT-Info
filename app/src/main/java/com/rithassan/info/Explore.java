package com.rithassan.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Explore extends Fragment {
    View view;
RecyclerView recyclerView;
List<IconModel> list;
    public Explore() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.explorerecyclerview);
        IconAdapter iconAdapter=new IconAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);




        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new IconModel("The Institution",R.drawable.icon_institution));
        list.add(new IconModel("Mission",R.drawable.icon_mission));
        list.add(new IconModel("Facilities",R.drawable.icon_facilities));
        list.add(new IconModel("President",R.drawable.icon_president));
        list.add(new IconModel("College Authority",R.drawable.icon_authority));
        list.add(new IconModel("Departments",R.drawable.icon_courses));
        list.add(new IconModel("Governing Council",R.drawable.icon_govt));
        list.add(new IconModel("Milestone",R.drawable.icon_milestone));
        list.add(new IconModel("Clubs",R.drawable.icon_clubs));



    }
}
