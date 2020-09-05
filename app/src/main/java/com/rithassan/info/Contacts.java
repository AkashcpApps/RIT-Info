package com.rithassan.info;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class Contacts extends Fragment {
View view;
    ImageView map,call,mail,web,trust;
    RecyclerView recyclerView;
    List<ContactsModel> list;

    private static final int Request_Call = 1;



    public Contacts() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_contacts, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.contactsrecyclerview);
        ContactsAdapter iconAdapter=new ContactsAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);



        map=(ImageView)view.findViewById(R.id.googlemap);
        call=(ImageView)view.findViewById(R.id.callus);
        web=(ImageView)view.findViewById(R.id.web);
        mail=(ImageView)view.findViewById(R.id.mail);
        trust=(ImageView)view.findViewById(R.id.trust);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = openmap(getActivity());
                startActivity(map);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.rithassan.org/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ritinfohassan@gmail.com"});


                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose App to Send Mail"));
            }

        });
        trust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.rajeevedu.in/";
                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse(url));
                startActivity(j);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:08172243181"));
                startActivity(intent);

            }
        });
        return view;
    }
    public static Intent openmap(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.googleandroid.gms,maps", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.co.in/maps/place/Rajeev+Institute+of+Technology/@12.990366,76.113074,974m/data=!3m2!1e3!4b1!4m5!3m4!1s0x3ba548717858327b:0xa6f0a82b850aa687!8m2!3d12.990366!4d76.115268?hl=en"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.co.in/maps/place/Rajeev+Institute+of+Technology/@12.990366,76.113074,974m/data=!3m2!1e3!4b1!4m5!3m4!1s0x3ba548717858327b:0xa6f0a82b850aa687!8m2!3d12.990366!4d76.115268?hl=en"));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new ContactsModel("Help Desk","Reception","ritinfohassan@gmail.com","(08172)-243180"));
        list.add(new ContactsModel("Dr A N Ramakrishna","Principal","rithsnprincipal@gmail.com","9845792787"));
        list.add(new ContactsModel("Dr Dhananjaya D A","Vice Principal","dhananjayada@rediffmail.com","9986121677"));
        list.add(new ContactsModel("Jaga","Boys Hostel Warden","jaggujaga32@gmail.com","9590222400"));
        list.add(new ContactsModel("Jaya Lakshmi","Girls Hostel Warden","jayalakshmid3006@gmail.com","9164572674"));
        list.add(new ContactsModel("Mr Umesh B D","Physical Education Director","umeshbd@gmail.com","966374172"));


    }
}
