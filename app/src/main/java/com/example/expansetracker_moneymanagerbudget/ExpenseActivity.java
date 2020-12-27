package com.example.expansetracker_moneymanagerbudget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExpenseActivity extends AppCompatActivity {

    ImageView back,done;
    TextView date,time;
    EditText amount,note;
    DataBase dataBase;
    private Calendar calendar;
    private SimpleDateFormat dateFormat1,dateFormat2;
    private String date1,time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        back = findViewById(R.id.back);
        done = findViewById(R.id.done);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        amount = findViewById(R.id.expenseamount);
        note = findViewById(R.id.expensenote);

        calendar = Calendar.getInstance();
        dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat2 = new SimpleDateFormat("hh:mm aaa");
        date1 = dateFormat1.format(calendar.getTime());
        time1 = dateFormat2.format(calendar.getTime());
        date.setText(date1);
        time.setText(time1);

        dataBase = new DataBase(ExpenseActivity.this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amounts = amount.getText().toString();
                String notes = note.getText().toString();
                String abcs = "2";
                dataBase.InsertData(amounts,notes,abcs);
                finish();
            }
        });

    }
}