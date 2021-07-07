package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class LineChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        LineChart lineChart = findViewById(R.id.chart);

        LineDataSet lineDataSet = new LineDataSet(data(),"The number of anime views over the past years");
        ArrayList<DataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();
        lineChart.getDescription().setText("View/Year");


    }
    private  ArrayList <Entry> data(){
        ArrayList <Entry> d = new ArrayList<>();

        d.add(new Entry(2014,25));
        d.add(new Entry(2015,30));
        d.add(new Entry(2016,40));
        d.add(new Entry(2017,50));
        d.add(new Entry(2018,60));
        d.add(new Entry(2019,80));
        return d;


    }
}