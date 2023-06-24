package sg.np.madasg1iman;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madasg1iman.R;

public class VideosPage extends AppCompatActivity implements View.OnClickListener {

    private ImageView homeButton;
    private VideoView videoView1, videoView2, videoView3, videoView4;
    private TextView video1, video2, video3, video4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        // Initialize VideoViews
        videoView1 = findViewById(R.id.videoView1);
        videoView2 = findViewById(R.id.videoView2);
        videoView3 = findViewById(R.id.videoView3);
        videoView4 = findViewById(R.id.videoView4);

        // Initialize TextViews
        video1 = findViewById(R.id.video1);
        video2 = findViewById(R.id.video2);
        video3 = findViewById(R.id.video3);
        video4 = findViewById(R.id.video4);

        // Set click listeners for VideoViews and TextViews
        videoView1.setOnClickListener(this);
        videoView2.setOnClickListener(this);
        videoView3.setOnClickListener(this);
        videoView4.setOnClickListener(this);
        video1.setOnClickListener(this);
        video2.setOnClickListener(this);
        video3.setOnClickListener(this);
        video4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Check which view was clicked
        int id = view.getId();
        int videoResource = 0;

        // Determine the video resource based on the clicked view
        if (id == R.id.videoView1 || id == R.id.video1) {
            videoResource = R.raw.videotutorial1;
        } else if (id == R.id.videoView2 || id == R.id.video2) {
            videoResource = R.raw.videotutorial1;
        } else if (id == R.id.videoView3 || id == R.id.video3) {
            videoResource = R.raw.videotutorial1;
        } else if (id == R.id.videoView4 || id == R.id.video4) {
            videoResource = R.raw.videotutorial1;
        }

        // Play the video if a valid video resource is found
        if (videoResource != 0) {
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResource);
            playVideo(videoUri);
        }
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
        homeButton = findViewById(R.id.homebutton);

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
