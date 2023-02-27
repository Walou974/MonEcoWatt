package com.example.monecowatt;

import android.content.Intent;
import android.os.Bundle;

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
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                break;

            case R.id.miEcogestes:
                break;

            case R.id.miPropos:
                Intent propos = new Intent(this, Propos.class);
                startActivity(propos);
                break;
        }
    };
}
