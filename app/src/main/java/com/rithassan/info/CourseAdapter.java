package com.rithassan.info;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CourseAdapter  extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    Context mContext;
    List<CourseModel> mdata;
    public CourseAdapter(Context mContext, List<CourseModel> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.card_list,viewGroup,false);
        ViewHolder myViewHolder=new ViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvname.setText(mdata.get(i).getName());
        viewHolder.img.setImageResource(mdata.get(i).getPhoto());
        viewHolder.cardView.setTag(i);



    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvname;
        ImageView img;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.icon_text);
            img = (ImageView) itemView.findViewById(R.id.icon_image);
            cardView = (CardView) itemView.findViewById(R.id.option_card);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();
            switch(position){
                case 0:
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment myFragment = new ComputerScience();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();
                    break;

                case 1:AppCompatActivity activity1= (AppCompatActivity) view.getContext();
                    Fragment myFragment1 = new Civil();
                    activity1.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment1).addToBackStack(null).commit();
                    break;


                case 2:                  AppCompatActivity activity2= (AppCompatActivity) view.getContext();
                    Fragment myFragment2 = new Electronics();
                    activity2.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment2).addToBackStack(null).commit();
                    break;



                case 3:    AppCompatActivity activity3= (AppCompatActivity) view.getContext();
                    Fragment myFragment3 = new Elecrical();
                    activity3.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment3).addToBackStack(null).commit();
                    break;


                case 4: AppCompatActivity activity4= (AppCompatActivity) view.getContext();
                    Fragment myFragment4 = new InformationScience();
                    activity4.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment4).addToBackStack(null).commit();
                    break;


                case 5: AppCompatActivity activity5= (AppCompatActivity) view.getContext();
                    Fragment myFragment5 = new Mechanical();
                    activity5.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment5).addToBackStack(null).commit();
                    break;


                case 6:  AppCompatActivity activity6= (AppCompatActivity) view.getContext();
                    Fragment myFragment6 = new BasicScience();
                    activity6.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment6).addToBackStack(null).commit();
                    break;

                case 7:   AppCompatActivity activity7= (AppCompatActivity) view.getContext();
                    Fragment myFragment7 = new Mba();
                    activity7.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment7).addToBackStack(null).commit();
                    break;


                case 8:AppCompatActivity activity8= (AppCompatActivity) view.getContext();
                    Fragment myFragment8 = new Mtech();
                    activity8.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment8).addToBackStack(null).commit();
                    break;


                case 9:AppCompatActivity activity9= (AppCompatActivity) view.getContext();
                    Fragment myFragment9 = new Misclaneous();
                    activity9.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment9).addToBackStack(null).commit();
                    break;



                case 10:AppCompatActivity activity90= (AppCompatActivity) view.getContext();
                    Fragment myFragment90 = new Support();
                    activity90.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment90).addToBackStack(null).commit();
                    break;










            }
        }
    }
}
