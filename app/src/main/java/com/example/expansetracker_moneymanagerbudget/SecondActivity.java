package com.example.expansetracker_moneymanagerbudget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    ImageView back,done;
    TextView date,time;
    EditText amount,note;
    private Calendar calendar;
    private SimpleDateFormat dateFormat1,dateFormat2;
    private String date1,time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        back = findViewById(R.id.back);
        done = findViewById(R.id.done);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        amount = findViewById(R.id.incomeamount);
        note = findViewById(R.id.incomenote);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        calendar = Calendar.getInstance();
        dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat2 = new SimpleDateFormat("hh:mm aaa");
        date1 = dateFormat1.format(calendar.getTime());
        time1 = dateFormat2.format(calendar.getTime());
        date.setText(date1);
        time.setText(time1);

        final DataBase dataBase = new DataBase(SecondActivity.this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String amounts = amount.getText().toString();
                 String notes = note.getText().toString();
                String abcs = "1";
                dataBase.InsertData(amounts,notes,abcs);
                finish();
            }
        });


    }
}