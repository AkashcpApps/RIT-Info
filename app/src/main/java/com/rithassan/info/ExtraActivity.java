package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ExtraActivity extends Fragment {

    View view;
    ImageView image1,image2,image3,image4,image5;
    public ExtraActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_extra, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        image4=(ImageView)view.findViewById(R.id.image4);
        image5=(ImageView)view.findViewById(R.id.image5);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55961859_110495366794414_5025687360721911808_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr4-2.fna&oh=1afcec4bdf5bda19ff99f51eadf8840d&oe=5D0F59FA").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55478017_110495246794426_8250045075061473280_n.jpg?_nc_cat=103&_nc_ht=scontent.fblr4-1.fna&oh=1fe65cb29f1411929ce65c1005840cd8&oe=5D103C60").into(image2);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55686926_110500040127280_3494722967865131008_n.jpg?_nc_cat=100&_nc_ht=scontent.fblr4-2.fna&oh=0b1060f154e5bb3d4d8b5c592e9a3d11&oe=5D057545").into(image3);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54349978_110500206793930_7121829583845851136_n.jpg?_nc_cat=104&_nc_ht=scontent.fblr4-1.fna&oh=0b738fca531cc75cfbf6f8ae01642b1b&oe=5D472D88").into(image4);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55480179_110500396793911_4877358144008749056_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr4-1.fna&oh=a604cedab48d62058ece7d8dec9d1660&oe=5D4E0C43").into(image5);


        return view;
    }


}
