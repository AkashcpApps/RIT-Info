package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnPxWidthModel;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;


public class Transport extends Fragment {
    View view;
    ImageView image1,image2,image3;
    public static final String[][] TAB_1 = {
            {  "B.S.N.L.", "8.00 AM" },
            { "Ganapathi Temple", "8.00 AM"},
            {  "Beeranally Kere Road", "8.05 AM"},
            { "Gowri Koppalu", "8.10 AM"},
            {  "Vidhya Nagar Ladies Hostel", "8.15 AM"},
            { "Vidhya Nagar Auto Stand", "8.15 AM"},
            { "Ring Road Entrance", "8.20 AM"},
            { "Tanvi Trisha Kalyanamantap", "8.25 AM"},
            {  "Adichunchanagiri School", "8.30 AM"},
            {  "Petrol Bunk", "8.30 AM"},
            {  "Sampige Road Entrance", "8.35 AM"},
            {  "Banu Theatre", "8.40 AM"},
            {  "Police Station Circle", "8.45 AM"},
            {  "New Bus Stand", "8.50 AM"},
            {  "College", "8.55 AM"}};
    public static final String[][] TAB_2 = {
            { "Stadium Gate", "8.00 AM" },
            {  "Hemavathi Nagara", "8.00 AM"},
            {  "Shanthi Nagar", "8.05 AM"},
            {  "Ganapathi Temple", "8.10 AM"},
            {  "MCE College", "8.15 AM"},
            {  "Ring Road", "8.20 AM"},
            {  "Tanvi Trisha Kalyana Mantap", "8.25 AM"},
            { "Udbhava Ganapathi Temple", "8.30 AM"},
            { "Dairy Circle", "8.35 AM"},
            { "College", "8.50 AM"}
       };
    public static final String[][] TAB_3 = {
            {  "Ring Road Petrol bunk", "8.15 AM" },
            {  "Dasara Koppalu", "8.20 AM"},
            { "Space Quarters", "8.25 AM"},
            {  "Ring Road", "8.30 AM"},
            {  "Thanvi Thrisha Kalyana Mantapa", "8.30 AM"},
            {  "Sathyamangala", "8.35 AM"},
            {  "B. Katihalli", "8.40 AM"},
            { "College", "8.55 AM"}};
    public static final String[][] TAB_4 = {
            {  "Sahyadri Theater", "8.00 AM" },
            {  "Aralikatte Circle", "8.00 AM"},
            {  "Brahmins Hostel", "8.05 AM"},
            {  "St. Joseph School", "8.05 AM"},
            {  "Sangameshwara Badavane", "8.10 AM"},
            {  "Basaveshwara Kalyana Mantapa", "8.10 AM"},
            {  "Old Mutton Market Circle", "8.15 AM"},
            {"Hosaline Road", "8.15 AM"},
            { "Santhepete Circle", "8.20 AM"},
            {  "KEB Gate", "8.25 AM"},
            {  "Thanneru Halla", "8.25 AM"},
            {  "Vijayanagar", "8.30 AM"},
            {  "Silk Board", "8.35 AM"},
            {  "Doddamandigana Halli", "8.35 AM"},
            {  "Bittegowdana Halli", "8.40 AM"},
            {"College", "8.45 AM"}};
    public static final String[][] TAB_5 = {
            {  "Vokkaliga Hostel", "8.10 AM" },
            {  "Rajeev Arcade", "8.10 AM"},
            {  "Euro Kids", "8.15 AM"},
            {  "M.G. Road", "8.15 AM"},
            {  "Petrol Bunk", "8.20 AM"},
            {  "Krishna Bekari", "8.20 AM"},
            { "Tanvi Trisha Kalyanamantap", "8.25 AM"},
            { "Udbhava Ganapathi", "8.30 AM"},
            { "Mini Vidhana Soudha", "8.35 AM"},
            {  "Pruthvi Theatre", "8.40 AM"},
            { "Dairy Circle", "8.45 AM"},
            {  "College", "8.55 AM"}};
    private static final String[] TABLE_HEADERS = { "Routes" ,"Timings"};

    public Transport() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_transport, container, false);
        image1=(ImageView)view.findViewById(R.id.image1);
        image2=(ImageView)view.findViewById(R.id.image2);
        image3=(ImageView)view.findViewById(R.id.image3);
        TableColumnPxWidthModel columnModel = new TableColumnPxWidthModel(4, 500);
        columnModel.setColumnWidth(1, 700);
        columnModel.setColumnWidth(2, 300);


        TableView<String[]> tableView1 = (TableView<String[]>) view.findViewById(R.id.tableView1);
        tableView1.setDataAdapter(new SimpleTableDataAdapter(getContext(), TAB_1));
        tableView1.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), TABLE_HEADERS));
        tableView1.setColumnCount(2);
        tableView1.setColumnModel(columnModel);
        TableView<String[]> tableView2 = (TableView<String[]>) view.findViewById(R.id.tableView2);
        tableView2.setDataAdapter(new SimpleTableDataAdapter(getContext(), TAB_2));
        tableView2.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), TABLE_HEADERS));
        tableView2.setColumnCount(2);        tableView2.setColumnModel(columnModel);

        TableView<String[]> tableView3 = (TableView<String[]>) view.findViewById(R.id.tableView3);
        tableView3.setDataAdapter(new SimpleTableDataAdapter(getContext(), TAB_3));
        tableView3.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), TABLE_HEADERS));
        tableView3.setColumnCount(2);        tableView3.setColumnModel(columnModel);

        TableView<String[]> tableView4 = (TableView<String[]>) view.findViewById(R.id.tableView4);
        tableView4.setDataAdapter(new SimpleTableDataAdapter(getContext(), TAB_4));
        tableView4.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), TABLE_HEADERS));
        tableView4.setColumnCount(2);        tableView4.setColumnModel(columnModel);

        TableView<String[]> tableView5 = (TableView<String[]>) view.findViewById(R.id.tableView5);
        tableView5.setDataAdapter(new SimpleTableDataAdapter(getContext(), TAB_5));
        tableView5.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), TABLE_HEADERS));
        tableView5.setColumnCount(2);        tableView5.setColumnModel(columnModel);
        Glide.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55533164_110481013462516_8134336731961884672_o.jpg?_nc_cat=100&_nc_ht=scontent.fblr1-3.fna&oh=a152d7220532592734965651ef786df6&oe=5D4920DD").into(image1);
        Glide.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55632730_110481000129184_6293466203608317952_o.jpg?_nc_cat=102&_nc_ht=scontent.fblr1-3.fna&oh=dbe154828253294fed9a29f57e292cb6&oe=5D177E09").into(image2);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/56252826_110491960128088_2237333311565332480_n.jpg?_nc_cat=108&_nc_ht=scontent.fblr1-4.fna&oh=d1ba34c097cb11ce9709a2fb7744102e&oe=5D0FAD4C").into(image3);

        return view;
    }


}
