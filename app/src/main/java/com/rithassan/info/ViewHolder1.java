package com.rithassan.info;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ViewHolder1 extends RecyclerView.ViewHolder {
    View v;
    public ViewHolder1(@NonNull View itemView) {
        super(itemView);
        v=itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mclicklistener.onItemClick(view,getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mclicklistener.onItemLongClick(view,getAdapterPosition());
                return true;
            }
        });

    }
    public void setDetails(Context context,String image,String title,String description){
        TextView heading =v.findViewById(R.id.blogtitle);
        heading.setText(title);
        TextView content =v.findViewById(R.id.blog_description);
        content.setText(description);
        ImageView imageView=v.findViewById(R.id.blog_image);
        Glide.with(v).load(image).into(imageView);

    }
    private ViewHolder.ClickListener mclicklistener;
    public interface ClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);

    }
    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mclicklistener=clickListener;
    }

}