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


public class Facilities extends Fragment {
  View view;
    RecyclerView recyclerView;
    List<FacilitiesModel> list;

    public Facilities() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_facilities, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.facilitiesrecyclerview);
        FacilityAdapter iconAdapter=new FacilityAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new FacilitiesModel("Infrastructure",R.drawable.mini_infrastructure));
        list.add(new FacilitiesModel("Laboratory and Workshop",R.drawable.mini_lab));
        list.add(new FacilitiesModel("Library",R.drawable.mini_library));
        list.add(new FacilitiesModel("Comfortable Stay",R.drawable.mini_hostel));
        list.add(new FacilitiesModel("Conveyance",R.drawable.mini_transport));
        list.add(new FacilitiesModel("Concern for Health",R.drawable.mini_medical));
        list.add(new FacilitiesModel("Cafeteria",R.drawable.mini_cafe));
        list.add(new FacilitiesModel("Extra Curricular Activities",R.drawable.mini_sports));
        list.add(new FacilitiesModel("National Service Scheme",R.drawable.icon_nss));




    }


}
