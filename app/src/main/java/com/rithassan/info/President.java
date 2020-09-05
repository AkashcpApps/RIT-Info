package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class President extends Fragment {
    View view;

    public President() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_president, container, false);
        // Inflate the layout for this fragment
        ImageView rajeev=(ImageView) view.findViewById(R.id.rajeevimage);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54524023_107464667097484_266794241622016000_o.jpg?_nc_cat=110&_nc_ht=scontent.fblr4-1.fna&oh=ed08e923ca36a33ac42056ccdc3ab152&oe=5D458177").into(rajeev);
        return view;
    }

}
