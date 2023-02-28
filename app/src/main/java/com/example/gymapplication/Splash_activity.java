package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.VideoView;

public class Splash_activity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();



        videoView=findViewById(R.id.video_view1);

        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash_video));
        //  videoView.setVideoPath(R.raw.splash_video);

        videoView.requestFocus();

        videoView.start();

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run () {
                Intent intent = new Intent(Splash_activity.this, MainActivity.class);
                // intent = intent();
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
