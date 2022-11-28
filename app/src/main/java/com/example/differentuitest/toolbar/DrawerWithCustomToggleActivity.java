package com.example.differentuitest.toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.differentuitest.R;
import com.google.android.material.navigation.NavigationView;

public class DrawerWithCustomToggleActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView imageMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_with_custom_toggle);

        drawerLayout = findViewById(R.id.toggleDrawerLayoutId);
        navigationView = findViewById(R.id.toggleNavViewId);
        imageMenu = findViewById(R.id.imageMenu);

        toggle = new ActionBarDrawerToggle(DrawerWithCustomToggleActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Here
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}