package sg.np.madasg1iman;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.madasg1iman.R;

import sg.np.madasg1iman.AboutMe;
import sg.np.madasg1iman.ContactUsActivity;
import sg.np.madasg1iman.SelectEducationLevel;
import sg.np.madasg1iman.VideosPage;
import sg.np.madasg1iman.models.AlarmActivity;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton imageButton6 = rootView.findViewById(R.id.imageButton6);
        ImageButton imageButton7 = rootView.findViewById(R.id.imageButton7);
        ImageButton imageButton4 = rootView.findViewById(R.id.imageButton4);
        ImageButton imageButton5 = rootView.findViewById(R.id.imageButton5);
        ImageButton imageButton11 = rootView.findViewById(R.id.imageButton11);
        ImageButton imageButton10 = rootView.findViewById(R.id.imageButton10);

        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SelectEducationLevel activity
                Intent intent = new Intent(getActivity(), AlarmActivity.class);
                startActivity(intent);
            }
        });

        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SelectEducationLevel activity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SelectEducationLevel activity
                Intent intent = new Intent(getActivity(), SelectEducationLevel.class);
                startActivity(intent);
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the VideosPage activity
                Intent intent = new Intent(getActivity(), VideosPage.class);
                startActivity(intent);
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ContactUsActivity activity
                Intent intent = new Intent(getActivity(), ContactUsActivity.class);
                startActivity(intent);
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the AboutMe activity
                Intent intent = new Intent(getActivity(), AboutMe.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
