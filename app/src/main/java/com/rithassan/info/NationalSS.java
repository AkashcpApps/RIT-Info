package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class NationalSS extends Fragment {
    View view;
    ImageView image1,image2,image3,image4,image5;
    public NationalSS() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_national_s, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        image4=(ImageView)view.findViewById(R.id.image4);
        image5=(ImageView)view.findViewById(R.id.image5);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/56161640_110482510129033_2014858764456296448_o.jpg?_nc_cat=110&_nc_ht=scontent.fblr1-4.fna&oh=61ee884d180fdb2cb153274fa45db202&oe=5D0F1C87").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55730950_110482493462368_327499790420017152_o.jpg?_nc_cat=104&_nc_ht=scontent.fblr1-4.fna&oh=bd540c36c34a45304809362527166937&oe=5D4ACD51").into(image2);

        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55713766_110482373462380_376794998386982912_o.jpg?_nc_cat=105&_nc_ht=scontent.fblr1-4.fna&oh=4a957a2f42d075662f8c825315cb814e&oe=5D029FE7").into(image3);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55719280_110482210129063_4305872213669576704_n.jpg?_nc_cat=104&_nc_ht=scontent.fblr1-4.fna&oh=3a91b3aacf8bef1cc7c6234707181a6e&oe=5D12AA15").into(image4);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55614006_110482306795720_6080013789355311104_o.jpg?_nc_cat=104&_nc_ht=scontent.fblr1-4.fna&oh=46d2aa486e6bac6e4f18311e86d61611&oe=5D4B3A90").into(image5);


        return view;
    }


}
