package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SaTestActivity extends AppCompatActivity {
    TextView msgText, problem1;

    Animation blinkAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_test);

        problem1 = findViewById(R.id.problem1Id);
        msgText = findViewById(R.id.mdMSGId);
        msgText.setSelected(true);

        blinkAnim = AnimationUtils.loadAnimation(this, R.anim.blink);
//        blinkAnim.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//                problem1.setTextColor(Color.parseColor("#BA0000"));
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//
//                problem1.setTextColor(Color.parseColor("#FFD700"));
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
        problem1.setAnimation(blinkAnim);
    }
}