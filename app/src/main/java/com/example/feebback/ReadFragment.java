package com.example.feebback;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.feebback.db.ReadFeedBack;
import com.example.feebback.db.PreCreateDb;

import org.jetbrains.annotations.NotNull;

public class ReadFragment extends Fragment {
    private View rootView;
    ReadFeedBack db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return  rootView;
    }

    public void onViewCreated(@NotNull View rootView, Bundle savedInstanceState){
        super.onViewCreated(rootView, savedInstanceState);
        final View v = rootView;
        db  = new ReadFeedBack(getActivity().getApplicationContext());
        Cursor cursor = db.getAll();
        ListView feedBacks = (ListView) rootView.findViewById(R.id.lvRecords);
        FeedBackDataAdapter feedBackDataAdapter = new FeedBackDataAdapter(getActivity().getApplicationContext(),cursor);
        feedBacks.setAdapter(feedBackDataAdapter);

        Button refresh = (Button) rootView.findViewById(R.id.refresh_data);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor newCursor = db.getAll();
                feedBackDataAdapter.changeCursor(newCursor);
                Toast.makeText(getActivity().getApplicationContext(),"Refresh successful", Toast.LENGTH_LONG ).show();
            }
        });
    }
}