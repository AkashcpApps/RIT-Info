package com.rithassan.info;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sdsmdg.tastytoast.TastyToast;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;

public class GuestLogin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient2));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.guest_login, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            new FancyAlertDialog.Builder(this)
                    .setTitle("Rajeev Institute of Technology")
                    .setBackgroundColor(Color.parseColor("#48c6ef"))  //Don't pass R.color.colorvalue
                    .setMessage("Do you really want to Exit ?")
                    .setNegativeBtnText("Cancel")
                    .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
                    .setPositiveBtnText("Exit")
                    .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                    .setAnimation(Animation.POP)
                    .isCancellable(false)
                    .OnPositiveClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {
                            TastyToast.makeText(getApplicationContext(), "Sign Out...!", TastyToast.LENGTH_LONG, TastyToast.INFO);
                            finish();
                            Intent intent=new Intent(GuestLogin.this,LoginActivity.class);
                            startActivity(intent);                        }
                    })
                    .OnNegativeClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {
                        }
                    })
                    .build();        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            getSupportActionBar().setTitle("RIT Info");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Home()).commit();

        }

        else if (id == R.id.rit_blog) {
            getSupportActionBar().setTitle("RIT Blogs");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Blogs()).addToBackStack("FragmentB")
                    .commit();
        }else if (id == R.id.events_calender) {
            getSupportActionBar().setTitle("Events Calender");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new EventCalender()).addToBackStack("FragmentB")
                    .commit();
        }  else if (id == R.id.explore_rit) {
            getSupportActionBar().setTitle("Explore RIT");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Explore()).addToBackStack("FragmentB")
                    .commit();

        }

        else if (id == R.id.resuts) {
            String url = "https://cbcs.fastvturesults.com/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if (id == R.id.developer) {
            getSupportActionBar().setTitle("Developer");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Developer()).addToBackStack("FragmentB")
                    .commit();        }
        else if (id==R.id.contact){
            getSupportActionBar().setTitle("Contact Us");

            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new Contacts()).addToBackStack("FragmentB")
                    .commit();
        }
        else if(id==R.id.feedback){
            new FancyAlertDialog.Builder(this)
                    .setTitle("Rajeev Institute of Technology")
                    .setBackgroundColor(Color.parseColor("#48c6ef"))  //Don't pass R.color.colorvalue
                    .setMessage("Feedback and Suggestions for Development Purpose Only")
                    .setNegativeBtnText("Rate Us")
                    .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
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
                            PackageManager pm = getApplicationContext().getPackageManager();
                            Intent launchIntent = pm.getLaunchIntentForPackage("com.android.vending");
                            getApplicationContext().startActivity(launchIntent);
                        }
                    })
                    .build();

        }
        else if(id==R.id.shareapp){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "#RIT Info" + "\n" + "Get Complete Information of RIT\nLatest Updates\nComplete Student Details and much more\nGet it On Playstore";
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
    @Override
    protected void onStart() {
        super.onStart();
        getSupportActionBar().setTitle("RIT Info");
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new Home()).commit();
    }
}
