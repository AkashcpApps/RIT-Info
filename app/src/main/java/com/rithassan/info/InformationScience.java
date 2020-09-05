package com.rithassan.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class InformationScience extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    View view;
    RecyclerView recyclerView;
    List<StaffModel> list;
    public InformationScience() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_information_science, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.isrecycle);
        recyclerView.hasFixedSize();
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        ImageView ishod=(ImageView) view.findViewById(R.id.ishodimage);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/54436662_107464903764127_4824757288692613120_o.jpg?_nc_cat=106&_nc_ht=scontent.fblr1-3.fna&oh=52ed5cda000e13b791df296b13dfd2bd&oe=5D07B440").into(ishod);

        return view;    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new StaffModel("Mr. Bharath M B","B.E , M.Tech","Asst. Professor","partha.mb@gmail.com","8553129177","http://www.rithassan.org/staffpic/IS/bharath.jpg"));
        list.add(new StaffModel("Mrs. Harshitha S","B.E , M.Tech","Asst. Professor","harshis88@gmail.com","8050487592","http://www.rithassan.org/staffpic/IS/Harshitha.jpg"));
        list.add(new StaffModel("Mr. Anil Kumar K N","B.E , M.Tech","Asst. Professor","akanilgowda@gmail.com","9900481482","http://www.rithassan.org/staffpic/IS/anil.jpg"));
        list.add(new StaffModel("Mrs. Nalini H C","B.E , M.Tech","Asst. Professor","nalinihc@gmail.com","8123259561","http://www.rithassan.org/staffpic/IS/nalini.jpg"));
       // list.add(new StaffModel("Ms. Pooja B S","B.E , M.Tech","Asst. Professor","","","http://www.rithassan.org/staffpic/IS/Pooja.jpg"));
        list.add(new StaffModel("Ms. Rachana K","B.E , M.Tech","Asst. Professor","rachana.k26@gmail.com","8970044235","http://www.rithassan.org/staffpic/IS/rachana.jpg"));
       // list.add(new StaffModel("Ms. Swapna U C","B.E , M.Tech","Asst. Professor","","","http://www.rithassan.org/staffpic/IS/Swapna.jpg"));


    }


}
