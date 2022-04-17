package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getSupportActionBar().hide();





        videoView= findViewById(R.id.video_view);
        MediaController mediaController=new MediaController (this);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName() + "/" + R.raw.poupanca_de_energia_h264_24984));
        videoView.start();



    }
}