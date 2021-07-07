package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart2);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> arrayList= new ArrayList<>();
        arrayList.add(new BarEntry(2014,25));
        arrayList.add(new BarEntry(2015,30));
        arrayList.add(new BarEntry(2016,40));
        arrayList.add(new BarEntry(2017,50));
        arrayList.add(new BarEntry(2018,60));
        arrayList.add(new BarEntry(2019,80));

        BarDataSet barDataSet = new BarDataSet(arrayList,"The number of anime views over the past years");
        barDataSet.setColors(MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData= new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("View/Year");
        barChart.animateY(2000);
    }
}