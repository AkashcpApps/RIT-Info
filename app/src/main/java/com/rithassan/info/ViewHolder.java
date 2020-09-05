package com.rithassan.info;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    View v;
    public ViewHolder(@NonNull View itemView) {
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
    public void setDetails(Context context,String image,String title,String description,String time,String date){
        TextView heading =v.findViewById(R.id.notificationtitle);
        heading.setText(title);
        TextView content =v.findViewById(R.id.notification_text);
        content.setText(description);
        TextView timings =v.findViewById(R.id.notification_time);
        timings.setText(time);
        TextView datings =v.findViewById(R.id.notification_date);
        datings.setText(date);
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