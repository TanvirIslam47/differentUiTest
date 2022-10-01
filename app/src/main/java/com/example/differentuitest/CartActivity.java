package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class CartActivity extends AppCompatActivity {

    ChipGroup chipGroup;
    TextView textView;
    Chip chip, chip1;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        chipGroup = findViewById(R.id.chipGroup);
        textView = findViewById(R.id.choiceTvId);
        chip1 = findViewById(R.id.chip_1);
        textView.setText(chip1.getText());

        chipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            chip = group.findViewById(checkedId);
            if(chip != null)
            {
                textView.setText(chip.getText());
            }
        });
    }
}