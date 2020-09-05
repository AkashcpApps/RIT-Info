package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class CollegeAuthority extends Fragment {
    View view;

    public CollegeAuthority() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            view= inflater.inflate(R.layout.fragment_college_authority, container, false);
            ImageView principal = (ImageView) view.findViewById(R.id.imageprincial);
            ImageView viceprincipal = (ImageView) view.findViewById(R.id.imageviceprincial);
            Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55653280_107464860430798_2615569211350581248_o.jpg?_nc_cat=103&_nc_ht=scontent.fblr4-1.fna&oh=60ba90ed57e6b368339d12dce5da8dbe&oe=5D019F5C").into(principal);
            Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55759835_107465367097414_6297851777534394368_o.jpg?_nc_cat=100&_nc_ht=scontent.fblr4-2.fna&oh=6cbb7c8e0daadc2f73b4f730d7729e30&oe=5D02C5DD").into(viceprincipal);

        } catch (Exception E) {
            E.printStackTrace();
            Toast.makeText(getContext(), E.getMessage(), Toast.LENGTH_LONG).show();
        }
            // Inflate the layout for this fragment
            return view;

    }


}
