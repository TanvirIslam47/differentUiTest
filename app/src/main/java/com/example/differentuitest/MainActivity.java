package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.differentuitest.progressAndBar.CircleProgressActivity;
import com.example.differentuitest.toolbar.NavigationDrawerWithToolbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView drawerWithToolbar, circleProgress, posTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerWithToolbar = findViewById(R.id.drawerWithToolbarId);
        circleProgress = findViewById(R.id.circleProgressTvId);
        posTv = findViewById(R.id.posTvId);


        drawerWithToolbar.setOnClickListener(this);
        circleProgress.setOnClickListener(this);
        posTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.drawerWithToolbarId) {
            startActivity(new Intent(this, NavigationDrawerWithToolbarActivity.class));
        }
        if (v.getId() == R.id.circleProgressTvId) {
            startActivity(new Intent(this, CircleProgressActivity.class));
        }
        if (v.getId() == R.id.posTvId) {
            startActivity(new Intent(this, PosActivity.class));
        }
    }
}