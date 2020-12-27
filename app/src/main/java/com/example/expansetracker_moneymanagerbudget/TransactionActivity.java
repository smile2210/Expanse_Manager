package com.example.expansetracker_moneymanagerbudget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TransactionActivity extends AppCompatActivity {
    ImageView back;
    List<Model> modelList = new ArrayList<>();
    RecyclerView recycler;
    TextView balance, income, expense;
    int totalin,totalex,balance1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        back = findViewById(R.id.back);
        recycler = findViewById(R.id.recycler);
        balance = findViewById(R.id.balance);
        income = findViewById(R.id.incometext);
        expense = findViewById(R.id.expensetext);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DataBase dataBase = new DataBase(TransactionActivity.this);
//        modelList.clear();
        List<Model> model2 = dataBase.RetriveData();
        for (int i = 0; i < model2.size(); i++) {
            Model model = new Model();
            model.setAmount(model2.get(i).getAmount());
            model.setNote(model2.get(i).getNote());
            model.setAbc(model2.get(i).getAbc());
            modelList.add(model);
        }

        RecyclerView.LayoutManager manager = new LinearLayoutManager(TransactionActivity.this, RecyclerView.VERTICAL, false);
        TransAdapter adapter = new TransAdapter(TransactionActivity.this, modelList);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

        for (int i = 0; i < model2.size(); i++) {
            if (model2.get(i).abc.equals("1")){
                totalin= totalin + model2.get(i).getAmount();
            }else{
                totalex = totalex + model2.get(i).getAmount();
            }
        }
        balance1 = totalin - totalex;
        income.setText(totalin + "");
        expense.setText(totalex +"");
        balance.setText(balance1 +"");
        
    }
}