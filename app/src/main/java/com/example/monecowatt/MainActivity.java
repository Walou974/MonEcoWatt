package com.example.monecowatt;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    PieChart todayPieChart, tomPieChart, aftTomPieChart;
    TextView todayTitle, tommorowTitle, afterTommorowTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todayPieChart = findViewById(R.id.todayPiechart);
        tomPieChart = findViewById(R.id.tommorowPiechart);
        aftTomPieChart = findViewById(R.id.afterTommorowPiechart);
        todayTitle = findViewById(R.id.todayTitle);
        tommorowTitle = findViewById(R.id.tommorowTitle);
        afterTommorowTitle = findViewById(R.id.afterTommorowTitle);
        BottomNavigationView bottomNav = findViewById(R.id.bnmView);
        bottomNav.setOnItemReselectedListener(navListener);
        Log.d(TAG, "onResume: changed layout ");
        setData();

    }
    private final NavigationBarView.OnItemReselectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected id
        // by using there id.
        switch (item.getItemId()){
            case R.id.miPrinc:
                break;

            case R.id.miEcogestes:
                Log.d(TAG, "change layout : test");
                Intent j = new Intent(this, Ecogestes.class);
                startActivity(j);
                break;
            case R.id.miPropos:
                Log.d(TAG, "change layout : Propos");
                Intent k = new Intent(this, Propos.class);
                startActivity(k);
                break;

        }
    };

    private int setColor(){
        return ContextCompat.getColor(this, R.color.notif);
    }

    private int setColor(int entry){
        int red = ContextCompat.getColor(this, R.color.rouge_al);
        int green = ContextCompat.getColor(this, R.color.vert_al);
        int yellow = ContextCompat.getColor(this, R.color.jaune_al);
        int blue = ContextCompat.getColor(this, R.color.notif);
        if(entry == 1){
            return green;
        }
        else if (entry == 2){
            return yellow;
        }
        else if (entry == 3){
            return red;
        }
        else{
            return blue;
        }
    }
    private void setData(){
        // set title
        Calendar c = Calendar.getInstance();

        // get today's date
        Date todayDate = c.getTime();
        DateFormat dateformatter = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        String todayFormattedDate = dateformatter.format(todayDate);

        // change date and get tommorow's
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date tommorowDate = c.getTime();
        String tommorowFormattedDate = dateformatter.format(tommorowDate);

        // change date and get after tommoro's
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date afterTommorowDate = c.getTime();
        String afterTommorowFormattedDate = dateformatter.format(afterTommorowDate);

        // set value of different textview for title
        todayTitle.setText(todayFormattedDate);
        tommorowTitle.setText(tommorowFormattedDate);
        afterTommorowTitle.setText(afterTommorowFormattedDate);

        // set slice size to 100% / nb of parts
        int partSize = 100/24;

        // set array color
        //TODO: change to array from server
        int[] todtab = {2, 1, 2, 1, 3, 3, 3, 3, 1, 2, 1, 2, 2, 2, 1, 1, 1, 3, 2, 3, 3, 3, 1, 2};
        int[] tomtab = {3, 3, 3, 1, 2, 1, 1, 3, 3, 1, 2, 1, 2, 2, 1, 2, 1, 2, 3, 1, 2, 3, 3, 2};
        int[] afttomtab = {1, 3, 1, 1, 1, 3, 3, 2, 1, 1, 2, 2, 3, 3, 1, 1, 3, 2, 3, 2, 3, 2, 2, 2};

        // Add pieChart slice
        for (int i = 0; i < 24; i++){
            todayPieChart.addPieSlice(new PieModel(partSize,setColor(todtab[i])));
            tomPieChart.addPieSlice(new PieModel(partSize,setColor(tomtab[i])));
            aftTomPieChart.addPieSlice(new PieModel(partSize,setColor(afttomtab[i])));
        }
        todayPieChart.startAnimation();
        tomPieChart.startAnimation();
        aftTomPieChart.startAnimation();
    }
}