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

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class Support extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<Model3> list;
    public Support() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_support, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.supportrecycle);
        recyclerView.hasFixedSize();
        SupportingStaff iconAdapter=new SupportingStaff(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(iconAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        PhotoView offphoto=(PhotoView)view.findViewById(R.id.offphoto);
        ImageView hosphoto=(ImageView)view.findViewById(R.id.hosphoto);
        ImageView tranphoto=(ImageView)view.findViewById(R.id.tranphoto);

        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/56182371_110502910126993_5118924417748959232_n.jpg?_nc_cat=111&_nc_ht=scontent.fblr4-1.fna&oh=da60637fb25e71948a1e4b43f02e0eb6&oe=5D021D9B").into(offphoto);
        Picasso.with(getContext()).load("https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55793554_106207367223214_130588304541220864_o.jpg?_nc_cat=107&_nc_ht=scontent.fblr4-2.fna&oh=068b6047b8cf5eaa7af271a259065b6a&oe=5D09ADF3").into(hosphoto);
        Picasso.with(getContext()).load("https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/54520753_106214663889151_4827481002332913664_o.jpg?_nc_cat=102&_nc_ht=scontent.fblr4-1.fna&oh=ecaf3fd778674dcf28d94fa7c4d27e26&oe=5D45EC0E").into(tranphoto);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new Model3("Mr. Gopal Krishna M P","Dept. of CSE","System Analyst","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fgopal_cs.PNG?alt=media&token=6d90d24e-2743-4b3a-a51e-8576026c9493"));
        list.add(new Model3("Mrs. Pushpa U","Dept. of CSE","Lab Assistant","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fpushpa_cs.PNG?alt=media&token=563b35d1-d861-4797-80ad-200046777905"));
        list.add(new Model3("Ms. Shwetha T S","Dept. of CSE","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fswetha_cs.PNG?alt=media&token=3afda677-400f-44e1-b28e-54db0f243982"));
      //  list.add(new Model3("Mr. Vasu H","Dept. of CSE","Attender",""));
        list.add(new Model3("Mr. Premkumar","Dept. of CSE","Mechanic","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fpremkumar_cs.PNG?alt=media&token=798860cf-3dfc-49bb-b007-7d80f8caab12"));
        list.add(new Model3("Mr. Suresh","Dept. of CSE","Attender","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fsureshnew_cs.PNG?alt=media&token=6f84e37a-e3dd-41af-abd4-57fd806c4c47"));

        list.add(new Model3("Mr. Abhishek","Dept. of CVE","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fabishek_civil.PNG?alt=media&token=7703c5dd-5fc6-4b38-ac39-49207ddc999f"));
        list.add(new Model3("Mr. Karthik","Dept. of CVE","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fkarthik_civil.PNG?alt=media&token=9c574bf5-0d45-44fb-bd5e-51130b26e1a6"));
        list.add(new Model3("Mr. Deepak Yadav","Dept. of CVE","Attender","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fdeepak_civil.PNG?alt=media&token=b3092c53-130a-47ce-afc9-8bb5875bb3de"));
       // list.add(new Model3("Mr. Girish","Dept. of CVE","Attender",""));
        list.add(new Model3("Ms. Sayyada Gazala","Dept. of ECE","Foreman","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fsayyada_ec.PNG?alt=media&token=3ab688cd-a01f-4e39-abfa-e42665f254b4"));

        list.add(new Model3("Mr. Srikanth H J","Dept. of ISE","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fshreekanth_is.PNG?alt=media&token=183909ad-4aaf-4dd6-906f-d7526deec95f"));
        list.add(new Model3("Mr. Rohith A N","Dept. of ISE","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Frohit_is.PNG?alt=media&token=e4038d32-7961-49e7-b90b-bfb60ba73002"));

        list.add(new Model3("Mr. Manjunath N R","Dept. of ECE","Attender","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fmanjunath_ec.PNG?alt=media&token=fe99b651-df56-4f2f-8adc-57f485b3770a"));
        list.add(new Model3("Ms. Shubha H M","Dept. of ECE","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fshuba_ec.PNG?alt=media&token=9c33a39d-ab14-4da2-ad85-1e8b76c4a57b"));
      //  list.add(new Model3("Ms. Bhavya K T","Dept. of ECE","Lab Instructor",""));

        list.add(new Model3("Mr. Suresh L S","Dept. of EEE","Foreman","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fsuresh_ee.PNG?alt=media&token=8b240bc8-648e-4b06-902f-1463f096c31a"));
        list.add(new Model3("Mr. Raqeeb Ahamed","Dept. of EEE","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fraqueeb_ee.PNG?alt=media&token=a6dcaee0-db52-402b-bb8f-e414e29bef1e"));
        list.add(new Model3("Mr. Lava C P","Dept. of EEE","Attender","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Flava_ee.PNG?alt=media&token=c60cf35c-c3da-4924-952d-1531a6a3171e"));
       // list.add(new Model3("Mr. Ravi R V","Dept. of EEE","Attender",""));

        list.add(new Model3("Mrs. Mamatha H M","Dept. of ME","Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fmamatha_me.PNG?alt=media&token=98100675-e3a1-450d-9113-b54869cad833"));
        list.add(new Model3("Mr. Yogesh A S","Dept. of ME","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fyogesh1_me.PNG?alt=media&token=14b2255a-f9bf-4b3a-9e27-f9a0b2db6aaf"));
        list.add(new Model3("Mr. Dinesh R","Dept. of ME","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fdinesh_me.PNG?alt=media&token=57828849-17b5-4122-8acf-c85864e4957f"));
        list.add(new Model3("Mr. Yogesh J M","Dept. of ME","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fyogesh2_me.PNG?alt=media&token=ddebe607-f1db-4d78-bcee-b71539a7ed94"));
        list.add(new Model3("Mr. Mohan Kumar H S","Dept. of ME","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fmohan_me.PNG?alt=media&token=a0276842-509d-4178-bec7-3447c9231760"));
        list.add(new Model3("Mr. Ramesh K N","Dept. of ME","Attender","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Framesh_me.PNG?alt=media&token=66e502bd-c140-4e74-946d-9794327fcf56"));
        list.add(new Model3("Mr. Ravish","Dept. of PHYSICS","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fraveesh_phy.PNG?alt=media&token=48ae9be7-9a6c-46ea-b01d-1c7b71fff846"));
        list.add(new Model3("Mr. Syed Abdul Kareem","Dept. of PHYSICS","Attender","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fsyed_phy.PNG?alt=media&token=a492c2c4-6abb-4717-9630-4c85d50760af"));
        list.add(new Model3("Mrs. Vidya A R","Dept. of CHEMISTRY","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fvidya_chem.PNG?alt=media&token=7d6679d2-2432-442e-a888-b4087e442a8e"));
        list.add(new Model3("Mr. Manjunath S K","Dept. of CHEMISTRY","Lab Instructor","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fmanjunath_chem.PNG?alt=media&token=6b86e49b-05be-457d-b24a-ca876e5201ca"));

        list.add(new Model3("Mr. Shivanand H S","Dept. of LIBRARY","Attender","https://firebasestorage.googleapis.com/v0/b/ritinfo-cdd32.appspot.com/o/non_teaching_staff%2Fshivanand_library.PNG?alt=media&token=7fef2cbc-e48d-463d-8404-63edcec9e8dd"));



    }


}
