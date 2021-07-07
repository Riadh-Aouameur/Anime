package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS;

public class RadarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_chart);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        RadarChart radarChart = findViewById(R.id.radar);
        ArrayList<RadarEntry> arrayList= new ArrayList<>();
        arrayList.add(new RadarEntry(25));
        arrayList.add(new RadarEntry(30));
        arrayList.add(new RadarEntry(40));
        arrayList.add(new RadarEntry(50));
        arrayList.add(new RadarEntry(60));
        arrayList.add(new RadarEntry(80));
        RadarDataSet radarDataSet = new RadarDataSet(arrayList,"The number of anime views over the past years");

        radarDataSet.setColor(Color.RED);
        radarChart.setWebLineWidth(2f);
        radarDataSet.setValueTextColor(Color.RED);
        radarDataSet.setValueTextSize(16f);

        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSet);
        String strings[]={
                "2014",
                "2015",
                "2016",
                "2017",
                "2018",
                "2019",
        };
        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(strings));
        radarChart.setData(radarData);
        radarChart.getDescription().setEnabled(false);



    }
}