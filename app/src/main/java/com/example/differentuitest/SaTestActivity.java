package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.differentuitest.lib.MovableFloatingActionButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class SaTestActivity extends AppCompatActivity {
    TextView msgText, msgText1, problem1;

    Animation blinkAnim;

    ExtendedFloatingActionButton fab;
//    MovableFloatingActionButton m_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_test);

        problem1 = findViewById(R.id.problem1Id);
        msgText = findViewById(R.id.mdMSGId);
        msgText.setSelected(true);
        msgText1 = findViewById(R.id.mdMSG1Id);
        msgText1.setSelected(true);
        fab = findViewById(R.id.extended_fab);
//        m_fab = findViewById(R.id.movable_fab);

        fab.shrink();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fab.isExtended()) {
                    fab.shrink();
                }
                else {
                    fab.extend();
                }
            }
        });

//        View.OnClickListener clickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ExtendedFloatingActionButton extFab = (ExtendedFloatingActionButton) view;
//                if(extFab.isExtended())
//                {
//                    extFab.shrink();
//                }
//                else {
//                    extFab.extend();
//                }
//            }
//        };
//
//        fab.setOnClickListener(clickListener);

//        //MovableFloatingActionButton listener
//        m_fab.shrink();
//        m_fab.setOnClickListener(view -> {
//
//            if(m_fab.isExtended()) {
//                m_fab.shrink();
//            }
//            else {
//                m_fab.extend();
//            }
//
//        });


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