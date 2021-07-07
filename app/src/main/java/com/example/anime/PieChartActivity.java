package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        PieChart pieChart = findViewById(R.id.pie);
        ArrayList<PieEntry> arrayList= new ArrayList<>();
        arrayList.add(new PieEntry(25,"2014"));
        arrayList.add(new PieEntry(30,"2015"));
        arrayList.add(new PieEntry(40,"2016"));
        arrayList.add(new PieEntry(50,"2017"));
        arrayList.add(new PieEntry(60,"2018"));
        arrayList.add(new PieEntry(80,"2019"));

        PieDataSet pieDataSet = new PieDataSet(arrayList,"The number of anime views over the past years");
        pieDataSet.setColors(MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.setCenterText("");
        pieChart.getDescription().setEnabled(false);

        pieChart.animate();

    }
}