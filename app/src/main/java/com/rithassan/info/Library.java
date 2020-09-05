package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Library extends Fragment {
    View view;
    ImageView image1,image2,image3,image4,image5;
    public Library() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_library, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55604861_107711230406161_538756690405752832_n.jpg?_nc_cat=103&_nc_ht=scontent.fblr1-3.fna&oh=e7f270087a019cb5d03c37292b61d6fa&oe=5D169308").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55509665_107711217072829_6157140080457678848_n.jpg?_nc_cat=108&_nc_ht=scontent.fblr1-4.fna&oh=12f8e38c4eb1b93e3c760f7edf13a0ac&oe=5D0360FC").into(image2);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/54728522_107711243739493_4420991974450921472_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr1-4.fna&oh=310435b804f8bdb5b1b7e26639fc8c33&oe=5D11DB02").into(image3);

        return view;
    }

}
