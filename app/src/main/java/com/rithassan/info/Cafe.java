package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Cafe extends Fragment {

    View view;
    ImageView image1,image2,image3;
    public Cafe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cafe, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
       image2=(ImageView)view.findViewById(R.id.image2);
       // image3=(ImageView)view.findViewById(R.id.image3);

        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55730955_106207537223197_6282328588905611264_o.jpg?_nc_cat=107&_nc_ht=scontent.fblr4-2.fna&oh=0a7cf1b735db612b1695b9b2327dc77a&oe=5D162B35").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/54799864_107475657096385_7112684352932151296_o.jpg?_nc_cat=108&_nc_ht=scontent.fblr4-2.fna&oh=a0d200d86bd10dcb4d43e7a405379572&oe=5D03FCA9").into(image2);

        return view;
    }


}
