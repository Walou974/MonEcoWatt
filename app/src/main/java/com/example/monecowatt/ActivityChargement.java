package com.example.monecowatt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityChargement extends AppCompatActivity {
    TextView display;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargement);

        display = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onStart(){
        super.onStart();
        mockprogressbar(progressBar);
    }

    int progressBarStatus = 0;
    int avance = 0;
    public void mockprogressbar (ProgressBar progress){
        new Thread(new Runnable() {
            @Override
            public void run() {
                connexionStatus();
                while (progressBarStatus < 100){
                    progressBarStatus = connexionStatus();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress.post(() -> progress.setProgress(progressBarStatus));
                    if (progressBarStatus >= 100){
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent i = new Intent(ActivityChargement.this, MainActivity.class);
                        startActivity(i);
                    }
                }
            }
            private int connexionStatus() {
                avance = avance + 10;
                return avance;

            }
        }).start();

    }
}
