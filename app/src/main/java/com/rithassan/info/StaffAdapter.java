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

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder> {
    Context mContext;

    public StaffAdapter(Context mContext, List<StaffModel> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    List<StaffModel> mdata;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.contacts_list,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mdata.get(i).getName());
        viewHolder.desig.setText(mdata.get(i).getDesig());
        viewHolder.mail.setText(mdata.get(i).getMail());
        viewHolder.phone.setText(mdata.get(i).getNumber());
        viewHolder.school.setText(mdata.get(i).getSchool());
        Glide.with(mContext).load(mdata.get(i).getImage()).into(viewHolder.c);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,school,desig,mail,phone;
        CircleImageView c;
        String s;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.contactname);
            school=(TextView)itemView.findViewById(R.id.contactschooling);
            desig=(TextView)itemView.findViewById(R.id.contactdesignation);
            mail=(TextView)itemView.findViewById(R.id.contactemail);
            phone=(TextView)itemView.findViewById(R.id.contactcall);
            c=(CircleImageView)itemView.findViewById(R.id.contactimage);


        }


    }
}
