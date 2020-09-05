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


public class Mechanical extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<StaffModel> list;
    public Mechanical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_mechanical, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.merecycle);
        recyclerView.hasFixedSize();
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        ImageView mehod=(ImageView)view.findViewById(R.id.mehodimage);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55759835_107465367097414_6297851777534394368_o.jpg?_nc_cat=100&_nc_ht=scontent.fblr4-2.fna&oh=6cbb7c8e0daadc2f73b4f730d7729e30&oe=5D02C5DD").into(mehod);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new StaffModel("Mr. Vinay L","B.E , M.Tech","Asst. Professor","vinoo.mce@gmail.com","9741519722","http://www.rithassan.org/staffpic/ME/Vinay.jpg"));
        list.add(new StaffModel("Mr. Hanoca P","B.E , M.Tech","Asst. Professor","hanocap_87@yahoo.co.in","9742019528","http://www.rithassan.org/staffpic/ME/Hanoca.jpg"));
        list.add(new StaffModel("Mr. Anand H R","B.E , M.Tech","Asst. Professor","aanandahr@gmail.com","9844060180","http://www.rithassan.org/staffpic/ME/Anand.jpg"));
        list.add(new StaffModel("Mr. Shivaprakash B C","B.E , M.Tech","Asst. Professor","bcshivaprakash@gmail.com","9986673598","http://www.rithassan.org/staffpic/ME/Shivaprakash.jpg"));
        list.add(new StaffModel("Mr. Pavan Kumar K K","B.E , M.Tech","Asst. Professor","kkpavankumar1987@gmail.com","9986720547","http://www.rithassan.org/staffpic/ME/Pavan.jpg"));
        list.add(new StaffModel("Mr. Karthik G C","B.E , M.Tech","Asst. Professor","karthikgc07@gmail.com","7411488258","http://www.rithassan.org/staffpic/ME/Karthik.jpg"));
        list.add(new StaffModel("Mr. K T Rajeev","B.E , M.Tech","Asst. Professor","rajeevkt.hsn@gmail.com","9972297239","http://www.rithassan.org/staffpic/ME/Rajeev.jpg"));
        list.add(new StaffModel("Mr. Kuldeep B","B.E , M.Tech","Asst. Professor","kuldeepb.deep@gmail.com","9739333440","http://www.rithassan.org/staffpic/ME/Kuldeep.jpg"));
        list.add(new StaffModel("Mr. Kaushik","B.E , M.Tech","Asst. Professor","akkaushi@gmail.com","9740383107","http://www.rithassan.org/staffpic/ME/Kaushik.jpg"));
        list.add(new StaffModel("Mr. Krishna K S","B.E , M.Tech","Asst. Professor","krishks036@gmail.com","8497817586","http://www.rithassan.org/staffpic/ME/Krishna.jpg"));
        list.add(new StaffModel("Mr. Sagar H T","B.E , M.Tech","Asst. Professor","sagar.ht5@gmail.com","9964871015","http://www.rithassan.org/staffpic/ME/Sagar.jpg"));
        list.add(new StaffModel("Mr. Dharanesh O H","B.E , M.Tech","Asst. Professor","dharani070@gmail.com","9743650055","http://www.rithassan.org/staffpic/ME/Dharanesh.jpg"));
        list.add(new StaffModel("Mr. Murali A S","B.E , M.Tech","Asst. Professor","muruli.as@gmial.com","9746990642","http://www.rithassan.org/staffpic/ME/Muruli.jpg"));
        list.add(new StaffModel("Mr. Manohara H N","B.E , M.Tech","Asst. Professor","manu.hn1990@gmail.com","9964676423","http://www.rithassan.org/staffpic/ME/Manohara.jpg"));
        list.add(new StaffModel("Mr. Sunil Kuamr G","B.E , M.Tech","Asst. Professor","suniajp@gmail.com","9844254250","http://www.rithassan.org/staffpic/ME/Sunilg.jpg"));
        list.add(new StaffModel("Dr. Gopi K R","B.E , M.Tech , Ph.D","Associate Professor","nitkgopi@gmail.com","9916666873","http://www.rithassan.org/staffpic/ME/Gopi.jpg"));
        list.add(new StaffModel("Mr. Chandan L","B.E , M.Tech","Asst. Professor","chandanmanavi@gmail.com","9620888705","http://www.rithassan.org/staffpic/ME/Chandan.jpg"));
        list.add(new StaffModel("Mr. H N Narasimhaprasad","B.E","Lecturer","hnnarasimhaprasad@rediffmail.com","9448772450","http://www.rithassan.org/staffpic/ME/Hnnp.jpg"));


    }


}
