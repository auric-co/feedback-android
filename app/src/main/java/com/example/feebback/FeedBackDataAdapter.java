package com.example.feebback;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class FeedBackDataAdapter extends CursorAdapter {
    public FeedBackDataAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.single_feedback, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvID = (TextView) view.findViewById(R.id.item_id);
        TextView tvTitle = (TextView) view.findViewById(R.id.item_title);
        TextView tvCol2 = (TextView) view.findViewById(R.id.item_col2_score);
        TextView tvCol3 = (TextView) view.findViewById(R.id.item_col3_score);
        TextView tvCol4 = (TextView) view.findViewById(R.id.item_col4_score);
        TextView tvCol5 = (TextView) view.findViewById(R.id.item_col5_score);
        TextView tvCol6 = (TextView) view.findViewById(R.id.item_col6_score);
        TextView tvCol7 = (TextView) view.findViewById(R.id.item_improvement);

        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String title = cursor.getString(cursor.getColumnIndexOrThrow("module_name"));
        int outcomes = cursor.getInt(cursor.getColumnIndexOrThrow("outcome_communicated"));
        int outcomes_achieved = cursor.getInt(cursor.getColumnIndexOrThrow("achieved_outcomes"));
        int relevance = cursor.getInt(cursor.getColumnIndexOrThrow("relevance_clear"));
        int lResponse = cursor.getInt(cursor.getColumnIndexOrThrow("lecture_response"));
        int lEnriched = cursor.getInt(cursor.getColumnIndexOrThrow("learning_enriched"));
        String needImprovements = cursor.getString(cursor.getColumnIndexOrThrow("need_improvements"));

        Log.println(Log.DEBUG,"debug_cursor_id", String.valueOf(id));
        tvID.setText(String.valueOf(id)+". ");
        tvTitle.setText(title);
        tvCol2.setText(String.valueOf(outcomes)+"/5");
        tvCol3.setText(String.valueOf(outcomes_achieved)+"/5");
        tvCol4.setText(String.valueOf(relevance)+"/5");
        tvCol5.setText(String.valueOf(lResponse)+"/5");
        tvCol6.setText(String.valueOf(lEnriched)+"/5");
        tvCol7.setText(needImprovements);
    }
}
