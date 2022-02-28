package com.example.feebback.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FeedbackDB.db";
    public static final String TABLE_NAME = "feedback_table";
    public static final String COL_0 = "_id";
    public static final String COL_1 = "module_name";
    public static final String COL_2 = "outcome_communicated";
    public static final String COL_3 = "achieved_outcomes";
    public static final String COL_4 = "relevance_clear";
    public static final String COL_5 = "lecture_response";
    public static final String COL_6 = "learning_enriched";
    public static final String COL_7 = "need_improvements";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, module_name TEXT, outcome_communicated INTEGER, achieved_outcomes INTEGER, relevance_clear INTEGER, lecture_response INTEGER, learning_enriched INTEGER, need_improvements TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
