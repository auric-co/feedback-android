package com.example.feebback.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class UpdateFeedBack extends DataBaseHelper{
    SQLiteDatabase db = this.getReadableDatabase();
    public UpdateFeedBack(@Nullable Context context) {
        super(context);
    }

    public int update(String id, String col_1, int col_2, int col_3, int col_4, int col_5, int col_6, String col_7){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, col_1);
        contentValues.put(COL_2, col_2);
        contentValues.put(COL_3, col_3);
        contentValues.put(COL_4, col_4);
        contentValues.put(COL_5, col_5);
        contentValues.put(COL_6, col_6);
        contentValues.put(COL_7, col_7);
        return db.update(TABLE_NAME, contentValues, "_id =?", new String[] {id});
    }
}
