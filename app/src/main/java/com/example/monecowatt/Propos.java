package com.example.monecowatt;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Propos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.complete_test);
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
                Log.d(TAG, "change layout : eco");
                Intent eco = new Intent(this, Ecogestes.class);
                startActivity(eco);
                break;

            case R.id.miPropos:
                break;
        }
    };
}
