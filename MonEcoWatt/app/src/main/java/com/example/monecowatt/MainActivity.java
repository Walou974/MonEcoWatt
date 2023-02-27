package com.example.monecowatt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "MySharedPref";

    PieChart todayPieChart, tomPieChart, aftTomPieChart;
    TextView todayTitle, tommorowTitle, afterTommorowTitle;
    ArrayList<String> todtab, tomtab, afttomtab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extra = getIntent().getExtras();
        if(extra != null){
            this.todtab = extra.getStringArrayList("todtab");
            this.tomtab = extra.getStringArrayList("tomtab");
            this.afttomtab = extra.getStringArrayList("afttomtab");
            saveData();

        }else {
            this.todtab = new ArrayList<String>();
            this.tomtab = new ArrayList<String>();
            this.afttomtab = new ArrayList<String>();
            loadData();

        }

        todayPieChart = findViewById(R.id.todayPiechart);
        tomPieChart = findViewById(R.id.tommorowPiechart);
        aftTomPieChart = findViewById(R.id.afterTommorowPiechart);
        todayTitle = findViewById(R.id.todayTitle);
        tommorowTitle = findViewById(R.id.tommorowTitle);
        afterTommorowTitle = findViewById(R.id.afterTommorowTitle);
        BottomNavigationView bottomNav = findViewById(R.id.bnmView);
        bottomNav.setOnItemReselectedListener(navListener);

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
                Intent j = new Intent(this, Ecogestes.class);
                startActivity(j);
                break;
            case R.id.miPropos:
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


        // Add pieChart slice
        for (int i = 0; i < 24; i++){
            todayPieChart.addPieSlice(new PieModel(partSize,setColor(Integer.parseInt(todtab.get(i)))));
            tomPieChart.addPieSlice(new PieModel(partSize,setColor(Integer.parseInt(tomtab.get(i)))));
            aftTomPieChart.addPieSlice(new PieModel(partSize,setColor(Integer.parseInt(afttomtab.get(i)))));
        }
        todayPieChart.startAnimation();
        tomPieChart.startAnimation();
        aftTomPieChart.startAnimation();
    }

    public void saveData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("todtab",todtab.toString());
        editor.putString("tomtab",tomtab.toString());
        editor.putString("afttomtab",afttomtab.toString());
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String tmplist = sharedPreferences.getString("todtab", "");
        for (int i = 0; i < tmplist.length(); i++) {
            String tmp = Character.toString(tmplist.charAt(i));
            if (!tmp.equals("[") && !tmp.equals(",") && !tmp.equals(" ") && !tmp.equals("]")) {
                this.todtab.add(tmp);
            }
        }

        String tmplist2 = sharedPreferences.getString("tomtab", "");
        for (int i = 0; i < tmplist2.length(); i++) {
            String tmp = Character.toString(tmplist2.charAt(i));
            if (!tmp.equals("[") && !tmp.equals(",") && !tmp.equals(" ") && !tmp.equals("]")) {
                this.tomtab.add(tmp);
            }

        }

        String tmplist3 = sharedPreferences.getString("afttomtab", "");
        for (int i = 0; i < tmplist3.length(); i++) {
            String tmp = Character.toString(tmplist3.charAt(i));
            if (!tmp.equals("[") && !tmp.equals(",") && !tmp.equals(" ") && !tmp.equals("]")) {
                this.afttomtab.add(tmp);
            }

        }
    }
 }

