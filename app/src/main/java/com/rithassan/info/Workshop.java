package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Workshop extends Fragment {
    View view;
    ImageView image1,image2,image3,image4,image5;
    public Workshop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_workshop, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        image4=(ImageView)view.findViewById(R.id.image4);
        image5=(ImageView)view.findViewById(R.id.image5);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/54523219_107707113739906_7283085359334817792_o.jpg?_nc_cat=105&_nc_ht=scontent.fblr1-4.fna&oh=6f20c4ef93572466fbeda6d950d8a97e&oe=5D0F6CF4").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55807228_107706953739922_401106798204944384_n.jpg?_nc_cat=109&_nc_ht=scontent.fblr1-3.fna&oh=5aff801d571dc50c24ed19a7d1611362&oe=5D47648A").into(image2);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/54278057_107707100406574_3855455454285004800_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr1-3.fna&oh=eedfcb5b311f1c4051a95307f496b13c&oe=5D0612C4").into(image3);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55789972_107706917073259_6825605813994782720_n.jpg?_nc_cat=104&_nc_ht=scontent.fblr1-4.fna&oh=fe5f843c4f399f5cd98b879de61e3ed0&oe=5D499CA7").into(image4);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55669486_107706927073258_6682069282567749632_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr1-4.fna&oh=9727b01a26c4d4700997a725407de1f5&oe=5D01C1D1").into(image5);
        return view;
    }

}
