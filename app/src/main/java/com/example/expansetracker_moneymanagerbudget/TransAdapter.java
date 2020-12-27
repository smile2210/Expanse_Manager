package com.example.expansetracker_moneymanagerbudget;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.TransHolder> {
    Activity activity;
    List<Model> modelList;

    public TransAdapter(TransactionActivity transactionActivity, List<Model> modelList) {
        activity = transactionActivity;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public TransHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.trance_view, parent, false);
        return new TransHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransHolder holder, int position) {
        holder.amount.setText(modelList.get(position).getAmount()+"");
        holder.note.setText(modelList.get(position).getNote());

        if (modelList.get(position).abc.equals("1")) {

            holder.amount.setTextColor(Color.GREEN);
            holder.note.setTextColor(Color.GREEN);

        } else {

            holder.amount.setTextColor(Color.RED);
            holder.note.setTextColor(Color.RED);
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class TransHolder extends RecyclerView.ViewHolder {
        TextView amount, note;

        public TransHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.amount);
            note = itemView.findViewById(R.id.note);
        }
    }
}
