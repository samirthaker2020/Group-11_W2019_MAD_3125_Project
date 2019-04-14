package com.example.group_11_mad3125_project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.group_11_mad3125_project.Controller.Login.Login;

public class Splash_screen extends AppCompatActivity {
    private ProgressBar pgsBar;
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.splash_screen);
        ImageView simpleImageView=(ImageView) findViewById(R.id.splashicon);
        simpleImageView.setImageResource(R.drawable.splashicon);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LoginIntent = new Intent(Splash_screen.this, Login.class);
                startActivity(LoginIntent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }

    }
