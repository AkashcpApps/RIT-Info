package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Misclaneous extends Fragment {

View view;
    public Misclaneous() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_misclaneous, container, false);
        ImageView phhods= (ImageView) view.findViewById(R.id.phhod);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55514091_107465430430741_3151449098301734912_o.jpg?_nc_cat=105&_nc_ht=scontent.fblr1-4.fna&oh=e0758a17860de0d97f65fa571866f466&oe=5D07F738").into(phhods);

        return view;

    }


}
