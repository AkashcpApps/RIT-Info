package com.rithassan.info;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;


public class Developer extends Fragment {
    View view;
    TextView text2,text3,text4,text5,text6,text7,text9,text10,text8;

    CircleImageView adi,aks;
    public Developer() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        view= inflater.inflate(R.layout.fragment_developer, container, false);
        text2=(TextView)view.findViewById(R.id.text2);
        text3=(TextView)view.findViewById(R.id.text3);
        text4=(TextView)view.findViewById(R.id.text4);
        int year= Calendar.getInstance().get(Calendar.YEAR);
        String strI = Integer.toString(year);
        text5=(TextView)view.findViewById(R.id.text5);
        text6=(TextView)view.findViewById(R.id.text6);
        text7=(TextView)view.findViewById(R.id.text7);
        text9=(TextView)view.findViewById(R.id.text9);
        text8=(TextView)view.findViewById(R.id.text8);
        text9.setText(strI);
        text10=(TextView)view.findViewById(R.id.text10);
        adi=(CircleImageView)view.findViewById(R.id.image2);
        aks=(CircleImageView)view.findViewById(R.id.image1);


        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/akash_cp_gowda");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/akash_cp_gowda")));
            }
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"akashcpgowda002@gmail.com"});
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Send Mail"));

            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9113271911"));
                startActivity(intent);
            }
        });
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/adithyashetty24");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/adithyashetty24")));
                }
            }
        });
        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"adithyashetty24@gmail.com"});
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Send Maill"));

            }
        });
        text7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9590774259"));
                startActivity(intent);
            }
        });

        Glide.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-1/c0.2.240.240a/p240x240/39979417_1127526277413435_3193860032038961152_n.jpg?_nc_cat=102&_nc_ht=scontent.fblr1-3.fna&oh=170fa89dd2140667d7d94423c205f24c&oe=5D17F650").into(adi);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/48385518_1157245757784972_390286585880379392_n.jpg?_nc_cat=110&_nc_ht=scontent.fblr1-4.fna&oh=7e03db42ac62d09d501e09ba927e1278&oe=5CE0C387").into(aks);













        return view;

    }


}
