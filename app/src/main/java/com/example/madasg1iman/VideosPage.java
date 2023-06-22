package com.example.madasg1iman;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class VideosPage extends AppCompatActivity {
    private VideoView videoView1, videoView2, videoView3, videoView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        // Initialize the VideoViews
        videoView1 = findViewById(R.id.videoView1);
        videoView2 = findViewById(R.id.videoView2);
        videoView3 = findViewById(R.id.videoView3);
        videoView4 = findViewById(R.id.videoView4);

        // Set the video source for each VideoView
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.videotutorial1;

        // Set the video path for VideoView 1
        videoView1.setVideoURI(Uri.parse(videoPath));

        // Set the video path for VideoView 2
        videoView2.setVideoURI(Uri.parse(videoPath));

        // Set the video path for VideoView 3
        videoView3.setVideoURI(Uri.parse(videoPath));

        // Set the video path for VideoView 4
        videoView4.setVideoURI(Uri.parse(videoPath));

        // Start playing the videos
        videoView1.start();
        videoView2.start();
        videoView3.start();
        videoView4.start();
    }
}
