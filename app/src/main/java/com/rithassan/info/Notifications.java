package com.rithassan.info;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Notifications extends Fragment {
    View view;
    private static final int NOTIFICATION_ID = 1;
    private static final String NOTIFICATION_CHANNEL_ID="my_notification";
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    PendingIntent contentIntent;
    public Notifications() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.noticerecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Notice");

        return view;
    }

    @Override
    public void onStart() {

        super.onStart();
        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.notification_layout,
                        ViewHolder.class,
                        databaseReference
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                        viewHolder.setDetails(getContext(),model.getImage(),model.getTitle(),model.getDescription(),model.getTime(),model.getDate());


                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder=super.onCreateViewHolder(parent,viewType);
                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                String title=getItem(position).getTitle();
                                String images=getItem(position).getImage();
                                String desc=getItem(position).getDescription();
                                String link =getItem(position).getLink();
                                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                sharingIntent.setType("text/plain");
                                String shareBody ="RIT Hassan\nNotification\n"+title+"\n"+desc;
                                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Rajeev Institute of Technology!");
                                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                                startActivityForResult(Intent.createChooser(sharingIntent, "Share via"), 1);


                            }

                            @Override
                            public void onItemLongClick(View view, int position) {



                            }
                        });
                        return viewHolder;
                    }


                };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
