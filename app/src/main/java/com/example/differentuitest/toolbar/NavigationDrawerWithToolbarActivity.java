package com.example.differentuitest.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.differentuitest.R;
import com.google.android.material.navigation.NavigationView;


public class NavigationDrawerWithToolbarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_with_toolbar);
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow();
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//        }

        toolbar = findViewById(R.id.toolBarId);
        toolbar.setTitle("Modern Toolbar");
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawerLayoutId);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navViewId);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.homeItemId) {
            Toast.makeText(this, "Home is clicked", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.workItemId) {
            Toast.makeText(this, "Work is clicked", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.schoolItemId) {
            Toast.makeText(this, "School is clicked", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.settingsItemId) {
            Toast.makeText(this, "Settings is clicked", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.historyItemId) {
            Toast.makeText(this, "History is clicked", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.notificationItemId) {
            Toast.makeText(this, "Notification is clicked", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.profileItemId) {
            Toast.makeText(this, "Profile is clicked", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutId, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}