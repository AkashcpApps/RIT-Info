package com.rithassan.info;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstScreen extends AppCompatActivity {
    TextView rittxt;
    ImageView ritimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rittxt=(TextView)findViewById(R.id.rittext);
        ritimage=(ImageView) findViewById(R.id.imageView3);
        ritimage.setAnimation(AnimationUtils.loadAnimation(FirstScreen.this, R.anim.zoom));
        rittxt.setAnimation(AnimationUtils.loadAnimation(FirstScreen.this, R.anim.from_bottom));
        getSupportActionBar().hide();
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }
    private class LogoLauncher extends Thread {
        public void run() {
            try {
                sleep(2000);
                Intent intent=new Intent(FirstScreen.this,LoginActivity.class);
                startActivity(intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            FirstScreen.this.finish();
        }
    }

}
