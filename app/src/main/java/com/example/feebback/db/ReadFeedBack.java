package com.example.feebback.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

import com.example.feebback.R;

public class ReadFeedBack extends DataBaseHelper{
    SQLiteDatabase db = this.getReadableDatabase();
    Context context;
    public ReadFeedBack(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public Cursor getAll(){
        return db.rawQuery("select * from "+TABLE_NAME, null);
    }

    public Cursor get(String id){
        return db.rawQuery("select * from "+TABLE_NAME + " where " + COL_0 + "=" + id, null);
    }

    public SimpleCursorAdapter populateListFromDb(){
        String[] columns = {DataBaseHelper.COL_0, DataBaseHelper.COL_1, DataBaseHelper.COL_2, DataBaseHelper.COL_3, DataBaseHelper.COL_4, DataBaseHelper.COL_5, DataBaseHelper.COL_6, DataBaseHelper.COL_7};
        Cursor cursor =  this.getAll();
        String[] fromFieldNames = new String[]{DataBaseHelper.COL_0, DataBaseHelper.COL_1, DataBaseHelper.COL_2 +"/5", DataBaseHelper.COL_3+"/5", DataBaseHelper.COL_4+"/5", DataBaseHelper.COL_5+"/5", DataBaseHelper.COL_6+"/5", DataBaseHelper.COL_7};
        int[] toViewIds = new int[]
                {R.id.item_id, R.id.item_title, R.id.item_col2_score, R.id.item_col3_score, R.id.item_col4_score, R.id.item_col5_score, R.id.item_col6_score, R.id.item_improvement};


        if (cursor.moveToFirst()) {
            do {
                StringBuilder sb = new StringBuilder();
                int columnsQty = cursor.getColumnCount();
                for (int idx=0; idx<columnsQty; ++idx) {
                    sb.append(cursor.getString(idx));
                    if (idx < columnsQty - 1)
                        sb.append("; ");
                }
                Log.v("debug_cursor", String.format("Row: %d, Values: %s", cursor.getPosition(),
                        sb.toString()));
            } while (cursor.moveToNext());
        }

        return  null;
    }
}
