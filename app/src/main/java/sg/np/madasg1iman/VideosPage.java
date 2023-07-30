package sg.np.madasg1iman;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madasg1iman.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import sg.np.madasg1iman.models.VideoModels;

public class VideosPage extends AppCompatActivity implements View.OnClickListener {

    private ImageView homeButton;
    private VideoView videoView1, videoView2, videoView3, videoView4;
    private TextView video1, video2, video3, video4;
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<VideoModels> videoUrlsList;
    private ImageView imgFilter;
    private ArrayList<String> subject_list;
    private int selected_index = -1;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

//       initViews();


        subjectList();
        showSubjectAlertDialogue(0);
        recyclerView = findViewById(R.id.recyclerView);
        imgFilter = findViewById(R.id.imgFilter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        videoUrlsList = fetchNewList(-1);


        // Add video links to the list
        videoAdapter = new VideoAdapter(videoUrlsList, this);
        recyclerView.setAdapter(videoAdapter);

        imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSubjectAlertDialogue(1);
            }
        });


    }

    private void subjectList() {
        subject_list = new ArrayList<>();
        subject_list.add("English");
        subject_list.add("Math");
        subject_list.add("Science");

    }

    private void showSubjectAlertDialogue(int x) {
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(VideosPage.this);

        if (x == 0)
            alt_bld.setCancelable(false);
        else
            alt_bld.setCancelable(true);


        alt_bld.setIcon(R.drawable.baseline_filter_alt_24);
        alt_bld.setTitle("Select Subject");
        alt_bld.setSingleChoiceItems(subject_list.toArray(new String[0]), selected_index, (dialog, item) -> selected_index = item);

        alt_bld.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());

        alt_bld.setPositiveButton("Save", (dialogInterface, i) -> {
            if (selected_index != -1) {


                setSubject(selected_index);

                Toast.makeText(VideosPage.this, "Subject " + subject_list.get(selected_index), Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            } else {
                Toast.makeText(VideosPage.this, "Select Any Option First", Toast.LENGTH_SHORT).show();
            }

        });
        AlertDialog alert = alt_bld.create();
        if (!VideosPage.this.isFinishing()) {
            alert.show();
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private void setSubject(int i) {
        //refreshAdapter
        videoUrlsList = fetchNewList(i);

        videoAdapter = new VideoAdapter(videoUrlsList, VideosPage.this);
        videoAdapter.notifyDataSetChanged();

    }

    private List<VideoModels> fetchNewList(int i) {

        List<VideoModels> a = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String sub = "";

        switch (i) {
            case 0:
                sub = "english";
            case 1:
                sub = "math";
            case 2:
                sub = "science";
        }

        DatabaseReference myRef = null;
        if (i == -1)
            myRef = database.getReference("videos").child("english");
        else
            myRef = database.getReference("videos").child(sub);


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return a;
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
