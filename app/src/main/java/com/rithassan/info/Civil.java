package com.rithassan.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class Civil extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<StaffModel> list;

    public Civil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_civil, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.cvrecycle);
        StaffAdapter iconAdapter=new StaffAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(false);
        ImageView civilhod=(ImageView)view.findViewById(R.id.civilhodimage);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54730087_107464520430832_6588135856723197952_o.jpg?_nc_cat=104&_nc_ht=scontent.fblr4-1.fna&oh=c9d700b12b3b5ecfb45391abe8b1be64&oe=5D0B83BD").into(civilhod);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new StaffModel("Mr. Kiran.S.P","B.E , M.Tech","Asst. Professor","kiransp016@gmail.com","9611978234","http://www.rithassan.org/staffpic/CV/Kiransp.jpg"));
        list.add(new StaffModel("Mr. Manjunatha K H","M.Sc(Geology)","Asst. Professor","manjusrikrishna14@gmail.com","9844194711","http://www.rithassan.org/staffpic/CV/Manjunathkh.jpg"));
        list.add(new StaffModel("Mr. Raghunandan Yadav C","B.E , M.Tech","Asst. Professor","ryadavias@gmail.com","9164328225","http://www.rithassan.org/staffpic/CV/Raghunandan.jpg"));
        list.add(new StaffModel("Mrs. Supriya M J","B.E , M.Tech","Asst. Professor","supriyamjpriya@gmail.com","9900270268","http://www.rithassan.org/staffpic/CV/Supriyamj.jpg"));
        list.add(new StaffModel("Mr. Ananth H V","B.E , M.Tech","Asst. Professor","ananthhassan@gmail.com","9740286780","http://www.rithassan.org/staffpic/CV/Ananth.jpg"));
        list.add(new StaffModel("Ms. Manjula","B.E , M.Tech","Asst. Professor","manjula.18990@gmail.com","8951385010","http://www.rithassan.org/staffpic/CV/Manjula.jpg"));
        list.add(new StaffModel("Mrs. Madhu K M","B.E , M.Tech","Asst. Professor","madhukm46@gmail.com","9741099766","http://www.rithassan.org/staffpic/CV/Madhukm.jpg"));
        list.add(new StaffModel("Mrs. Vani A","B.E , M.Tech","Asst. Professor","vania312@gmail.com","9632448586","http://www.rithassan.org/staffpic/CV/Vania.jpg"));
        list.add(new StaffModel("Mr. Ashish Dubay B","B.E , M.Tech","Asst. Professor","ashishdubay02@gmail.com","9901227004","http://www.rithassan.org/staffpic/CV/Ashish.jpg"));
        list.add(new StaffModel("Mr. Chethan K M","B.E , M.Tech","Asst. Professor","chetan.km77@gmail.com","7892536510","http://www.rithassan.org/staffpic/CV/Chethankm.jpg"));
        list.add(new StaffModel("Mr. Gopal B Bekkeri","B.E , M.Tech","Asst. Professor","gopiflute@gmail.com","8880477047","http://www.rithassan.org/staffpic/CV/Gopalb.jpg"));
        list.add(new StaffModel("Mr. Manjunath H S","B.E , M.Tech","Asst. Professor","manjunathhs1000@gmail.com","9916581792","http://www.rithassan.org/staffpic/CV/Manjunathhs.jpg"));

        list.add(new StaffModel("Mrs. Supriya C L","B.E , M.Tech","Asst. Professor","supriyachandrappa@gmail.com","7259495896","http://www.rithassan.org/staffpic/CV/Supriyacl.jpg"));
        list.add(new StaffModel("Mrs. Sharmila K C","B.E , M.Tech","Asst. Professor","shammi091@gmail.com","9482741719","http://www.rithassan.org/staffpic/CV/Sharmilakc.jpg"));

        list.add(new StaffModel("Mr. Darshan S","B.E , M.Tech","Asst. Professor","sdarshan061@gmail.com","9164094573","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAHkAeQMBIgACEQEDEQH/xAAbAAEAAgMBAQAAAAAAAAAAAAAABAUBAwYCB//EADIQAAICAQIDBgMIAwEAAAAAAAABAgMEETEFIVESEyJBYXEyYqEUM0KBkbHB0SOSohX/xAAWAQEBAQAAAAAAAAAAAAAAAAAAAQL/xAAWEQEBAQAAAAAAAAAAAAAAAAAAARH/2gAMAwEAAhEDEQA/APuIAAGG0lq9jVlZNeNX2rHvsluyiy823JbUn2YeUE/3LImrTI4rRVqq/wDJL02/Ur7eKZM/hagvlRBBcGyd90/itm/eTPGr6swCo2Ruth8Fs4+0mSKuJZNe81NfMiGALvH4tVPRXRdb67osIzjOKlCSaezTOVN2NlW40ta5cvOL2ZMXXTAjYeZXlQ1jymt4vyJJlQAADTlZEMapzn7JdWbW9FqznM/JeTe5fgjygv5LIla8i6eRa52vVvy6ehqANIGQXHC8BKCvuWsnzjF+SFuKrqsPJtScKZaPzfL9zd/5WV0h/sX+gM6Y5uzByq+cqW11jzI51hA4jgRvi7K1pav+i6YoQZMFR7rnKqanB9mS2aOgwMuOVVrtNfFHoc4bca+WPdGyHluuq6EsV1APFU421xnF6xktUezKq/jF/d4/dxfis5fl5lETeLW95mSWvKCSIRqIAAqNlEVO+uLWqckn+p1C5I5nDWuXSvnR05mrAAEUAAHOcSioZtqS5N6/Qikzi3LPs9l+xDNxkAAFvwS9uMqJPbxR/ktjmsG3usuuWui10fszpTNWOWyJdu+yXWTf1NZl7v3MGkAABY8EUXlSbXiUOX6l4cxiXvGyI2papbpeaOlrmrIRnHaS1RmrHoAEUAAFTx1R/wAT08XP9CoJXEMr7Vf2o6qEVpEim4yAAB7bl79tfUojZ4ugoXR7F1kH+GTX1NZM4rX3eZN+U/EiGAAAAveD3qzG7tvxVv6FESMLIeNep/h2kvQUdKDzXONkFODTi1qmj0YaCJxK/uMSbT8UvDH3JTaS1fJHP8SyvtN2kPu48o+vqWCIYANMgAAF19gKvDr77Krh5OXP2Om5kqq7jVHboVq3r39ilOqnFSi4yWqa0ZzeZjvGvlB66bxfVCFaAe6652zUK4uUn5IsqODyejvs0+WH9l0VR7rrnbJRrg5N9EdBVgY1e1Sb6y5klRSWiWi9CaYj8Polj40YTfi3foSQDKtWVU7seytPRyWmpzd1NlMnG2Di/XY6kw0nuWVHJg6W3Cxrfipjr1S0IN3B1vRY18sv7LpioBtvosx59i2Oj8vUxRVK+2NcFzl9CoseCUPtTvktvDH+S309WeKKo01RrjtFaGwxWgj5uLHKp7D5SXOL6MkACHw3FWNT4ku8fxMmGGueoQGQAAAAAAAADDegGjNx45FEoSXPTWL6M1cOw1jQ7U/vZb+noTN9zIAAAAAAMNamQB50afUzrpuZAGNUZNdm6NU/vPzAkNpGO0jzH7z8jYB55v0MpaGQAAAAAAf/2Q=="));
        list.add(new StaffModel("Ms Rashmi A S","B.E , M.Tech","Asst. Professor","rashmi18@gmail.com","8722859128","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/hods%2Frashmi.jpg?alt=media&token=f2d3dc2a-6b33-4b20-ab61-2cb54c4d488a"));





    }


}
