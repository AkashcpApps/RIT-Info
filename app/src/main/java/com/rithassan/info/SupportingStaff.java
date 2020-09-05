package com.rithassan.info;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SupportingStaff extends RecyclerView.Adapter<SupportingStaff.ViewHolder>  {
    Context mContext;

    public SupportingStaff(Context mContext, List<Model3> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    List<Model3> mdata;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.supporting_staff,viewGroup,false);
        ViewHolder viewHolder=new SupportingStaff.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SupportingStaff.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mdata.get(i).getName());
        viewHolder.desig.setText(mdata.get(i).getDesig());
        viewHolder.school.setText(mdata.get(i).getSchool());
        Glide.with(mContext).load(mdata.get(i).getImage()).into(viewHolder.c);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, school, desig;
        CircleImageView c;
        String s;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.supportname);
            school = (TextView) itemView.findViewById(R.id.supportlab);
            desig = (TextView) itemView.findViewById(R.id.supportwork);
            c = (CircleImageView) itemView.findViewById(R.id.supportimage);


        }


    }}
