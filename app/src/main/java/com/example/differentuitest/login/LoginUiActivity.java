package com.example.differentuitest.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.differentuitest.R;
import com.example.differentuitest.toolbar.NavigationDrawerWithToolbarActivity;

public class LoginUiActivity extends AppCompatActivity implements View.OnClickListener {

    TextView login1, login2, login3, login4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ui);

        login1 = findViewById(R.id.login1Id);
        login2 = findViewById(R.id.login2Id);
        login3 = findViewById(R.id.login3Id);
        login4 = findViewById(R.id.login4Id);

        login1.setOnClickListener(this);
        login2.setOnClickListener(this);
        login3.setOnClickListener(this);
        login4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.login1Id) {
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (view.getId() == R.id.login2Id) {
            startActivity(new Intent(this, LoginActivity2.class));
        }
    }
}