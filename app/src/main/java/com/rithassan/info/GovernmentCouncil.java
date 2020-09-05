package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class GovernmentCouncil extends Fragment {
    View view;

    public GovernmentCouncil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_government_council, container, false);
        // Inflate the layout for this fragment
        CircleImageView rajeev=(CircleImageView)view.findViewById(R.id.rajeevimage);
        CircleImageView rathna=(CircleImageView)view.findViewById(R.id.ratnaimage);

        CircleImageView ranjith=(CircleImageView)view.findViewById(R.id.ranjitimage);

        CircleImageView rachana=(CircleImageView)view.findViewById(R.id.rachanaimage);
        CircleImageView imageprince=(CircleImageView)view.findViewById(R.id.imageprincipal);
        CircleImageView dhana=(CircleImageView)view.findViewById(R.id.vpimage);
        CircleImageView cshod=(CircleImageView)view.findViewById(R.id.cshodimage);

        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54522773_107454897098461_8329836977486561280_n.jpg?_nc_cat=109&_nc_ht=scontent.fblr4-1.fna&oh=e5c0be44fd666f6469039df2bc368146&oe=5D487D75").into(rajeev);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55892327_107454893765128_797324806935543808_n.jpg?_nc_cat=103&_nc_ht=scontent.fblr4-1.fna&oh=2fbdd93fbb91586973cc2ba97369f1c7&oe=5D451C91").into(rathna);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54728112_107454837098467_5510269863391657984_n.jpg?_nc_cat=102&_nc_ht=scontent.fblr4-1.fna&oh=9e81237e9e87b9ed95de25ec1a8f3c7a&oe=5D09766A").into(ranjith);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/54798508_107454960431788_2462594356146601984_n.jpg?_nc_cat=111&_nc_ht=scontent.fblr4-2.fna&oh=b302bfcd2d7406e6daea675fb3566501&oe=5D4F96AF").into(rachana);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55448571_107455097098441_2736929052806873088_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr4-1.fna&oh=ab65471d29cc299c8ff65de4df16deae&oe=5D05E437").into(imageprince);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55788430_107455120431772_4838544112237936640_n.jpg?_nc_cat=110&_nc_ht=scontent.fblr4-1.fna&oh=b5035d65476f57fa5e23f5988f519285&oe=5D49118D").into(dhana);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/54409162_107454913765126_1754250431086723072_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr4-2.fna&oh=62855fe1f38634529650c6f89236e05c&oe=5D05714B").into(cshod);

        return view;
    }


}
