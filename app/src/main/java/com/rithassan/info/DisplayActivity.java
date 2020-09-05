package com.rithassan.info;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class DisplayActivity extends Fragment {
View view;
TextView title,description,link;
String t,d,i,k;
PhotoView image;
Button share;
    public DisplayActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_display, container, false);
        title=(TextView)view.findViewById(R.id.displaytitle);
        description=(TextView)view.findViewById(R.id.displaydescription);
        link=(TextView)view.findViewById(R.id.liink);

        image=(PhotoView) view.findViewById(R.id.displayimage);
        share=(Button) view.findViewById(R.id.sharecontent);
        t=getArguments().getString("title");
        d=getArguments().getString("description");
        i=getArguments().getString("image");
        k=getArguments().getString("link");
link.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(k));
        startActivity(i);
    }
});
        title.setText(t);
        description.setText(d);
        Glide.with(getContext()).load(i).into(image);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = t + "\n\n" + d+"\n "+k;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Rajeev Institute of Technology!");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivityForResult(Intent.createChooser(sharingIntent, "Share via"), 1);
            }
        });



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        t=getArguments().getString("title");
        d=getArguments().getString("description");
        i=getArguments().getString("image");
        k=getArguments().getString("link");
link.setText(k);
        title.setText(t);
        description.setText(d);
        Glide.with(getContext()).load(i).into(image);
    }
}
