package com.rithassan.info;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;

import org.jsoup.Jsoup;
public class AppUpdateChecker {
    private Activity activity;
    public AppUpdateChecker(Activity activity) {
        this.activity = activity;
    }
    //current version of app installed in the device
    private String getCurrentVersion(){
        PackageManager pm = activity.getPackageManager();
        PackageInfo pInfo = null;
        try {
            pInfo = pm.getPackageInfo(activity.getPackageName(),0);
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        return pInfo.versionName;
    }
    private class GetLatestVersion extends AsyncTask<String, String, String> {
        private String latestVersion;
        private ProgressDialog progressDialog;
        private boolean manualCheck;
        GetLatestVersion(boolean manualCheck) {
            this.manualCheck = manualCheck;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (manualCheck)
            {
                if (progressDialog!=null)
                {
                    if (progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                    }
                }
            }
            String currentVersion = getCurrentVersion();
            //If the versions are not the same
            if(!currentVersion.equals(latestVersion)&&latestVersion!=null){




















                new FancyAlertDialog.Builder(activity)
                        .setTitle("Rajeev Institute of Technology")
                        .setBackgroundColor(Color.parseColor("#48c6ef"))
                        .setMessage("A New Update Available\nGet It On PlaySore")
                        .setNegativeBtnText("Close")
                        .setPositiveBtnBackground(Color.parseColor("#008577"))
                        .setPositiveBtnText("Update Now")
                        .setNegativeBtnBackground(Color.parseColor("#FFFF0000"))
                        .setAnimation(Animation.POP)
                        .isCancellable(false)
                        .OnPositiveClicked(new FancyAlertDialogListener() {
                            @Override
                            public void OnClick() {
                                Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.rithassan.info"));
                               activity. startActivity(i);
                            }
                        })
                        .OnNegativeClicked(new FancyAlertDialogListener() {
                            @Override
                            public void OnClick() {

                            }
                        })
                        .build();




            }
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (manualCheck) {
                progressDialog=new ProgressDialog(activity);
                progressDialog.setMessage("Checking For Update.....");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        }
        @Override
        protected String doInBackground(String... params) {
            try {
                //It retrieves the latest version by scraping the content of current version from play store at runtime
                latestVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + activity.getPackageName() + "&hl=it")
                        .timeout(30000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get()
                        .select(".hAyfc .htlgb")
                        .get(7)
                        .ownText();
                return latestVersion;
            } catch (Exception e) {
                return latestVersion;
            }
        }
    }
    public void checkForUpdate(boolean manualCheck)
    {
        new GetLatestVersion(manualCheck).execute();
    }
}