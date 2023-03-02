package com.example.monecowatt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActivityChargement extends AppCompatActivity {
    TextView display;
    ProgressBar progressBar;
    Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargement);

        display = findViewById(R.id.textView);
        display.setVisibility(View.INVISIBLE);
        progressBar = findViewById(R.id.progressBar);
        start_button = findViewById(R.id.start_button);
    }

    public void getvalues(View view) {
        mockprogressbar(progressBar);
        start_button.setVisibility(View.INVISIBLE);
        display.setVisibility(View.VISIBLE);
    }


    int avance = 0;
    final List<String> todtab = new ArrayList<>();
    final List<String> tomtab = new ArrayList<>();
    final List<String> afttomtab = new ArrayList<>();

    private void connexionStatus() throws MalformedURLException {

        String baseUrl = "http://isis.unice.fr/~ga103969/ext/saejava/.dump/";

        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j <= 24; j++) {
                String finalUrl = baseUrl + i + "_LastVars/" + j + "h";
                URL u = new URL(finalUrl);

                try {
                    Scanner s = new Scanner(u.openStream());
                    switch(i){
                        case 0:
                            todtab.add(s.nextLine());
                            avance = avance + 1;
                            break;
                        case 1:
                            tomtab.add(s.nextLine());
                            avance = avance + 1;
                            break;
                        case 2:
                            afttomtab.add(s.nextLine());
                            avance = avance + 1;
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }


    }


    public void mockprogressbar (ProgressBar progress) {
        //1st thread : barre de progession
        new Thread(() -> {
            while (avance < 100) {
                progress.post(() -> progress.setProgress(avance));
                if (avance >= 72) {
                    avance = 100;
                    progress.post(() -> progress.setProgress(avance));
                    Intent i = new Intent(ActivityChargement.this, MainActivity.class);
                    i.putExtra("todtab", (ArrayList<String>) todtab);
                    i.putExtra("tomtab", (ArrayList<String>) tomtab);
                    i.putExtra("afttomtab", (ArrayList<String>) afttomtab);
                    startActivity(i);
                }
            }
        }).start();
        //2nd thread : connexion
        new Thread(() -> {
            try {
                connexionStatus();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }).start();
    }
}



