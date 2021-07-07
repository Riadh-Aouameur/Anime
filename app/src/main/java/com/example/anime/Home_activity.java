package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Home_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }


    public void onOpenBarChart(View view) {
        startActivity(new Intent(Home_activity.this, BarChartActivity.class));
    }
    public void onOpenRadarChart(View view) {
        startActivity(new Intent(Home_activity.this, RadarChartActivity.class));
    }
    public void onOpenLineChart(View view) {
        startActivity(new Intent(Home_activity.this,LineChartActivity.class));
    }
    public void onOpenPieChart(View view) {
        startActivity(new Intent(Home_activity.this, PieChartActivity.class));
    }
}