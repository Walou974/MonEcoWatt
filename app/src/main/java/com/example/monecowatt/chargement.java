package com.example.monecowatt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class chargement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargement);


    }
    protected void onStart() {
        super.onStart();
        mockprogressbar(progress);
    }
    private ProgressBar progress;

    public void mockprogressbar (ProgressBar progress){

        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(1000);

        for(int i = 1; i < 11; ++i){
            try {
                Thread.sleep(10);
                progress.setProgress(i*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
