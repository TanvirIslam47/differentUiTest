package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.differentuitest.bottomNavigation.BottomNavigationUiListActivity;
import com.example.differentuitest.bottomNavigation.SmoothBottomNavigationActivity;
import com.example.differentuitest.helper.LocalHelper;
import com.example.differentuitest.login.LoginUiActivity;
import com.example.differentuitest.progressAndBar.CircleProgressActivity;
import com.example.differentuitest.recyclerView.AddShowActivity;
import com.example.differentuitest.toolbar.NavigationDrawerWithToolbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView drawerWithToolbar, bottomNavigation, circleProgress, posTv,
            saModuleTv, roomCRUD, posPrint, loginTV, saTv, mapsTv, cartTv, deviceInfoTv,
            commaString;
    Button btnBangla, btnEnglish;
    Context context;
    Resources resources;

    String sub = "12,123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerWithToolbar = findViewById(R.id.drawerWithToolbarId);
        bottomNavigation = findViewById(R.id.bottomNavigationId);
        circleProgress = findViewById(R.id.circleProgressTvId);
        posTv = findViewById(R.id.posTvId);
        saModuleTv = findViewById(R.id.saModuleTvId);
        roomCRUD = findViewById(R.id.roomCRUDId);
        posPrint = findViewById(R.id.posPrintId);
        loginTV = findViewById(R.id.loginTV);
        saTv = findViewById(R.id.saTvId);
        mapsTv = findViewById(R.id.mapTvId);
        cartTv = findViewById(R.id.cartTvId);
        deviceInfoTv = findViewById(R.id.deviceInfoTvId);
        btnBangla = findViewById(R.id.setLangBangla);
        btnEnglish = findViewById(R.id.setLangEnglish);
//        commaString = findViewById(R.id.commaStringId);

//        int amount;
//        amount = Integer.parseInt(sub.replaceAll(",", ""));
//        Toast.makeText(this, "value: "+amount, Toast.LENGTH_SHORT).show();
//        commaString.setText(String.valueOf(amount));


        drawerWithToolbar.setOnClickListener(this);
        bottomNavigation.setOnClickListener(this);
        circleProgress.setOnClickListener(this);
        posTv.setOnClickListener(this);
        saModuleTv.setOnClickListener(this);
        roomCRUD.setOnClickListener(this);
        posPrint.setOnClickListener(this);
        loginTV.setOnClickListener(this);
        saTv.setOnClickListener(this);
        mapsTv.setOnClickListener(this);
        cartTv.setOnClickListener(this);
        deviceInfoTv.setOnClickListener(this);

        btnBangla.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.drawerWithToolbarId) {
            startActivity(new Intent(this, NavigationDrawerWithToolbarActivity.class));
        }
        if (v.getId() == R.id.bottomNavigationId) {
            startActivity(new Intent(this, BottomNavigationUiListActivity.class));
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
        if (v.getId() == R.id.loginTV) {
            startActivity(new Intent(this, LoginUiActivity.class));
        }
        if (v.getId() == R.id.saTvId) {
            startActivity(new Intent(this, SaTestActivity.class));
        }
        if (v.getId() == R.id.mapTvId) {
            startActivity(new Intent(this, MapsActivity.class));
        }
        if (v.getId() == R.id.cartTvId) {
            startActivity(new Intent(this, CartActivity.class));
        }
        if (v.getId() == R.id.deviceInfoTvId) {
            startActivity(new Intent(this, DeviceActivity.class));
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