package com.rithassan.info;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SparkNotes extends Fragment {
    View view;
    DatabaseHelper databaseHelper;
    EditText editName, editSurname, editMarks, editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;
    TextView help;

    public SparkNotes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_spark_notes, container, false);
databaseHelper=new DatabaseHelper(getContext());
        editName = (EditText) view.findViewById(R.id.editText_name);
        help = (TextView) view.findViewById(R.id.textViewac);
        editTextId = (EditText) view.findViewById(R.id.editText_id);
        btnAddData = (Button) view.findViewById(R.id.button_add);
        btnviewAll = (Button) view.findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button) view.findViewById(R.id.button_update);
        btnDelete = (Button) view.findViewById(R.id.button_delete);
        //editTextId.setVisibility(View.INVISIBLE);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder aler = new AlertDialog.Builder(getContext());
                aler.setTitle("HELP").setMessage("1)ADD:To Add the NOTE\n2)VIEW:View the NOTE\n3)Update:To make changes in existing NOTE\n4)DELETE:Delete the NOTE\n***********\nUse the Note number to\n*Update\n*Delete");
                aler.show();
                aler.setNegativeButton("OK", null);
            }
        });
        return view;



    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.Tada).duration(500).repeat(1)
                                .playOn(view.findViewById(R.id.button_delete));
                        // editTextId.setVisibility(View.VISIBLE);
                        Integer deletedRows = databaseHelper.deleteData(editTextId.getText().toString());
                        if (deletedRows > 0) {
                            Toast.makeText(getContext(), "Data Deleted of number=" + editTextId.getText().toString(), Toast.LENGTH_LONG).show();
                            editTextId.getText().clear();
                            // editTextId.setVisibility(View.INVISIBLE);
                        } else
                            Toast.makeText(getContext(), "Nothing to Deleted", Toast.LENGTH_LONG).show();
                        // editTextId.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.Tada).duration(500).repeat(1)
                                .playOn(view.findViewById(R.id.button_update));
                        if (editTextId.getText().toString().isEmpty()) {

                            Toast.makeText(getContext(), "Enter Serial Number to\n\t\t\tAlter the Note", Toast.LENGTH_SHORT).show();

                        } else {
                            boolean isUpdate = databaseHelper.updateData(editTextId.getText().toString(),
                                    editName.getText().toString());
                            if (isUpdate == true){
                                Toast.makeText(getContext(), "Data Update", Toast.LENGTH_LONG).show();
                                editTextId.getText().clear();
                            }

                            else
                                Toast.makeText(getContext(), "Enter the Number to update", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.Tada).duration(500).repeat(1)
                                .playOn(view.findViewById(R.id.button_add));
                        if (editName.getText().toString().isEmpty()) {
                            Toast.makeText(getContext(), "Please enter some data to Add", Toast.LENGTH_SHORT).show();

                        } else {
                            boolean isInserted = databaseHelper.insertData(editName.getText().toString());
                            if (isInserted == true) {
                                Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                                editName.getText().clear();

                            } else
                                Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.Tada).duration(500).repeat(1)
                                .playOn(view.findViewById(R.id.button_viewAll));
                        Cursor res = databaseHelper.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("No Memo", "Empty");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Number:\t" + res.getString(0) + "\n");
                            buffer.append("Note:\t" + res.getString(1) + "\n");
                        }
                        // Show all data
                        showMessage("Data", buffer.toString());
                        editTextId.getText().clear();
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
