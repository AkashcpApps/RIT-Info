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

public class Mba extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<StaffModel> list;

    public Mba() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_mba, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.mbarecycle);
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(false);
        ImageView mbshaod=(ImageView) view.findViewById(R.id.mbahodimage);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54728474_107464930430791_5436577231138717696_o.jpg?_nc_cat=102&_nc_ht=scontent.fblr4-1.fna&oh=11f248735cb2e2b114abf140a7e91efe&oe=5D500CDD").into(mbshaod);
        return view;


    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new StaffModel("Mr. Mohammed Monish","B.B.M , M.B.A","Asst. Professor","mohammedmonish313@gmail.com","9964106076","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fmohommad_mba.PNG?alt=media&token=443d9e73-a2ad-4240-a945-7375170deeef"));
        list.add(new StaffModel("Ms. Priya H V","B.B.M , M.B.A","Asst. Professor","ppriya574@gmail.com","8861364365","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fpriya_mba.PNG?alt=media&token=a0cbe122-e269-4e39-9fc9-39c3cd27f903"));
        list.add(new StaffModel("Mr. Darshan N M","B.B.M , M.B.A","Asst. Professor","darshannm.hsn@gmail.com","8147111396","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fdarshan_mba.PNG?alt=media&token=41962e36-aaff-426b-892f-1a0189c08435"));
        list.add(new StaffModel("Ms. Yogashree C","B.B.M , M.B.A","Asst. Professor","gowdayogashree@rediffmail.com","9743004845","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fyogashree_mba.PNG?alt=media&token=4a795a76-b543-4ac9-80bf-3a6b9d3be00f"));
        list.add(new StaffModel("Ms. Aysha Zeba","B.Com , M.B.A","Asst. Professor","ayshazeba78@gmail.com","8861564800","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fayesha_mba.jpg?alt=media&token=81f3059d-afd7-41c9-ade9-b7d3e7455ff0"));





    }


}
