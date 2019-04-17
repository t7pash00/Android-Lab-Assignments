package project.demo.eggtimer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimeCountdownActivity extends AppCompatActivity {
TextView showtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_countdown);

        showtime = findViewById(R.id.time_count);

        int count_time = getIntent().getIntExtra("count_time", 0);
        count_time = count_time*1000;

        new CountDownTimer(count_time, 1000){

            public void onTick(long millisUntilFinished) {
                showtime.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                showtime.setText("done!");
            }
        }.start();

    }

    }