package com.example.differentuitest.bottomNavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.differentuitest.R;
import com.example.differentuitest.login.LoginActivity;

public class BottomNavigationUiListActivity extends AppCompatActivity implements View.OnClickListener {

    TextView bottomNav1, bottomNav2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_ui_list);

        bottomNav1 = findViewById(R.id.bottomNav1Id);
        bottomNav2 = findViewById(R.id.bottomNav2Id);

        bottomNav1.setOnClickListener(this);
        bottomNav2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.bottomNav1Id) {
            startActivity(new Intent(this, SmoothBottomNavigationActivity.class));
        }
        if (view.getId() == R.id.bottomNav2Id) {
            startActivity(new Intent(this, MaterialBottomNavActivity.class));
        }

    }
}