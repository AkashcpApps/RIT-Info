package com.rithassan.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class BasicScience extends Fragment {
    View view;
    RecyclerView recyclerView1,recyclerView2,recyclerView3;
    List<StaffModel> list1,list2,list3;
    public BasicScience() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_basic_science, container, false);
        recyclerView1=(RecyclerView)view.findViewById(R.id.mathrecycle);
        recyclerView1.hasFixedSize();
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setAdapter(iconAdapter);
        recyclerView1.setNestedScrollingEnabled(false);


        recyclerView2=(RecyclerView)view.findViewById(R.id.chemistryrecycle);
        recyclerView2.hasFixedSize();
        StaffAdapter iconAdapter1=new StaffAdapter(getContext(),list2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setAdapter(iconAdapter1);
        recyclerView2.setNestedScrollingEnabled(false);

        recyclerView3=(RecyclerView)view.findViewById(R.id.physicsrecycle);
        recyclerView3.hasFixedSize();
        StaffAdapter iconAdapter2=new StaffAdapter(getContext(),list3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView3.setAdapter(iconAdapter2);
        recyclerView3.setNestedScrollingEnabled(false);
        ImageView chehod=(ImageView) view.findViewById(R.id.chehod);
        ImageView mathhod=(ImageView) view.findViewById(R.id.mathshosimage);
        ImageView phyhod=(ImageView) view.findViewById(R.id.phehod);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54798559_107465130430771_4862956126527815680_o.jpg?_nc_cat=104&_nc_ht=scontent.fblr4-1.fna&oh=89a6850fc3d93928408cfbe90cf28084&oe=5D505506").into(chehod);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/56157843_107465523764065_6002084133210161152_o.jpg?_nc_cat=102&_nc_ht=scontent.fblr4-1.fna&oh=369c98ce75df6ab25e581e75832eb571&oe=5D10A135").into(phyhod);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55788362_107465063764111_4606544431472967680_o.jpg?_nc_cat=103&_nc_ht=scontent.fblr4-1.fna&oh=f9e356c805c80a553d46922d73245e09&oe=5D12B17C").into(mathhod);



        return view;
    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list1=new ArrayList<>();
        list1.add(new StaffModel("Mr. Somshekar M","M.Sc","Asst. Professor","somamosquite@gmail.com","8453641899","http://www.rithassan.org/staffpic/BS/Somashekar.jpg"));
        list1.add(new StaffModel("Ms. Smitha M B","M.Sc. , B.Ed","Asst. Professor","smithamb89@gmail.com","8970240258","http://www.rithassan.org/staffpic/BS/Smitha.jpg"));
        list1.add(new StaffModel("Mr. Santhosh Kumar B B","M.Sc","Asst. Professor","santhubbsv@gmail.com","9964492177","http://www.rithassan.org/staffpic/BS/Santhosh.jpg"));
        list1.add(new StaffModel("Mrs. Mithuna H N","M.Sc","Asst. Professor","mithunaforever@gmail.com","9980777573","http://www.rithassan.org/staffpic/BS/Mithuna.jpg"));
        list2=new ArrayList<>();
        list2.add(new StaffModel("Mrs. Dhanalakshmi B","B.Ed , M.Sc","Asst. Professor","dhanb2010@gmail.com","9480720686","http://www.rithassan.org/staffpic/BS/Dhanalakshmi.jpg"));
        list3=new ArrayList<>();
        list3.add(new StaffModel("Mr. Ganesha D P","M.Sc","Asst. Professor","ganesha_dp@rediffmail.com","9164381325","http://www.rithassan.org/staffpic/BS/Ganesh.jpg"));
        list3.add(new StaffModel("Mrs. Sahana C P","M.Sc","Asst. Professor","sahana@gmail.com","7899990839","http://www.rithassan.org/staffpic/BS/Sahana.jpg"));



    }


}
