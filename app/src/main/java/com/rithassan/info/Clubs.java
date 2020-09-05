package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;


public class Clubs extends Fragment {
    View v;
    ViewFlipper club;
    ImageView next,previous;

    public Clubs() {
        // Required empty public constructor
    }
    String clubs[]={"https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55480112_107660260411258_6035470344226078720_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr4-2.fna&oh=60e7363b8468f696462313bc45ee3d56&oe=5D1512D4", "https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/54524802_107660130411271_6030325123729326080_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr4-2.fna&oh=204b4ee3f54872568d12d046822020ff&oe=5D119784",
    "https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55901762_107660057077945_8930494463139119104_n.jpg?_nc_cat=111&_nc_ht=scontent.fblr4-2.fna&oh=6850914a464988efef9e287113276762&oe=5D4AF5C0",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55437916_107660120411272_6678995992949293056_n.jpg?_nc_cat=110&_nc_ht=scontent.fblr4-1.fna&oh=69e5364295e8107f3cc4fb352e8c8716&oe=5D19E79D",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55680133_107660240411260_7682100448337068032_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr4-1.fna&oh=d876b0430e5435c5623fbae8e9d470a2&oe=5D4FFF28",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55448553_107660220411262_1987110548419903488_n.jpg?_nc_cat=104&_nc_ht=scontent.fblr4-1.fna&oh=33ebbf5fd5ba7e32a188f3cad81408a1&oe=5D090A42",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55608064_107660080411276_7649760229361451008_n.jpg?_nc_cat=109&_nc_ht=scontent.fblr4-1.fna&oh=20ba88f8f63849c22bf9795ed0afd464&oe=5D4349EF"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_clubs, container, false);
        next=(ImageView)v.findViewById(R.id.righticon);
        previous=(ImageView)v.findViewById(R.id.lefticon);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                club.showNext();

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                club.showPrevious();

            }
        });
        club=(ViewFlipper)v.findViewById(R.id.clubsliderlayout);
        for (int i=0;i<clubs.length;i++){
            setImageInFlipr(clubs[i]);

        }

        return v;
    }
    private void setImageInFlipr(String s) {
        PhotoView image = new PhotoView(getContext());
        Glide.with(v).load(s).into(image);
        club.addView(image);
        club.setAutoStart(true);
        club.setFlipInterval(20000);;



    }


}