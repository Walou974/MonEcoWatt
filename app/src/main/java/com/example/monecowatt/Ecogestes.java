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

public class Ecogestes extends AppCompatActivity {
    final dataHelper dataHelper = new dataHelper();
    FloatingActionButton refreshButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecogestes);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnmView);
        bottomNavigationView.setSelectedItemId(R.id.miEcogestes);
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
                break;

            case R.id.miPropos:
                Intent propos = new Intent(this, Propos.class);
                startActivity(propos);
                break;
        }
        return false;
    };
}
