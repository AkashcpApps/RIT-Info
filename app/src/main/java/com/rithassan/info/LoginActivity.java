package com.rithassan.info;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sdsmdg.tastytoast.TastyToast;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;

import iammert.com.library.Status;
import iammert.com.library.StatusView;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences,temsandconditions;
    Boolean statusLocked=true;
    TextInputEditText studentusn;
    private String usn;
    TextView guestlogin,privacypolicy;
    ProgressDialog progressDialog;
    StatusView statusView;

int count=0;
    Button register;
    FirebaseAuth firebaseAuth;

    private static final int NOTIFICATION_ID = 1;
    private static final String NOTIFICATION_CHANNEL_ID="my_notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        guestlogin=(TextView)findViewById(R.id.guestlogin);
        guestlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,GuestLogin.class));
                finish();
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        privacypolicy=(TextView)findViewById(R.id.privacypolicy);
        privacypolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://gogetyourwork.000webhostapp.com/rit/")));

            }
        });
        studentusn=(TextInputEditText)findViewById(R.id.usntext);
        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usn=studentusn.getText().toString().trim();
                if(studentusn.getText().toString().isEmpty()){
                    studentusn.setError("Enter the USN");
                    studentusn.requestFocus();

                    YoYo.with(Techniques.Tada).duration(200).repeat(1)
                            .playOn(findViewById(R.id.usn));
                    return;

                }else {

                    try{
                    if (usn.matches("[4]{1}[Rr]{1}[Aa]{1}[1]{1}[456789]{1}[MmCcEeIi]{1}[EeVvCcSs]{1}[0-9]{3}")) {
                        String last3 = usn.substring(usn.length() - 3);//002,123
                        String branch = usn.substring(5, 7).toUpperCase();//cs ec me

                        if (branch.equals("EC") || branch.equals("EE") || branch.equals("IS")) {
                            String eceeis = usn.substring(usn.length() - 3);
                                sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("name", usn);
                                editor.apply();


                                progressDialog=new ProgressDialog(LoginActivity.this);
                                progressDialog.setTitle("Logging with USN "+usn);
                                progressDialog.setMessage("Please wait...");
                                progressDialog.setCancelable(false);
                                progressDialog.show();
                                firebaseAuth.signInAnonymously().addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            progressDialog.dismiss();
                                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                            startActivity(i);
                                            notification();
                                            finish();

                                        } else {
                                            progressDialog.dismiss();
                                            TastyToast.makeText(getApplicationContext(), "Failed Login....!", TastyToast.LENGTH_LONG, TastyToast.ERROR);

                                        }

                                    }
                                });


                        } else if (branch.equals("CS") || branch.equals("ME") || branch.equals("CV")) {

                                sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("name", usn);
                                editor.apply();


                                progressDialog=new ProgressDialog(LoginActivity.this);
                                progressDialog.setTitle("Logging with USN "+usn);
                                progressDialog.setMessage("Please wait...");
                                progressDialog.setCancelable(false);
                                progressDialog.show();
                                firebaseAuth.signInAnonymously().addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            progressDialog.dismiss();
                                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                            startActivity(i);
                                            notification();
                                            finish();


                                        } else {
                                            progressDialog.dismiss();
                                            TastyToast.makeText(getApplicationContext(), "Failed Login....!", TastyToast.LENGTH_LONG, TastyToast.ERROR);

                                        }

                                    }
                                });


                        }

                    }
                    else if(usn.matches("[4]{1}[Rr]{1}[Aa]{1}[MmCcEeIi]{1}[EeVvCcSs]{1}0001234"))//Faculty Login
                    {
                        Toast.makeText(LoginActivity.this, "Faculty Loged in", Toast.LENGTH_LONG).show();
                        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name", usn);
                        editor.apply();
                        progressDialog=new ProgressDialog(LoginActivity.this);
                        progressDialog.setTitle("Logging with USN "+usn);
                        progressDialog.setMessage("Please wait...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        firebaseAuth.signInAnonymously().addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(i);
                                    notification();
                                    finish();


                                } else {
                                    progressDialog.dismiss();
                                    TastyToast.makeText(getApplicationContext(), "Failed Login....!", TastyToast.LENGTH_LONG, TastyToast.ERROR);

                                }

                            }
                        });



                        }

                    else {
                        if(count==4){
                            TastyToast.makeText(getApplicationContext(), "Many Attempts", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
                            register.setEnabled(false);
                            register.setVisibility(View.INVISIBLE);
                            Toast toast= Toast.makeText(LoginActivity.this,
                                    "Many Attempts", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
                            toast.show();
                          //  TastyToast.makeText(getApplicationContext(), "Many Attempts", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
                        }
                        count++;
                        studentusn.setError("Invalid USN");
                        studentusn.requestFocus();
                        YoYo.with(Techniques.Tada).duration(200).repeat(1)
                                .playOn(findViewById(R.id.name));
                        return;

                    }
                    }catch (Exception e){
                        if(count==4){
                            TastyToast.makeText(getApplicationContext(), "Many Attempts", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
                            register.setEnabled(false);
                            register.setVisibility(View.INVISIBLE);
                            Toast toast= Toast.makeText(LoginActivity.this,
                                    "Many Attempts", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
                            toast.show();


                        }
                        count++;
                        TastyToast.makeText(getApplicationContext(), "Invalid USN", TastyToast.LENGTH_LONG, TastyToast.ERROR);}



                }


            }

        });



    }
    private void notification()
    {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntentsd = PendingIntent.getActivity(LoginActivity.this, 0, mainIntent, PendingIntent.FLAG_ONE_SHOT);
        TastyToast.makeText(getApplicationContext(), "Welcome ...!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{ 3000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this, NOTIFICATION_CHANNEL_ID)
                .setVibrate(new long[]{0})
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setSmallIcon(R.mipmap.rit_info_logo)
                .setContentIntent(pendingIntentsd)

                .setContentTitle("Rajeev Institute of Technology")
                .setContentText("Welcome");


        notificationManager.notify(NOTIFICATION_ID, builder.build());

        MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.record_on);
        mediaPlayer.start();
        LoginActivity.this.finish();


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

            if (user != null) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);


                  }
                  else {
                      temsandconditions= PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                if(!temsandconditions.getBoolean("firstTime", false)) {
                    // run your one time code here
                    new FancyAlertDialog.Builder(LoginActivity.this)
                            .setTitle("Rajeev Institute of Technology")
                            .setBackgroundColor(Color.parseColor("#48c6ef"))
                            .setMessage("Please read these Terms and Conditions carefully before using the RIT Info mobile application operated by Rajeev Institute of Technology Hassan ®.\n" +
                                    "Our services are for information and education purpose only. Misuse of the services for the commercial benefits are illegal and actions would be taken if any discrepancies found.\n" +
                                    "All the Images and Vector Assets are subjected to copyrights. Using a part or whole resource is not entertained. The sole ownership of the documents lies under the RIT. No third Party shall copy the content for the commercial use.")
                            .setNegativeBtnText("Exit")
                            .setPositiveBtnBackground(Color.parseColor("#008577"))
                            .setPositiveBtnText("Agree")
                            .setNegativeBtnBackground(Color.parseColor("#FFFF0000"))
                            .setAnimation(Animation.POP)
                            .isCancellable(false)
                            .OnPositiveClicked(new FancyAlertDialogListener() {
                                @Override
                                public void OnClick() {

                                }
                            })
                            .OnNegativeClicked(new FancyAlertDialogListener() {
                                @Override
                                public void OnClick() {
                                    LoginActivity.this.finish();
                                }
                            })
                            .build();
                    SharedPreferences.Editor editor = temsandconditions.edit();
                    editor.putBoolean("firstTime", true);
                    editor.commit();
                }

            }


        }








    }









