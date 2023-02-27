package com.example.monecowatt;

import android.content.Intent;
import android.os.Bundle;

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
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                break;

            case R.id.miEcogestes:
                Intent eco = new Intent(this, Ecogestes.class);
                startActivity(eco);
                break;

            case R.id.miPropos:
                break;
        }
    };
}
