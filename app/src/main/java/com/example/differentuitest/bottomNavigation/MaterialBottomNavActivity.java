package com.example.differentuitest.bottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.differentuitest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MaterialBottomNavActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_bottom_nav);

        bottomNavigationView = findViewById(R.id.bottom_nav_Id);

        Intent intent = getIntent();
        String op = intent.getStringExtra("something");
        if (op != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                    new ProfileFragment()).addToBackStack(null).commit();
            bottomNavigationView.setSelectedItemId(R.id.profileMenuId);
        } else {

            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.homeMenuId);

            bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.homeMenuId:
                            fragment = new HomeFragment();
                            break;
                        case R.id.wishlistMenuId:
                            fragment = new WishlistFragment();
                            break;
                        case R.id.cartMenuId:
                            fragment = new CartFragment();
                            break;
                        case R.id.profileMenuId:
                            fragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();

                    return true;
                }
            });
        }

    }
}