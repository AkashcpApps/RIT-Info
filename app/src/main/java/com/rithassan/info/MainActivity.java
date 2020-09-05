package com.rithassan.info;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.github.javiersantos.appupdater.AppUpdater;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.robohorse.gpversionchecker.GPVersionChecker;
import com.sdsmdg.tastytoast.TastyToast;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

Dialog dialog;
String appurl;
FirebaseAuth firebaseAuth;
TextView textView;
WifiManager wifiManager;
View view;
int id1;
    Toolbar toolbar;
int i=0;

    SharedPreferences sharedPreferences,prefs;
    String k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GPVersionChecker.Builder(this).create();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

prefs= PreferenceManager.getDefaultSharedPreferences(this);



      getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_gradient));
textView=(TextView)findViewById(R.id.nav_usn);
        sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);
        k=sharedPreferences.getString("name","Data not present");
        String menuFragment = getIntent().getStringExtra("notification");
        if (menuFragment != null) {

            // Here we can decide what do to -- perhaps load other parameters from the intent extras such as IDs, etc
            if (menuFragment.equals("Notifications")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Notifications()).addToBackStack("FragmentB")
                        .commit();
            }
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Home()).addToBackStack("FragmentB")
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.main);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_usn);
        navUsername.setText(k);
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("AppLink");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                appurl=dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
          if (!havenetwork()){
            nointernet();

        }




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }


      /*  if (view.canG)
        //this.getParent().onBackPressed();

        MainActivity.this.finish();*/

       /* Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        finish();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.notifications) {
            if (havenetwork()){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Notifications()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();
            }



        }
        if (id == R.id.update) {
            if (havenetwork()){
                Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
                new GPVersionChecker.Builder(MainActivity.this).create();
               //checkupdate();

            }
            else if (!havenetwork()){
                nointernet();
            }



        }

        if (id==R.id.signout){

            new FancyAlertDialog.Builder(this)
                    .setTitle("Rajeev Institute of Technology")
                    .setBackgroundColor(Color.parseColor("#730181"))  //Don't pass R.color.colorvalue
                    .setMessage("Do you really want to Exit ?")
                    .setNegativeBtnText("Cancel")
                    .setPositiveBtnBackground(Color.parseColor("#FF0047"))  //Don't pass R.color.colorvalue
                    .setPositiveBtnText("Sign Out")
                    .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                    .setAnimation(Animation.POP)
                    .isCancellable(false)
                    .setIcon(R.drawable.icon_exit,Icon.Visible)
                    .OnPositiveClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {
                            FirebaseAuth.getInstance().signOut();
                            TastyToast.makeText(getApplicationContext(), "Sign Out...!", TastyToast.LENGTH_LONG, TastyToast.INFO);
                            finish();
                            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent);                        }
                    })
                    .OnNegativeClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {
                        }
                    })
                    .build();



        }
        if(id==R.id.internshala){
            if (havenetwork()){
                String url = "https://internshala.com/intern_with_icon?utm_source=iwi3_tnp&utm_medium=aicte";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            else if (!havenetwork()){
                nointernet();
            }


        }
        if (id==R.id.vtu){
            if (havenetwork()){
                String url = "http://vtu.ac.in/kn/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            else if (!havenetwork()){
                nointernet();
            }


        }

if (id==R.id.documents){
    if (havenetwork()){
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("document");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String akashpdf=dataSnapshot.getValue().toString();
                try {
                    Uri webpage = Uri.parse(akashpdf);
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }catch (Exception ie){
                    Toast.makeText(MainActivity.this, "No Documents is present", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    else if (!havenetwork()){
        nointernet();
    }







}
if (id==R.id.notes){
    getSupportFragmentManager().beginTransaction().replace(R.id.container,
            new SparkNotes()).addToBackStack("FragmentB")
            .commit();

}
        return super.onOptionsItemSelected(item);
    }

   /* private void checkupdate() {



    }*/


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Home()).commit();

        }
        else if(id==R.id.internaltimetables){
            if (havenetwork()){

                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new TimeTable()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }


        }
        else if (id == R.id.rit_blog) {

            if (havenetwork()){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Blogs()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }

        }else if (id == R.id.events_calender) {

            if (havenetwork()){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new EventCalender()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }

        }  else if (id == R.id.explore_rit) {

            if (havenetwork()){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Explore()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }


        } else if (id == R.id.details) {
            if (havenetwork()){

                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new StudentInfo()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }


        } else if (id == R.id.notes) {

            if (havenetwork()){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Notes()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }

        }
    else if (id == R.id.syllabus) {
            if (havenetwork()){

                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Syllabus()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }

    }
        else if (id == R.id.resuts) {

            if (havenetwork()){

                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Result()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();

            }


        }else if (id == R.id.developer) {

            if (havenetwork()){

                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Developer()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
nointernet();
            }
              }
        else if (id == R.id.place) {
            if (havenetwork()){

                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Placement()).addToBackStack("FragmentB")
                        .commit();
            }
            else if (!havenetwork()){
                nointernet();
            }
        }
        else if (id==R.id.contact){


            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Contacts()).addToBackStack("FragmentB")
                    .commit();
        }
        else if(id==R.id.feedback){
            new FancyAlertDialog.Builder(this)
                    .setTitle("Rajeev Institute of Technology")
                    .setBackgroundColor(Color.parseColor("#730181"))  //Don't pass R.color.colorvalue
                    .setMessage("Feedback and Suggestions for Development Purpose Only")
                    .setNegativeBtnText("Rate Us")
                    .setIcon(R.drawable.ic_star_border_black_24dp,Icon.Visible)
                    .setPositiveBtnBackground(Color.parseColor("#FF0047"))  //Don't pass R.color.colorvalue
                    .setPositiveBtnText("Feedback")
                    .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                    .setAnimation(Animation.SIDE)
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {




                            Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback and Suggessions");
                            intent.putExtra(Intent.EXTRA_TEXT, "We like to suggest that");
                            intent.setData(Uri.parse("mailto:ritinfohassan@gmail.com")); // or just "mailto:" for blank
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                            startActivity(intent);                    }
                    })
                    .OnNegativeClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {
                           Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(appurl));
                           startActivity(i);
                        }
                    })
                    .build();

        }
        else if(id==R.id.shareapp){//share


            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "#RIT Info" + "\n" + "Get Complete Information of RIT\nLatest Updates\nComplete Student Details and much more\nGet it On Playstore\n"+appurl;
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Rajeev Institute of Technology!");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivityForResult(Intent.createChooser(sharingIntent, "Share via"), 1);
            getFragmentManager().popBackStack();
        }else if (id == R.id.notes) {


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void nointernet() {
        new FancyAlertDialog.Builder(MainActivity.this)
                .setTitle("RIT INFO")
                .setBackgroundColor(Color.parseColor("#730181"))
                .setMessage("No Internet Connection")
                .setNegativeBtnText("Turn On WIFI")
                .setPositiveBtnBackground(Color.parseColor("#FF0047"))
                .setPositiveBtnText("Turn On Data")
                .setNegativeBtnBackground(Color.parseColor("#FF0047"))
                .setAnimation(Animation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.icon_error,Icon.Visible)
                .OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        startActivity(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS));

                    }
                })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        wifiManager.setWifiEnabled(true);
                        TastyToast.makeText(getApplicationContext(), "WIFI Enabled", TastyToast.LENGTH_LONG, TastyToast.WARNING);

                }
                })
                .build();

    }

    @Override

    protected void onStart() {

        super.onStart();

        if(!prefs.getBoolean("FirstTime",false)){

            Drawable myIcon = getResources().getDrawable( R.drawable.icon_nav_menu );
            final SpannableString sassyDesc = new SpannableString("It allows you to go back, sometimes");
            sassyDesc.setSpan(new StyleSpan(Typeface.ITALIC), sassyDesc.length() - "sometimes".length(), sassyDesc.length(), 0);
            TapTargetView.showFor(this,                 // `this` is an Activity
                    TapTarget.forToolbarNavigationIcon(toolbar, "MENU", "Explore Every Corners of the App")
                            // All options below are optional
                            .outerCircleColor(R.color.colorAccent)      // Specify a color for the outer circle
                            .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                            .targetCircleColor(R.color.white)   // Specify a color for the target circle
                            .titleTextSize(25)                  // Specify the size (in sp) of the title text
                            .titleTextColor(R.color.white)      // Specify the color of the title text
                            .descriptionTextSize(18)            // Specify the size (in sp) of the description text
                            .descriptionTextColor(R.color.white)  // Specify the color of the description text
                            .textColor(R.color.white)            // Specify a color for both the title and description text
                            .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                            .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
                            .drawShadow(true)                   // Whether to draw a drop shadow or not
                            .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                            .tintTarget(true)                   // Whether to tint the target view's color
                            .transparentTarget(false)
                            .icon(myIcon)// Specify whether the target is transparent (displays the content underneath)
                            .targetRadius(60),                  // Specify the target radius (in dp)
                    new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);
                            triggerone();




                        }
                    });







            SharedPreferences.Editor editor=prefs.edit().putBoolean("FirstTime",true);
            editor.apply();
        }
        else{


        getSupportActionBar().setTitle("RIT Info");
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new Home()).commit();
    }}

    private void triggerone() {

        Drawable myIcon = getResources().getDrawable( R.drawable.icon_notification );

        final SpannableString sassyDesc = new SpannableString("It allows you to go back, sometimes");
        sassyDesc.setSpan(new StyleSpan(Typeface.ITALIC), sassyDesc.length() - "sometimes".length(), sassyDesc.length(), 0);
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forToolbarMenuItem(toolbar, R.id.notifications,"NOTIFICATIONS", "Stay Connected To RIT and Get All the Latest Updates")
                        // All options below are optional
                        .outerCircleColor(R.color.purple)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.white)   // Specify a color for the target circle
                        .titleTextSize(25)                  // Specify the size (in sp) of the title text
                        .titleTextColor(R.color.white)      // Specify the color of the title text
                        .descriptionTextSize(18)            // Specify the size (in sp) of the description text
                        .descriptionTextColor(R.color.white)  // Specify the color of the description text
                        .textColor(R.color.white)            // Specify a color for both the title and description text
                        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                        .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)                   // Whether to draw a drop shadow or not
                        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(false)
                        .icon(myIcon)// Specify whether the target is transparent (displays the content underneath)
                        .targetRadius(60),                  // Specify the target radius (in dp)
                new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);
                        triggertwo();




                    }
                });

    }

    private void triggertwo() {
        Drawable myIcon = getResources().getDrawable( R.drawable.icon_options );

        final SpannableString sassyDesc = new SpannableString("It allows you to go back, sometimes");
        sassyDesc.setSpan(new StyleSpan(Typeface.ITALIC), sassyDesc.length() - "sometimes".length(), sassyDesc.length(), 0);
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forToolbarOverflow(
                        toolbar,"MORE FEATURES", "Features Aren't Completed Still More To Explore ")
                        // All options below are optional
                        .outerCircleColor(R.color.colorAccent)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.white)   // Specify a color for the target circle
                        .titleTextSize(25)                  // Specify the size (in sp) of the title text
                        .titleTextColor(R.color.white)      // Specify the color of the title text
                        .descriptionTextSize(18)            // Specify the size (in sp) of the description text
                        .descriptionTextColor(R.color.white)  // Specify the color of the description text
                        .textColor(R.color.white)            // Specify a color for both the title and description text
                        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                        .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)                   // Whether to draw a drop shadow or not
                        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(false)
                        .icon(myIcon)// Specify whether the target is transparent (displays the content underneath)
                        .targetRadius(60),                  // Specify the target radius (in dp)
                new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);


             i=2;


                    }
                });
    }

    private boolean havenetwork(){
        boolean have_wifi=false;
        boolean have_data=false;
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
        for(NetworkInfo info:networkInfos)
        {
            if(info.getTypeName().equalsIgnoreCase("WIFI"))
                if(info.isConnected())
                    have_wifi=true;
            if(info.getTypeName().equalsIgnoreCase("MOBILE"))
                if(info.isConnected())
                    have_data=true;

        }
        return have_data||have_wifi;
    }






}

