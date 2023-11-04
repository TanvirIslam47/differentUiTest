package com.example.differentuitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;

public class OCRActivity extends AppCompatActivity {

    EditText ocrText;
    AppCompatButton uploadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocractivity);

        ocrText = findViewById(R.id.ocrTextId);
        uploadBtn = findViewById(R.id.uploadBtnId);
    }
}