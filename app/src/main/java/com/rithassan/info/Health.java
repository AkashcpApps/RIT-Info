package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Health extends Fragment {
    View view;
    ImageView image1,image2,image3;
    public Health() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_health, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55726113_110481786795772_3641288211445055488_o.jpg?_nc_cat=103&_nc_ht=scontent.fblr1-3.fna&oh=813585c3a5967cab8d88dd2f55c3bae7&oe=5D49E011").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55441087_110481743462443_1670573090792275968_o.jpg?_nc_cat=100&_nc_ht=scontent.fblr1-3.fna&oh=474025200ab845a4b510a382dce0b3ad&oe=5D15231C").into(image2);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55619262_110481763462441_5180751678860689408_o.jpg?_nc_cat=107&_nc_ht=scontent.fblr1-3.fna&oh=0fabafa3b5b83f686aa34d48265fc01b&oe=5D41ADED").into(image3);


        return view;
    }

}
