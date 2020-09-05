package com.rithassan.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Courses extends Fragment {
View view;
    RecyclerView recyclerView;
    List<CourseModel> list;
    public Courses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_courses, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.courserecyclerview);
        CourseAdapter iconAdapter=new CourseAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(iconAdapter);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new CourseModel("Computer Science and Engineering",R.drawable.mini_computer_science));
        list.add(new CourseModel("Civil Engineering",R.drawable.mini_civil));
        list.add(new CourseModel("Electronics and Communication Engineering ",R.drawable.mini_electronics));
        list.add(new CourseModel("Electrical Engineering",R.drawable.mini_electrical));
        list.add(new CourseModel("Information Science and Engineering",R.drawable.mini_information_science));
        list.add(new CourseModel("Mechanical Engineering",R.drawable.mini_mechanical));
        list.add(new CourseModel("Basic Science",R.drawable.mini_basic_science));
        list.add(new CourseModel("MBA",R.drawable.mini_mba));
        list.add(new CourseModel("Library and Information",R.drawable.mini_library_image));
        list.add(new CourseModel("Physical Education",R.drawable.mini_sports_image));
        list.add(new CourseModel("Supporting Staffs",R.drawable.mini_thermal));



    }

}
