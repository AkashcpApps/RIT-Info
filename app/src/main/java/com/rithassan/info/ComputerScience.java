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

public class ComputerScience extends Fragment {
View view;
RecyclerView recyclerView;
List<StaffModel> list;
    public ComputerScience() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_computer_science, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.csrecycle);
        recyclerView.hasFixedSize();
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        ImageView cshod=(ImageView)view.findViewById(R.id.cshodimage);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55519540_107464547097496_7692878578572066816_o.jpg?_nc_cat=111&_nc_ht=scontent.fblr4-2.fna&oh=00468f12b244741ac1fd0e25c1cc2bf2&oe=5D46391D").into(cshod);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
     list.add(new StaffModel("Mr. Prapulla Kumar M S","B.E , M.Tech","Asst. Professor","prapulla.kumar@gmail.com","9844990268","http://www.rithassan.org/staffpic/CS/Prapulla.jpg"));
        list.add(new StaffModel("Mr. Ravi Kumar","B.E , M.Tech","Asst. Professor","ravikumarrit@gmail.com","9741970005","http://www.rithassan.org/staffpic/CS/Ravikumar.jpg"));
        list.add(new StaffModel("Dr. Pramod H B","B.E , M.Tech , PhD","Associate Professor","hbpramod@gmail.com","9844404014","http://www.rithassan.org/staffpic/CS/Pramodhb.jpg"));
        list.add(new StaffModel("Mrs. Shruthi K R","B.E , M.Tech","Asst. Professor","shruthiram12@gmail.com","9611247880","http://www.rithassan.org/staffpic/CS/Shruthi.jpg"));
        list.add(new StaffModel("Mr. Sharath M N","B.E , M.Tech","Asst. Professor","sharathmn64@gmail.com","7760534881","http://www.rithassan.org/staffpic/CS/Sharath.jpg"));
        list.add(new StaffModel("Ms. Shashikala M K","B.E , M.Tech","Asst. Professor","shashimk6@gmail.com","9741180734","http://www.rithassan.org/staffpic/CS/Shashikala.jpg"));
        list.add(new StaffModel("Mr. Gowtham M","B.E , M.Tech","Asst. Professor","gouthamgouda@gmail.com","8088007371","http://www.rithassan.org/staffpic/CS/Gowtham.jpg"));
        list.add(new StaffModel("Mrs. Sangeetha S","B.E , M.Tech","Asst. Professor","sangmtech@gmail.com","9538341938","http://www.rithassan.org/staffpic/CS/Sangeetha.jpg"));
        list.add(new StaffModel("Mr. Sumanth C M","B.E , M.Tech , MISTE","Asst. Professor","sumanthcm4@gmail.com","7899561166","http://www.rithassan.org/staffpic/CS/Sumanth.jpg"));
        list.add(new StaffModel("Mrs. Umme Sadiya","B.E , M.Tech","Asst. Professor","sadiyakhan55@gmail.com","8904581989","http://www.rithassan.org/staffpic/CS/Umme.jpg"));
        list.add(new StaffModel("Ms. Renuka Chalavadi","B.E , M.Tech","Asst. Professor","crenu034@gmail.com","8050099976","http://www.rithassan.org/staffpic/CS/Renuka.jpg"));
        list.add(new StaffModel("Mr. Dhruva M S","B.E , M.Tech","Asst. Professor","msdhruva@gmail.com","8095425779","http://www.rithassan.org/staffpic/CS/Dhruva.jpg"));
        list.add(new StaffModel("Ms. Pruthvi Pournami","B.E , M.Tech","Asst. Professor","pruthvi.pournami@gmail.com","8722566017","http://www.rithassan.org/staffpic/CS/Pruthvi.jpg"));
        list.add(new StaffModel("Mr. Vishwas D B","B.E , M.Tech","Asst. Professor","vishwasdb91@gmail.com","7795590379","http://www.rithassan.org/staffpic/CS/Vishwas.jpg"));
        list.add(new StaffModel("Ms. Raksha R S","B.E , M.Tech","Asst. Professor","rakshashankar93@gmail.com","9480099007","http://www.rithassan.org/staffpic/CS/Raksha.jpg"));



    }


}
