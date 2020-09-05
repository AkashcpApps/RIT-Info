package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Institution extends Fragment {
  View view;

    public Institution() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_institution, container, false);
        ImageView collagephoto=(ImageView)view.findViewById(R.id.collagephoto);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54521794_106206913889926_6212291227224637440_o.jpg?_nc_cat=102&_nc_ht=scontent.fblr4-1.fna&oh=83c5b3d2d1ac2620323b3c620d4adb3f&oe=5D463279").into(collagephoto);
        return view;
    }


}
