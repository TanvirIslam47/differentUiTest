package com.example.differentuitest.progressAndBar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.differentuitest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class CircleProgressActivity extends AppCompatActivity {

    private PieChart half_chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);

        half_chart = findViewById(R.id.half_chart);
        halfChart();
    }

    private void halfChart(){

        ArrayList<PieEntry> yvalues = new ArrayList<PieEntry>();
        yvalues.add(new PieEntry(30, 0));
        yvalues.add(new PieEntry(0, 1));



        PieDataSet dataSet = new PieDataSet(yvalues, "Achieved Percents");
        dataSet.setSliceSpace(0f);

//        ArrayList<String> xVals = new ArrayList<String>();
//
//        xVals.add("January");
//        xVals.add("February");
//        xVals.add("March");
//        xVals.add("April");
//        xVals.add("May");
//        xVals.add("June");

//        PieEntry values = new PieEntry(10);
//        PieDataSet dataSet = new PieDataSet(values, "asdfg");
//
        PieData data = new PieData(dataSet);

        data.setValueFormatter(new PercentFormatter());
        half_chart.setData(data);
        //pieChart.setDescription("This is Pie Chart");

        half_chart.setBackgroundColor(Color.TRANSPARENT);
        half_chart.setHoleColor(Color.WHITE);
        half_chart.setTransparentCircleColor(Color.WHITE);
        half_chart.setTransparentCircleAlpha(0);
        half_chart.setHoleRadius(70f);
        half_chart.setDrawCenterText(true);
        half_chart.isRotationEnabled();
        half_chart.isHighlightPerTapEnabled();
        half_chart.setCenterTextOffset(0f,-20f);
        half_chart.setExtraOffsets(5f,0f,10f,-100f);
        half_chart.setEntryLabelColor(Color.WHITE);
//        half_chart.setEntryLabelTypeface(Typeface.DEFAULT);
        half_chart.setEntryLabelTextSize(16f);
        half_chart.setTransparentCircleRadius(11f);

        half_chart.setDrawHoleEnabled(true);


        half_chart.setMaxAngle(180.0f);
        half_chart.setRotationAngle(180.0f);
        half_chart.setCenterText("achieved: 40%");
        half_chart.setCenterTextSize(18);



//        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        data.setValueTextSize(13f);

        // data.setValueTextColor(Color.GREEN);
        //pieChart.setOnChartValueSelectedListener(getActivity());

//        half_chart.animateY(1400, Easing.EaseInOutQuad);
    }
}