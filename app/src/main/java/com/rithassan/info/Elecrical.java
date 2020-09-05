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


public class Elecrical extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<StaffModel> list;
    public Elecrical() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_elecrical, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.eerecycle);
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(false);
        ImageView elehod=(ImageView) view.findViewById(R.id.elehodimage);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55591792_107465257097425_7041781499506458624_o.jpg?_nc_cat=107&_nc_ht=scontent.fblr4-2.fna&oh=e44225853e46259d190424b8ffc98c1e&oe=5D0762AB").into(elehod);


        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new StaffModel("Mrs. Mamatha H M","B.E , M.Tech","Asst. Professor","mamtha16hm@gmail.com","9844003642","http://www.rithassan.org/staffpic/EE/Mamatha.jpg"));
        list.add(new StaffModel("Mr. Manjunatha H M","B.E , M.Tech","Asst. Professor","manjunath.hm1986@gmail.com","9741677070","http://www.rithassan.org/staffpic/EE/Manjunath.jpg"));
        list.add(new StaffModel("Mr. Pramodh H K","M.E","Asst. Professor","pramodh.hk@gmail.com","9036285929","http://www.rithassan.org/staffpic/EE/Pramod.jpg"));
        list.add(new StaffModel("Mrs. Yogitha S K","B.E , M.Tech","Asst. Professor","yogithask89@gmail.com","7204798590","http://www.rithassan.org/staffpic/EE/Yogitha.jpg"));
        list.add(new StaffModel("Mrs. Sowmya G R","B.E , M.Tech","Asst. Professor","sowmyahsn123@gmail.com","9663300170","http://www.rithassan.org/staffpic/EE/Sowmya.jpg"));
        list.add(new StaffModel("Mr. Nagendraprasad H K","B.E , M.Tech","Asst. Professor","nagendraprasadhk@gmail.com","7795666046","http://www.rithassan.org/staffpic/EE/Nagendra.jpg"));
        list.add(new StaffModel("Ms. Tejaswini M N","B.E , M.Tech","Asst. Professor","thejuatheshi@gmail.com","7795444717","http://www.rithassan.org/staffpic/EE/Thejaswini.jpg"));
        list.add(new StaffModel("Mr. Arun H","B.E , M.Tech","Asst. Professor","itsarunaru@gmail.com","9738050225","http://www.rithassan.org/staffpic/EE/Arun.jpg"));




    }



}
