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


public class Electronics extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<StaffModel> list;
    public Electronics() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_electronics, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.ecrecycle);
        recyclerView.hasFixedSize();
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        ImageView echod=(ImageView) view.findViewById(R.id.echodimage);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55541949_107464450430839_2890405826478997504_n.jpg?_nc_cat=110&_nc_ht=scontent.fblr4-1.fna&oh=2b10847af0297bfa804e25361ec7d463&oe=5D4DC770").into(echod);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new StaffModel("Mrs. Ambika K","B.E , M.Tech","Asst. Professor","ambika.hsn@gmail.com","9845661755","http://www.rithassan.org/staffpic/EC/Ambika.jpg"));
        list.add(new StaffModel("Mrs. Rekha M G","B.E , M.Tech","Asst. Professor","rekhamg.rit@gmail.com","9448590713","http://www.rithassan.org/staffpic/EC/Rekha.jpg"));
        list.add(new StaffModel("Mr. Vishwanath B R","B.E , M.Tech","Asst. Professor","vishwa_br@yahoo.co.in","9886117222","http://www.rithassan.org/staffpic/EC/Vishwanath.jpg"));
        list.add(new StaffModel("Mr. Ravikiran H K","B.E , M.Tech","Asst. Professor","ravikiranhsn@gmail.com","9986889217","http://www.rithassan.org/staffpic/EC/Ravikiran.jpg"));
        list.add(new StaffModel("Mr. Ravi L S","B.E , M.Tech","Asst. Professor","ravigowda1234@gmail.com","9738271329","http://www.rithassan.org/staffpic/EC/Ravils.jpg"));
        list.add(new StaffModel("Ms. Yogeshwary B H","B.E , M.Tech","Asst. Professor","yogeshwary2@gmail.com","9741709922","http://www.rithassan.org/staffpic/EC/Yogeshwari.jpg"));
        list.add(new StaffModel("Mr. Rohith P","B.E , M.Tech","Asst. Professor","rohithgowda1985@gmail.com","9880441413","http://www.rithassan.org/staffpic/EC/Rohith.jpg"));
        list.add(new StaffModel("Mr. Yashwanth N","B.E , M.Tech","Asst. Professor","yashwanthrithsn@gmail.com","9743198293","http://www.rithassan.org/staffpic/EC/Yashwanth.jpg"));
        list.add(new StaffModel("Ms. Manasa A","B.E , M.Tech","Asst. Professor","manasasupriya89@gmail.com","9620328868","http://www.rithassan.org/staffpic/EC/Manasa.jpg"));
        list.add(new StaffModel("Ms. Lokeshwari H S","B.E , M.Tech","Asst. Professor","lokesgwarigowda@gmail.com","9164394086","http://www.rithassan.org/staffpic/EC/Lokeshwari.jpg"));
        list.add(new StaffModel("Ms. Shalini I S","B.E , M.Tech","Asst. Professor","shaliniisgowda@gmail.com","9739056036","http://www.rithassan.org/staffpic/EC/Shalini.jpg"));
        list.add(new StaffModel("Ms. Yashaswini P R","B.E , M.Tech","Asst. Professor","yashupr1992@gmail.com","9483822111","http://www.rithassan.org/staffpic/EC/Yashaswini.jpg"));


    }


}
