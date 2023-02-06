package com.example.monecowatt;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Ecogestes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecogestes);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnmView);
        bottomNavigationView.setOnItemReselectedListener(navListener);

    }

    private final NavigationBarView.OnItemReselectedListener navListener = item -> {
        switch (item.getItemId()) {
            case R.id.miPrinc:
                Log.d(TAG, "change layout : main");
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                break;

            case R.id.miEcogestes:
                break;

            case R.id.miPropos:
                Log.d(TAG, "change layout : propos");
                Intent propos = new Intent(this, Propos.class);
                startActivity(propos);
                break;
        }
    };
}
