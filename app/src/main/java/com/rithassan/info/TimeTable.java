package com.rithassan.info;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.Calendar;




public class TimeTable extends Fragment implements AdapterView.OnItemSelectedListener {
    View view;
    String[] odd = {"CHOOSE SEMESTER", "1st SEMESTER", "3rd SEMESTER", "5th SEMESTER", "7th SEMESTER"};
    String[] even = {"CHOOSE SEMESTER", "2nd SEMESTER", "4th SEMESTER", "6th SEMESTER", "8th SEMESTER"};
    String[] secall = {"CHOOSE SECTION", "A SECTION", "B SECTION"};
    String[] secfist = {"CHOOSE SECTION", "A SECTION", "B SECTION", "C SECTION", "D SECTION", "E SECTION", " F SECTION"};


    SharedPreferences sharedPreferences, Timatablesharedpref;
    String branch, semister, section;
    Button load;
    Spinner sec, sem;
    PhotoView timetable, internals;
    TextView text1, text2, warning1, warning2;
    ProgressBar progressBar1, progressBar2;
    int month;

    public TimeTable() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_time_table, container, false);
        timetable = (PhotoView) view.findViewById(R.id.timetablephoto);
        internals = (PhotoView) view.findViewById(R.id.internalsphoto);
        text1 = (TextView) view.findViewById(R.id.timetabletext);
        text2 = (TextView) view.findViewById(R.id.internalstext);
        warning1 = (TextView) view.findViewById(R.id.ptext1);
        warning2 = (TextView) view.findViewById(R.id.ptext2);
        month = Calendar.getInstance().get(Calendar.MONTH);
        sem = (Spinner) view.findViewById(R.id.semister);
        sec = (Spinner) view.findViewById(R.id.section);
        sem.setOnItemSelectedListener(this);
        sec.setOnItemSelectedListener(this);
        if ((month == 1) || (month == 2) || (month == 3) || (month == 4) || (month == 5) || (month == 6)) {
            ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, even);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sem.setAdapter(aa);

        }
        if ((month == 7) || (month == 8) || (month == 9) || (month == 10) || (month == 11) || (month == 0)) {
            ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, odd);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sem.setAdapter(aa);

        }


        load = (Button) view.findViewById(R.id.loadtimetable);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if (semister == null) {
                    TastyToast.makeText(getContext(), "Please select Semester", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    return;
                }
                if (section == null) {
                    TastyToast.makeText(getContext(), "Please select Section", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    return;

                }
                load_timetable();

            }
        });
        progressBar1 = (ProgressBar) view.findViewById(R.id.prog1);


        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()) {
            case R.id.semister:
                if ((month == 1) || (month == 2) || (month == 3) || (month == 4) || (month == 5) || (month == 6)) {
                    switch (i) {
                        case 1:
                            sec.setVisibility(View.VISIBLE);
                            ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secfist);
                            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(aa);
                            semister = ("two");

                            break;
                        case 2:
                            sec.setVisibility(View.VISIBLE);

                            ArrayAdapter a1 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secall);
                            a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(a1);
                            semister = ("four");

                            break;

                        case 3:
                            sec.setVisibility(View.VISIBLE);

                            ArrayAdapter a2 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secall);
                            a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(a2);
                            semister = ("six");

                            break;

                        case 4:
                            sec.setVisibility(View.VISIBLE);

                            ArrayAdapter a3 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secall);
                            a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(a3);
                            semister = ("eight");

                            break;

                    }

                }
                if ((month == 7) || (month == 8) || (month == 9) || (month == 10) || (month == 11) || (month == 0)) {

                    switch (i) {
                        case 1:
                            sec.setVisibility(View.VISIBLE);

                            ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secfist);
                            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(aa);
                            semister = ("first");

                            break;
                        case 2:
                            sec.setVisibility(View.VISIBLE);

                            ArrayAdapter a1 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secall);
                            a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(a1);
                            semister = ("third");
                            break;

                        case 3:
                            sec.setVisibility(View.VISIBLE);

                            ArrayAdapter a2 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secall);
                            a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(a2);
                            semister = ("fifth");
                            break;

                        case 4:
                            sec.setVisibility(View.VISIBLE);

                            ArrayAdapter a3 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, secall);
                            a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sec.setAdapter(a3);
                            semister = ("seventh");
                            break;
                    }
                }
                break;
            case R.id.section:
                switch (i) {
                    case 1:
                        section = ("A");
                        break;
                    case 2:
                        section = ("B");
                        break;
                    case 3:
                        section = ("C");
                        break;
                    case 4:
                        section = ("D");
                        break;
                    case 5:
                        section = ("E");
                        break;
                    case 6:
                        section = ("F");
                        break;

                }
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void load_timetable() {
        timetable.setVisibility(View.VISIBLE);
        text1.setVisibility(View.VISIBLE);
        warning2.setVisibility(View.VISIBLE);
        text2.setVisibility(View.VISIBLE);
        internals.setVisibility(View.VISIBLE);


        progressBar1.setVisibility(View.VISIBLE);
        String asemister = semister;
        String asection = section;
        sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String timeUSN = sharedPreferences.getString("name", "Data Not Found");
        if(timeUSN.length()==10) {
            branch = timeUSN.substring(5, 7).toUpperCase();
            Toast.makeText(getContext(), "Branch=" + branch, Toast.LENGTH_SHORT).show();
        }else if(timeUSN.length()==12){
            branch = timeUSN.substring(3,5).toUpperCase();
            Toast.makeText(getContext(), "Branch=" + branch, Toast.LENGTH_SHORT).show();
        }


        Timatablesharedpref = getActivity().getSharedPreferences("timetables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Timatablesharedpref.edit();
        editor.putString("timesemister", asemister);
        editor.putString("timesection", asection);
        editor.apply();
        semister = Timatablesharedpref.getString("timesemister", "SEM DATA NOT FOUND");
        section = Timatablesharedpref.getString("timesection", "SEC DATA NOT FOUND");
        if(semister.equals("four")||semister.equals("six")||semister.equals("eight")|| semister.equals("fifth")||semister.equals("third") ){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(branch + "/" + semister + "/" + section);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue().toString();

                Glide.with(getContext()).load(url).into(timetable);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
        DatabaseReference databaseReference1=FirebaseDatabase.getInstance().getReference(branch+"/"+semister+"/IA");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue().toString();

                Glide.with(getContext()).load(url).into(internals);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        }
        if(semister.equals("two")||semister.equals("first")){



            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference( semister + "/" + section);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String url = dataSnapshot.getValue().toString();

                    Glide.with(getContext()).load(url).into(timetable);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            if(section=="A"||section=="B"||section=="C"){
                DatabaseReference databaseReference1=FirebaseDatabase.getInstance().getReference(semister+"/IACHEM");
                databaseReference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String url = dataSnapshot.getValue().toString();

                        Glide.with(getContext()).load(url).into(internals);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            if(section=="D"||section=="E"||section=="F"){
                DatabaseReference databaseReference1=FirebaseDatabase.getInstance().getReference(semister+"/IAPHY");
                databaseReference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String url = dataSnapshot.getValue().toString();

                        Glide.with(getContext()).load(url).into(internals);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }



        }



    }


}