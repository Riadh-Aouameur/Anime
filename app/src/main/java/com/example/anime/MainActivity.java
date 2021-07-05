package com.example.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView a;
    ImageView n;
    ImageView i;
    ImageView m;
    ImageView e;
    Animation aa;
    Animation nn;
    Animation mm;
    Animation ee;
    Animation ii;
    TextView t1, t2;
    Button btn;
    Animation bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        a = findViewById(R.id.a);
        n = findViewById(R.id.n);
        i = findViewById(R.id.i);
        m = findViewById(R.id.m);
        e = findViewById(R.id.e);
        btn = findViewById(R.id.btn);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);

        aa = AnimationUtils.loadAnimation(this, R.anim.a);
        nn = AnimationUtils.loadAnimation(this, R.anim.n);
        mm = AnimationUtils.loadAnimation(this, R.anim.m);
        ee = AnimationUtils.loadAnimation(this, R.anim.e);
        ii = AnimationUtils.loadAnimation(this, R.anim.i);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);


        btn.setAnimation(bottom);
        t1.setAnimation(bottom);
        t2.setAnimation(bottom);
        a.setAnimation(aa);
        n.setAnimation(nn);
        m.setAnimation(mm);
        i.setAnimation(ii);
        e.setAnimation(ee);

    }

    public void onSignIn(View view) {

        startActivity(new Intent(MainActivity.this, SignInActivity.class));
    }

    public void onSignUp(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }
}