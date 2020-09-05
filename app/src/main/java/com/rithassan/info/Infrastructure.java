package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Infrastructure extends Fragment {
View view;
ImageView image1,image2,image3,image4,image5;

    public Infrastructure() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_infrastructure, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        image4=(ImageView)view.findViewById(R.id.image4);
        image5=(ImageView)view.findViewById(R.id.image5);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55519524_106206630556621_2354408875899224064_o.jpg?_nc_cat=101&_nc_ht=scontent.fblr1-4.fna&oh=50d5f1bb425f7ef33c399be9e53f48c7&oe=5D03DC44").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/54518877_106206510556633_1626686182953844736_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr1-3.fna&oh=52d045eeb5f50ec715c5870c6b66a6eb&oe=5D0B7235").into(image2);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/54521678_106206490556635_2373138936219303936_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr1-3.fna&oh=64b8b05835853f60dc32ae240d33aac7&oe=5D0E4EF4").into(image3);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/54730025_106207503889867_2499162313295134720_o.jpg?_nc_cat=110&_nc_ht=scontent.fblr1-4.fna&oh=363c015e1ba5eb7778eaebb8ceb6369a&oe=5D0D30AA").into(image4);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55602683_106207130556571_3041962474891902976_o.jpg?_nc_cat=110&_nc_ht=scontent.fblr1-4.fna&oh=d40293fadc51e1f3f0943c2d18db5e7b&oe=5D0E0D33").into(image5);
        return view;
    }

}
