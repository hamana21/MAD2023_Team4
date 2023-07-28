package sg.np.madasg1iman;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madasg1iman.R;

import java.util.ArrayList;
import java.util.List;

import sg.np.madasg1iman.models.VideoModels;

public class VideosPage extends AppCompatActivity implements View.OnClickListener {

    private ImageView homeButton;
    private VideoView videoView1, videoView2, videoView3, videoView4;
    private TextView video1, video2, video3, video4;
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<VideoModels> videoUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

//       initViews();


        recyclerView = findViewById(R.id.recyclerView);
        videoUrls = new ArrayList<>();
        // Add video links to the list
        videoUrls.add(new VideoModels("https://vod-progressive.akamaized.net/exp=1690560727~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1725%2F7%2F183629075%2F604232968.mp4~hmac=3b17bec0ce8b126ea853ed3c026c426629c46351da71e4f9a18c9d93ab4ce8ac/vimeo-prod-skyfire-std-us/01/1725/7/183629075/604232968.mp4?filename=file.mp4","Math lesson# 1"));
        videoUrls.add(new VideoModels("https://vod-progressive.akamaized.net/exp=1690560727~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1725%2F7%2F183629075%2F604232968.mp4~hmac=3b17bec0ce8b126ea853ed3c026c426629c46351da71e4f9a18c9d93ab4ce8ac/vimeo-prod-skyfire-std-us/01/1725/7/183629075/604232968.mp4?filename=file.mp4","Math lesson# 1"));
        videoUrls.add(new VideoModels("https://vod-progressive.akamaized.net/exp=1690560727~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1725%2F7%2F183629075%2F604232968.mp4~hmac=3b17bec0ce8b126ea853ed3c026c426629c46351da71e4f9a18c9d93ab4ce8ac/vimeo-prod-skyfire-std-us/01/1725/7/183629075/604232968.mp4?filename=file.mp4","Math lesson# 1"));
        videoUrls.add(new VideoModels("https://vod-progressive.akamaized.net/exp=1690560727~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1725%2F7%2F183629075%2F604232968.mp4~hmac=3b17bec0ce8b126ea853ed3c026c426629c46351da71e4f9a18c9d93ab4ce8ac/vimeo-prod-skyfire-std-us/01/1725/7/183629075/604232968.mp4?filename=file.mp4","Math lesson# 1"));


        videoAdapter = new VideoAdapter(videoUrls, this);
        recyclerView.setAdapter(videoAdapter);


    }


    @Override
    public void onClick(View view) {
//        // Check which view was clicked
//        int id = view.getId();
//        int videoResource = 0;
//
//        // Determine the video resource based on the clicked view
//        if (id == R.id.videoView1 || id == R.id.video1) {
//            videoResource = R.raw.videotutorial1;
//        } else if (id == R.id.videoView2 || id == R.id.video2) {
//            videoResource = R.raw.videotutorial1;
//        } else if (id == R.id.videoView3 || id == R.id.video3) {
//            videoResource = R.raw.videotutorial1;
//        } else if (id == R.id.videoView4 || id == R.id.video4) {
//            videoResource = R.raw.videotutorial1;
//        }
//
//        // Play the video if a valid video resource is found
//        if (videoResource != 0) {
//            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResource);
//            playVideo(videoUri);
//        }
    }

    private void playVideo(Uri videoUri) {
        // Set the video URI for the VideoView
        videoView1.setVideoURI(videoUri);

        // Start video playback
        videoView1.start();

        // Add a completion listener to release the MediaPlayer resources
        videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // Release the MediaPlayer resources
                videoView1.stopPlayback();
                mediaPlayer.release();
            }
        });
//        homeButton = findViewById(R.id.homebutton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the homepage activity or XML
                Intent intent = new Intent(VideosPage.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
