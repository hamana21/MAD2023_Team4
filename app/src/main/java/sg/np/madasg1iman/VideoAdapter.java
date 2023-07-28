package sg.np.madasg1iman;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madasg1iman.R;

import java.util.List;

import sg.np.madasg1iman.models.VideoModels;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<VideoModels> videoUrls;
    private Context context;

    public VideoAdapter(List<VideoModels> videoUrls, Context context) {
        this.videoUrls = videoUrls;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        String videoUrl = videoUrls.get(position).getLink();
        holder.videoView.setVideoURI(Uri.parse(videoUrl));
        holder.txtName.setText(videoUrls.get(position).getName());
        holder.videoView.pause();
    }

    @Override
    public int getItemCount() {
        return videoUrls.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        MediaController mediaController;
        TextView txtName;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.video_view);
            txtName = itemView.findViewById(R.id.txtName);
            mediaController = new MediaController(itemView.getContext());

            videoView.setMediaController(mediaController);
        }


    }
}

