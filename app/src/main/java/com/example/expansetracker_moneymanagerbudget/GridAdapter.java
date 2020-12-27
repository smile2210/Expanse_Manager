package com.example.expansetracker_moneymanagerbudget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class GridAdapter extends BaseAdapter {
    Activity activity;
    int[] image1 = new int[]{R.drawable.income,R.drawable.expenses,R.drawable.transaction};
    int[] color = new int[]{R.color.incomecolor,R.color.expencecolor,R.color.transcolor};
    int[] addimage = new int[]{R.drawable.add_income,R.drawable.add_expenses,R.drawable.all_transaction};
    String[] name = new String[]{"Add Income","Add Expenses","All Transcation",};

    public GridAdapter(MainActivity mainActivity) {
        activity = mainActivity;
    }

    @Override
    public int getCount() {
        return image1.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(activity).inflate(R.layout.gridview,viewGroup,false);
        ImageView image = view.findViewById(R.id.image1);
        ImageView addimage1 = view.findViewById(R.id.addimage);
        TextView name1 = view.findViewById(R.id.name);
       LinearLayout layout = view.findViewById(R.id.layout);

        layout.setBackgroundColor(color[i]);
        Glide.with(activity).load(image1[i]).into(image);
        Glide.with(activity).load(addimage[i]).into(addimage1);
        name1.setText(name[i]);
        return view;
    }
}
