package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.differentuitest.helper.LocalHelper;
import com.example.differentuitest.progressAndBar.CircleProgressActivity;
import com.example.differentuitest.recyclerView.AddShowActivity;
import com.example.differentuitest.toolbar.NavigationDrawerWithToolbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView drawerWithToolbar, circleProgress, posTv, saModuleTv, roomCRUD, posPrint;
    Button btnBangla, btnEnglish;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerWithToolbar = findViewById(R.id.drawerWithToolbarId);
        circleProgress = findViewById(R.id.circleProgressTvId);
        posTv = findViewById(R.id.posTvId);
        saModuleTv = findViewById(R.id.saModuleTvId);
        roomCRUD = findViewById(R.id.roomCRUDId);
        posPrint = findViewById(R.id.posPrintId);
        btnBangla = findViewById(R.id.setLangBangla);
        btnEnglish = findViewById(R.id.setLangEnglish);


        drawerWithToolbar.setOnClickListener(this);
        circleProgress.setOnClickListener(this);
        posTv.setOnClickListener(this);
        saModuleTv.setOnClickListener(this);
        roomCRUD.setOnClickListener(this);
        posPrint.setOnClickListener(this);

        btnBangla.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);

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
        if (v.getId() == R.id.posPrintId) {
            startActivity(new Intent(this, PosPrintActivity.class));
        }

        if (v.getId() == R.id.setLangEnglish) {
            context = LocalHelper.setLocale(MainActivity.this, "en");
            resources = context.getResources();
            drawerWithToolbar.setText(resources.getString(R.string.nav_drawer_toolbar));
            circleProgress.setText(resources.getString(R.string.circle_progressbar));
            posTv.setText(resources.getString(R.string.pos_page));
            saModuleTv.setText(resources.getString(R.string.sa_module));
            roomCRUD.setText(resources.getString(R.string.room_crud));
            btnEnglish.setVisibility(View.GONE);
            btnBangla.setVisibility(View.VISIBLE);
        }

        if (v.getId() == R.id.setLangBangla) {
            context = LocalHelper.setLocale(MainActivity.this, "bn");
            resources = context.getResources();
            drawerWithToolbar.setText(resources.getString(R.string.nav_drawer_toolbar));
            circleProgress.setText(resources.getString(R.string.circle_progressbar));
            posTv.setText(resources.getString(R.string.pos_page));
            saModuleTv.setText(resources.getString(R.string.sa_module));
            roomCRUD.setText(resources.getString(R.string.room_crud));
            btnBangla.setVisibility(View.GONE);
            btnEnglish.setVisibility(View.VISIBLE);
        }
    }
}