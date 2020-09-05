package com.rithassan.info;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    Context mContext;

    public ContactsAdapter(Context mContext, List<ContactsModel> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    List<ContactsModel> mdata;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.contact_layout,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mdata.get(i).getName());
        viewHolder.desig.setText(mdata.get(i).getDesignation());
        viewHolder.email.setText(mdata.get(i).getEmail());
        viewHolder.phone.setText(mdata.get(i).getPhone());



    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
TextView name,desig,email,phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.personname);
            desig=(TextView)itemView.findViewById(R.id.schooling);
            email=(TextView)itemView.findViewById(R.id.mail);
            phone=(TextView)itemView.findViewById(R.id.phonenumber);
        }


    }
}
