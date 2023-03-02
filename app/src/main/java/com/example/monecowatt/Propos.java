package com.example.monecowatt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.net.MalformedURLException;

public class Propos extends AppCompatActivity {
    final dataHelper dataHelper = new dataHelper();
    FloatingActionButton refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_a_propos);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnmView);
        bottomNavigationView.setSelectedItemId(R.id.miPropos);
        refreshButton = findViewById(R.id.fab);

        bottomNavigationView.setOnItemSelectedListener(navListener);
    }

    public void refreshData(View view) throws MalformedURLException {
        dataHelper.refreshData(this);
        Toast.makeText(this, "Refreshing data ...",Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    private final NavigationBarView.OnItemSelectedListener navListener = item -> {
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
        return false;
    };
}
