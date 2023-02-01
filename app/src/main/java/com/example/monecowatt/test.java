package com.example.monecowatt;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class test extends AppCompatActivity {
    TextView midToTwo,
            twoToFour,
            fourToSix,
            sixToEight,
            eightToTen,
            tenToTwelve,
            twelveToFourteen,
            fourteenToSixteen,
            sixteenToEighteen,
            eighteenToTwenty,
            twentyToTwentytwo,
            twentytwoToMid;
    PieChart pieChart;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_test);
        // find each part of the slice to put values
        midToTwo = findViewById(R.id.midToTwo);
        twoToFour = findViewById(R.id.twoToFour);
        fourToSix = findViewById(R.id.fourToSix);
        sixToEight = findViewById(R.id.sixToEight);
        eightToTen = findViewById(R.id.eightToTen);
        tenToTwelve = findViewById(R.id.tenToTwelve);
        twelveToFourteen = findViewById(R.id.twelveToFourteen);
        fourteenToSixteen = findViewById(R.id.fourteenToSixteen);
        sixteenToEighteen = findViewById(R.id.sixteenToEighteen);
        eighteenToTwenty = findViewById(R.id.eighteenToTwenty);
        twentyToTwentytwo = findViewById(R.id.twentyToTt);
        twentytwoToMid = findViewById(R.id.ttToMid);

        pieChart = findViewById(R.id.piechart);

        setData();
    }
    private void setData(){
        // Set the percentage of language used
        midToTwo.setText(Integer.toString(100/12));
        twoToFour.setText(Integer.toString(100/12));
        fourToSix.setText(Integer.toString(100/12));
        sixToEight.setText(Integer.toString(100/12));
        eightToTen.setText(Integer.toString(100/12));
        tenToTwelve.setText(Integer.toString(100/12));
        twelveToFourteen.setText(Integer.toString(100/12));
        fourteenToSixteen.setText(Integer.toString(100/12));
        sixteenToEighteen.setText(Integer.toString(100/12));
        eighteenToTwenty.setText(Integer.toString(100/12));
        twentyToTwentytwo.setText(Integer.toString(100/12));
        twentytwoToMid.setText(Integer.toString(100/12));

        // Set the data and color to the pie chart

        // colors:
        int red = ContextCompat.getColor(this, R.color.rouge_al);
        int green = ContextCompat.getColor(this, R.color.vert_al);
        int yellow = ContextCompat.getColor(this, R.color.jaune_al);

        // data:
        pieChart.addPieSlice(
                new PieModel(
                        "00h-2h",
                        Integer.parseInt(midToTwo.getText().toString()),
                        red));
        pieChart.addPieSlice(
                new PieModel(
                        "2h-4h",
                        Integer.parseInt(twoToFour.getText().toString()),
                        green));
        pieChart.addPieSlice(
                new PieModel(
                        "4h-6h",
                        Integer.parseInt(fourToSix.getText().toString()),
                        yellow));
        pieChart.addPieSlice(
                new PieModel(
                        "6h-8h",
                        Integer.parseInt(sixToEight.getText().toString()),
                        green));
        pieChart.addPieSlice(
                new PieModel(
                        "8h-10h",
                        Integer.parseInt(eightToTen.getText().toString()),
                        yellow));
        pieChart.addPieSlice(
                new PieModel(
                        "10h-12h",
                        Integer.parseInt(tenToTwelve.getText().toString()),
                        green));
        pieChart.addPieSlice(
                new PieModel(
                        "12h-14h",
                        Integer.parseInt(twelveToFourteen.getText().toString()),
                        red));
        pieChart.addPieSlice(
                new PieModel(
                        "14h-16h",
                        Integer.parseInt(fourteenToSixteen.getText().toString()),
                        green));
        pieChart.addPieSlice(
                new PieModel(
                        "16h-18h",
                        Integer.parseInt(sixteenToEighteen.getText().toString()),
                        yellow));
        pieChart.addPieSlice(
                new PieModel(
                        "18h-20h",
                        Integer.parseInt(eighteenToTwenty.getText().toString()),
                        red));
        pieChart.addPieSlice(
                new PieModel(
                        "20h-22h",
                        Integer.parseInt(twentyToTwentytwo.getText().toString()),
                        green));
        pieChart.addPieSlice(
                new PieModel(
                        "22h-24h",
                        Integer.parseInt(twentytwoToMid.getText().toString()),
                        yellow));
    }
}


