package com.example.feebback.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class StudentFeedBackTable extends DataBaseHelper {
    SQLiteDatabase db = this.getReadableDatabase();
    public StudentFeedBackTable(@Nullable Context context) {
        super(context);
    }


    public int deleteRecord(String id){
        return db.delete(TABLE_NAME, "WHERE "+COL_0+" =?", new String[] {id});
    }

}
