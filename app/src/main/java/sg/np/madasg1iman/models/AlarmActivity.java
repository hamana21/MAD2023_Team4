package sg.np.madasg1iman.models;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.madasg1iman.R;
import com.example.madasg1iman.databinding.ActivityAlarmBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

import sg.np.madasg1iman.HomePage;

public class AlarmActivity extends AppCompatActivity {

    private ActivityAlarmBinding binding;

    private MaterialTimePicker picker;

    private Calendar calendar;

    private AlarmManager alarmManager;

    private PendingIntent pendingintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlarmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createNotificationChannel();
        //what each button does
        binding.select.setOnClickListener(v -> showTimePicker());

        binding.setalarm.setOnClickListener(v -> setAlarm());

        binding.cancelalarm.setOnClickListener(v -> cancelAlarm());

    }

    private void cancelAlarm() {
        Intent intent = new Intent(this,AlarmReceiver.class);
        pendingintent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        if(alarmManager == null){
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }
        alarmManager.cancel(pendingintent);
        Toast.makeText(this,"Alarm Cancelled!",Toast.LENGTH_SHORT).show();
        Intent goback = new Intent(AlarmActivity.this, HomePage.class);
        startActivity(goback);
    }

    private void setAlarm() {
        //setting alarm
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent(this,AlarmReceiver.class);
            pendingintent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingintent);
            Toast.makeText(this,"Alarm Set!",Toast.LENGTH_SHORT).show();
            Intent goback = new Intent(AlarmActivity.this, HomePage.class);
            startActivity(goback);

    }


    private void showTimePicker() {
        // choose time
        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();


        picker.show(getSupportFragmentManager(),"educademy");

        picker.addOnPositiveButtonClickListener(v -> {
            if (picker.getHour()>12){
                    binding.select.setText(
                            //making it 12 hour clock/pm
                            String.format("%02d",(picker.getHour())-12)+" : "+String.format("%02d",picker.getMinute()+" PM")
                    );
            }
            else {
                binding.select.setText(picker.getHour() + " : " + picker.getMinute() + " AM");
            }

            //set the time
            calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
            calendar.set(Calendar.MINUTE,picker.getMinute());
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        });
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            //creating notification channel for AlarmReceiver
            CharSequence name = "educademyalarmchannel";
            String description = "Channel For Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("educademy",name,importance);
            channel.setDescription(description);

            NotificationManager notimanager = getSystemService(NotificationManager.class);
            notimanager.createNotificationChannel(channel);
        }
    }
}