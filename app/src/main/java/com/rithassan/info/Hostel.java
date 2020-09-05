package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Hostel extends Fragment {
    View view;
    ImageView image1,image2,image3,image4,image5;
    public Hostel() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_hostel, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        image4=(ImageView)view.findViewById(R.id.image4);
        image5=(ImageView)view.findViewById(R.id.image5);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55719324_107725230404761_4394774377384640512_o.jpg?_nc_cat=103&_nc_ht=scontent.fblr1-3.fna&oh=52d85a9d8d815de1348e9397c012580a&oe=5D4C7F5F").into(image1);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/54279041_107725113738106_6007695580996829184_o.jpg?_nc_cat=101&_nc_ht=scontent.fblr1-4.fna&oh=d0b443fd387d9d244fd0981e666d4793&oe=5D13034E").into(image2);
        Picasso.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55635133_107725123738105_4145857803988238336_o.jpg?_nc_cat=110&_nc_ht=scontent.fblr1-4.fna&oh=7dedb89f04ca8543490b1489651aaeb5&oe=5D4EE506").into(image3);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/54727812_107725103738107_251419405458604032_o.jpg?_nc_cat=106&_nc_ht=scontent.fblr1-3.fna&oh=aa681bdbc9c5729b55f5c7f89ba02a39&oe=5D49C37B").into(image4);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/54517826_107725157071435_5367687278560804864_o.jpg?_nc_cat=102&_nc_ht=scontent.fblr1-3.fna&oh=887f11d882251eafdc9f242c0cf64ad0&oe=5D0B7C7D").into(image5);

        return view;
    }


}
