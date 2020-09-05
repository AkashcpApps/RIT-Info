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


public class Mtech extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<StaffModel> list;
    public Mtech() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_mtech, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.librecycle);
        recyclerView.hasFixedSize();
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        ImageView libhod=(ImageView) view.findViewById(R.id.libhod);
        Picasso.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55600721_107465197097431_2206807772106850304_o.jpg?_nc_cat=107&_nc_ht=scontent.fblr1-3.fna&oh=3b09f69ec0462ab233c8d9374cdd2972&oe=5D43B6CA").into(libhod);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new StaffModel("Mr. Manjunatha C K","B.A , M.L.I.Sc","Asst. Librarian","kavanavar@gmail.com","984462609","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fmanjunath_library.PNG?alt=media&token=5a18aeb8-7507-402f-aebc-b2a9d82be41b"));
        list.add(new StaffModel("Mr. Kanthraj K G","B.A , Dipl. in Lib and IS","Library Assistant","","8546801518","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fkanthraj_library.PNG?alt=media&token=7528c8d2-3121-4d55-af45-d3cff263ae87"));



    }

}
