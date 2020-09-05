package com.rithassan.info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class EventCalender extends Fragment {
View view;
PhotoView calenderphotoView;
FirebaseDatabase firebaseDatabase;
DatabaseReference myref;

    public EventCalender() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_event_calender, container, false);

        calenderphotoView=(PhotoView)view.findViewById(R.id.events_calender_image);
        firebaseDatabase=FirebaseDatabase.getInstance();
        myref=firebaseDatabase.getReference("calender");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String calender = dataSnapshot.getValue(String.class);
                Picasso.with(getContext()).load(calender).into(calenderphotoView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        return view;
    }
}
