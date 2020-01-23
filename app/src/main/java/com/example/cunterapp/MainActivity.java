package com.example.cunterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //  init var for view
    Button btnReset;
    ImageButton btnPlay;
    ImageButton btnPause;
    TextView tvCunter;
    //  init var in activity
    Integer cunter = 0;

    Timer timer = null;


    Integer s = 0;
    Integer m = 0;
    Integer h = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReset = findViewById(R.id.btnReset);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);


        tvCunter = findViewById(R.id.tvCunt);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer == null) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    cunter = cunter + 1;

                                    if (cunter > 1) {
                                        s = s + 1;
                                        if (s > 59) {
                                            m = m + 1;
                                            if (m > 59) {
                                                h = h + 1;
                                                m = 0;
                                            }
                                            s = 0;
                                        }
                                    }
                                    tvCunter.setText(h.toString() + " : " + m.toString() + " : " + s.toString());
                                }
                            });
                        }
                    }, 0, 1000);
                }
            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }


            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                    cunter = 0;
                    s = 0;
                    m = 0;
                    h = 0;
                    tvCunter.setText(h.toString() + " : " + m.toString() + " : " + s.toString());

                }
            }
        });


    }


}


