package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StudentInfo extends Fragment {
    private static final String[] TABLE_HEADERS = { "Subject Code", "Marks" ,"Attendence"};
    View view;
    public static final String[][] TAB_1 = {};
    public StudentInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_student_info, container, false);

        return view;
    }


}
