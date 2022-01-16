package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.differentuitest.progressAndBar.CircleProgressActivity;
import com.example.differentuitest.recyclerView.AddShowActivity;
import com.example.differentuitest.toolbar.NavigationDrawerWithToolbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView drawerWithToolbar, circleProgress, posTv, saModuleTv, roomCRUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerWithToolbar = findViewById(R.id.drawerWithToolbarId);
        circleProgress = findViewById(R.id.circleProgressTvId);
        posTv = findViewById(R.id.posTvId);
        saModuleTv = findViewById(R.id.saModuleTvId);
        roomCRUD = findViewById(R.id.roomCRUDId);


        drawerWithToolbar.setOnClickListener(this);
        circleProgress.setOnClickListener(this);
        posTv.setOnClickListener(this);
        saModuleTv.setOnClickListener(this);
        roomCRUD.setOnClickListener(this);

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
        if (v.getId() == R.id.saModuleTvId) {
            startActivity(new Intent(this, SalesDemoActivity.class));
        }
        if (v.getId() == R.id.roomCRUDId) {
            startActivity(new Intent(this, AddShowActivity.class));
        }
    }
}