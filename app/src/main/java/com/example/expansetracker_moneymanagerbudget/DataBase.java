package com.example.expansetracker_moneymanagerbudget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    Context context;

    public DataBase(@Nullable Context context) {
        super(context, "TRANCE.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE trance(amount TEXT PRIMARY KEY, note TEXT, abc TEXT)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void InsertData(String amount, String note, String abc){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("amount",amount);
        values.put("note",note);
        values.put("abc",abc);
        database.insert("trance",null,values);
    }

    public List<Model> RetriveData(){
        SQLiteDatabase database = getReadableDatabase();
        List<Model> models = new ArrayList<>();
        String query1 = "SELECT * FROM trance";
        Cursor cursor = database.rawQuery(query1,null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            int amounts = cursor.getInt(0);
            String notes = cursor.getString(1);
            String abcs = cursor.getString(2);

            Model model = new Model(amounts,notes,abcs);
            models.add(model);
            cursor.moveToNext();
        }
        return models;

    }
}
