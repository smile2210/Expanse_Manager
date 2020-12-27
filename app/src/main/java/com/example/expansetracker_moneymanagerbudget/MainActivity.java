package com.example.expansetracker_moneymanagerbudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Display;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    DataBase dataBase;
//    private int[] ydata = {1000,550};
//    private String[] xdata = {"Income","Expanse"};
//    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.grid);
//        pieChart = findViewById(R.id.piechart);
//
//        pieChart.setRotationEnabled(true);
//        pieChart.setHoleRadius(40f);
//        pieChart.setTransparentCircleAlpha(0);
//        pieChart.setUsePercentValues(true);
//        pieChart.setCenterText("Aug 2020");
//        pieChart.setCenterTextSize(15);
//        pieChart.setDrawEntryLabels(true);
//
//        addDataSet(pieChart);


        final GridAdapter adapter = new GridAdapter(MainActivity.this);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                   startActivity(new Intent(MainActivity.this,SecondActivity.class));
                }else if(i==1){
                    startActivity(new Intent(MainActivity.this,ExpenseActivity.class));
                }else if (i==2){
                    startActivity(new Intent(MainActivity.this,TransactionActivity.class));
                }
            }
        });
    }

//    private void addDataSet(PieChart chart) {
//        ArrayList<PieEntry> yEntrys = new ArrayList<>();
//        ArrayList<String> xEntrys = new ArrayList<>();
//
//        for (int i=0; i<ydata.length;i++){
//            yEntrys.add(new PieEntry(ydata[i],i));
//        }
//
//        for (int i=0; i<xdata.length;i++){
//            xEntrys.add(xdata[i]);
//        }
//
//        PieDataSet pieDataSet = new PieDataSet(yEntrys,"");
//        pieDataSet.setSliceSpace(2);
//
//
//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.RED);
//        colors.add(Color.GREEN);
//        pieDataSet.setColors(colors);
//
//        PieData pieData = new PieData(pieDataSet);
//        pieChart.setData(pieData);
//        pieChart.invalidate();
//    }
}