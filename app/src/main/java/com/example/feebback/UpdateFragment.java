package com.example.feebback;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.feebback.db.CreateFeedBack;
import com.example.feebback.db.ReadFeedBack;
import com.example.feebback.db.UpdateFeedBack;

import org.jetbrains.annotations.NotNull;

public class UpdateFragment extends Fragment {
    private View rootView;
    ReadFeedBack db;
    String id = "1";
    EditText module_name, improvements, data_id;
    Integer outcomesCommunicatedValue,outcomesAchievedValue, relevanceClarityValue,lecturerResponseValue,learningEnrichedValue;
  
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_update, container, false);
        return  rootView;
    }

    public void onViewCreated(@NotNull View rootView, Bundle savedInstanceState){
        super.onViewCreated(rootView, savedInstanceState);
        final View v = rootView;
        Button createButton = (Button) rootView.findViewById(R.id.update_record);
        data_id = (EditText) rootView.findViewById(R.id.data_id);
        module_name = (EditText) rootView.findViewById(R.id.module_name);
        improvements = (EditText) rootView.findViewById(R.id.improvement_needed);

        RadioButton radioButtonOC1 = (RadioButton) rootView.findViewById(R.id.oc_1);
        RadioButton radioButtonOC2 = (RadioButton) rootView.findViewById(R.id.oc_2);
        RadioButton radioButtonOC3 = (RadioButton) rootView.findViewById(R.id.oc_3);
        RadioButton radioButtonOC4 = (RadioButton) rootView.findViewById(R.id.oc_4);
        RadioButton radioButtonOC5 = (RadioButton) rootView.findViewById(R.id.oc_5);


        RadioButton radioButtonOA1 = (RadioButton) rootView.findViewById(R.id.oa_1);
        RadioButton radioButtonOA2 = (RadioButton) rootView.findViewById(R.id.oa_2);
        RadioButton radioButtonOA3 = (RadioButton) rootView.findViewById(R.id.oa_3);
        RadioButton radioButtonOA4 = (RadioButton) rootView.findViewById(R.id.oa_4);
        RadioButton radioButtonOA5 = (RadioButton) rootView.findViewById(R.id.oa_5);


        RadioButton radioButtonRC1 = (RadioButton) rootView.findViewById(R.id.rc_1);
        RadioButton radioButtonRC2 = (RadioButton) rootView.findViewById(R.id.rc_2);
        RadioButton radioButtonRC3 = (RadioButton) rootView.findViewById(R.id.rc_3);
        RadioButton radioButtonRC4 = (RadioButton) rootView.findViewById(R.id.rc_4);
        RadioButton radioButtonRC5 = (RadioButton) rootView.findViewById(R.id.rc_5);


        RadioButton radioButtonLR1 = (RadioButton) rootView.findViewById(R.id.lr_1);
        RadioButton radioButtonLR2 = (RadioButton) rootView.findViewById(R.id.lr_2);
        RadioButton radioButtonLR3 = (RadioButton) rootView.findViewById(R.id.lr_3);
        RadioButton radioButtonLR4 = (RadioButton) rootView.findViewById(R.id.lr_4);
        RadioButton radioButtonLR5 = (RadioButton) rootView.findViewById(R.id.lr_5);

        RadioButton radioButtonLE1 = (RadioButton) rootView.findViewById(R.id.le_1);
        RadioButton radioButtonLE2 = (RadioButton) rootView.findViewById(R.id.le_2);
        RadioButton radioButtonLE3 = (RadioButton) rootView.findViewById(R.id.le_3);
        RadioButton radioButtonLE4 = (RadioButton) rootView.findViewById(R.id.le_4);
        RadioButton radioButtonLE5 = (RadioButton) rootView.findViewById(R.id.le_5);



        db  = new ReadFeedBack(getActivity().getApplicationContext());
        Cursor cursor = db.get(id);
        if (cursor == null){
            Toast.makeText(getActivity().getApplicationContext(),"Data is null", Toast.LENGTH_LONG ).show();
            Log.println(Log.DEBUG,"debug_cursor", "Data is null");
        }else{
            if(cursor.getCount() > 0) {
                createButton.setEnabled(true);
                cursor.moveToFirst();
                @SuppressLint("Range") String module = cursor.getString(cursor.getColumnIndex("module_name"));
                @SuppressLint("Range") String row_id = cursor.getString(cursor.getColumnIndex("_id"));
                @SuppressLint("Range") String needImprov = cursor.getString(cursor.getColumnIndex("need_improvements"));

                @SuppressLint("Range") Integer col2 = cursor.getInt(cursor.getColumnIndex("outcome_communicated"));
                @SuppressLint("Range") Integer col3 = cursor.getInt(cursor.getColumnIndex("achieved_outcomes"));
                @SuppressLint("Range") Integer col4 = cursor.getInt(cursor.getColumnIndex("relevance_clear"));
                @SuppressLint("Range") Integer col5 = cursor.getInt(cursor.getColumnIndex("lecture_response"));
                @SuppressLint("Range") Integer col6 = cursor.getInt(cursor.getColumnIndex("learning_enriched"));

                data_id.setText(row_id);
                module_name.setText(module);
                improvements.setText(needImprov);
                switch (col2){
                    case 1:
                        radioButtonOC1.setChecked(true);
                        radioButtonOC2.setChecked(false);
                        radioButtonOC3.setChecked(false);
                        radioButtonOC4.setChecked(false);
                        radioButtonOC5.setChecked(false);
                        break;
                    case 2:
                        radioButtonOC1.setChecked(false);
                        radioButtonOC2.setChecked(true);
                        radioButtonOC3.setChecked(false);
                        radioButtonOC4.setChecked(false);
                        radioButtonOC5.setChecked(false);
                        break;
                    case 3:
                        radioButtonOC1.setChecked(false);
                        radioButtonOC2.setChecked(false);
                        radioButtonOC3.setChecked(true);
                        radioButtonOC4.setChecked(false);
                        radioButtonOC5.setChecked(false);
                        break;
                    case 4:
                        radioButtonOC1.setChecked(false);
                        radioButtonOC2.setChecked(false);
                        radioButtonOC3.setChecked(false);
                        radioButtonOC4.setChecked(true);
                        radioButtonOC5.setChecked(false);
                        break;
                    case 5:
                        radioButtonOC1.setChecked(false);
                        radioButtonOC2.setChecked(false);
                        radioButtonOC3.setChecked(false);
                        radioButtonOC4.setChecked(false);
                        radioButtonOC5.setChecked(true);
                        break;
                }

                switch (col3){
                    case 1:
                        radioButtonOA1.setChecked(true);
                        radioButtonOA2.setChecked(false);
                        radioButtonOA3.setChecked(false);
                        radioButtonOA4.setChecked(false);
                        radioButtonOA5.setChecked(false);
                        break;
                    case 2:
                        radioButtonOA1.setChecked(false);
                        radioButtonOA2.setChecked(true);
                        radioButtonOA3.setChecked(false);
                        radioButtonOA4.setChecked(false);
                        radioButtonOA5.setChecked(false);
                        break;
                    case 3:
                        radioButtonOA1.setChecked(false);
                        radioButtonOA2.setChecked(false);
                        radioButtonOA3.setChecked(true);
                        radioButtonOA4.setChecked(false);
                        radioButtonOA5.setChecked(false);
                        break;
                    case 4:
                        radioButtonOA1.setChecked(false);
                        radioButtonOA2.setChecked(false);
                        radioButtonOA3.setChecked(false);
                        radioButtonOA4.setChecked(true);
                        radioButtonOA5.setChecked(false);
                        break;
                    case 5:
                        radioButtonOA1.setChecked(false);
                        radioButtonOA2.setChecked(false);
                        radioButtonOA3.setChecked(false);
                        radioButtonOA4.setChecked(false);
                        radioButtonOA5.setChecked(true);
                        break;
                }

                switch (col4){
                    case 1:
                        radioButtonRC1.setChecked(true);
                        radioButtonRC2.setChecked(false);
                        radioButtonRC3.setChecked(false);
                        radioButtonRC4.setChecked(false);
                        radioButtonRC5.setChecked(false);
                        break;
                    case 2:
                        radioButtonRC1.setChecked(false);
                        radioButtonRC2.setChecked(true);
                        radioButtonRC3.setChecked(false);
                        radioButtonRC4.setChecked(false);
                        radioButtonRC5.setChecked(false);
                        break;
                    case 3:
                        radioButtonRC1.setChecked(false);
                        radioButtonRC2.setChecked(false);
                        radioButtonRC3.setChecked(true);
                        radioButtonRC4.setChecked(false);
                        radioButtonRC5.setChecked(false);
                        break;
                    case 4:
                        radioButtonRC1.setChecked(false);
                        radioButtonRC2.setChecked(false);
                        radioButtonRC3.setChecked(false);
                        radioButtonRC4.setChecked(true);
                        radioButtonRC5.setChecked(false);
                        break;
                    case 5:
                        radioButtonRC1.setChecked(false);
                        radioButtonRC2.setChecked(false);
                        radioButtonRC3.setChecked(false);
                        radioButtonRC4.setChecked(false);
                        radioButtonRC5.setChecked(true);
                        break;
                }

                switch (col5){
                    case 1:
                        radioButtonLR1.setChecked(true);
                        radioButtonLR2.setChecked(false);
                        radioButtonLR3.setChecked(false);
                        radioButtonLR4.setChecked(false);
                        radioButtonLR5.setChecked(false);
                        break;
                    case 2:
                        radioButtonLR1.setChecked(false);
                        radioButtonLR2.setChecked(true);
                        radioButtonLR3.setChecked(false);
                        radioButtonLR4.setChecked(false);
                        radioButtonLR5.setChecked(false);
                        break;
                    case 3:
                        radioButtonLR1.setChecked(false);
                        radioButtonLR2.setChecked(false);
                        radioButtonLR3.setChecked(true);
                        radioButtonLR4.setChecked(false);
                        radioButtonLR5.setChecked(false);
                        break;
                    case 4:
                        radioButtonLR1.setChecked(false);
                        radioButtonLR2.setChecked(false);
                        radioButtonLR3.setChecked(false);
                        radioButtonLR4.setChecked(true);
                        radioButtonLR5.setChecked(false);
                        break;
                    case 5:
                        radioButtonLR1.setChecked(false);
                        radioButtonLR2.setChecked(false);
                        radioButtonLR3.setChecked(false);
                        radioButtonLR4.setChecked(false);
                        radioButtonLR5.setChecked(true);
                        break;
                }

                switch (col6){
                    case 1:
                        radioButtonLE1.setChecked(true);
                        radioButtonLE2.setChecked(false);
                        radioButtonLE3.setChecked(false);
                        radioButtonLE4.setChecked(false);
                        radioButtonLE5.setChecked(false);
                        break;
                    case 2:
                        radioButtonLE1.setChecked(false);
                        radioButtonLE2.setChecked(true);
                        radioButtonLE3.setChecked(false);
                        radioButtonLE4.setChecked(false);
                        radioButtonLE5.setChecked(false);
                        break;
                    case 3:
                        radioButtonLE1.setChecked(false);
                        radioButtonLE2.setChecked(false);
                        radioButtonLE3.setChecked(true);
                        radioButtonLE4.setChecked(false);
                        radioButtonLE5.setChecked(false);
                        break;
                    case 4:
                        radioButtonLE1.setChecked(false);
                        radioButtonLE2.setChecked(false);
                        radioButtonLE3.setChecked(false);
                        radioButtonLE4.setChecked(true);
                        radioButtonLE5.setChecked(false);
                        break;
                    case 5:
                        radioButtonLE1.setChecked(false);
                        radioButtonLE2.setChecked(false);
                        radioButtonLE3.setChecked(false);
                        radioButtonLE4.setChecked(false);
                        radioButtonLE5.setChecked(true);
                        break;
                }

                Log.println(Log.DEBUG,"debug_cursor", "Values: " +col2+" "+ col3+ " "+ col4 +" "+ col5+ " "+col6);

            }else{
                createButton.setEnabled(false);
                Toast.makeText(getActivity().getApplicationContext(),"Data is empty for given ID", Toast.LENGTH_LONG ).show();
                Log.println(Log.DEBUG,"debug_cursor", "Data is empty");
            }
        }


        data_id.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    id = data_id.getText().toString();
                    Cursor cursor = db.get(id);
                    if (cursor == null){
                        Toast.makeText(getActivity().getApplicationContext(),"Data is null", Toast.LENGTH_LONG ).show();
                        Log.println(Log.DEBUG,"debug_cursor", "Data is null");
                    }else{
                        if(cursor.getCount() > 0) {
                            createButton.setEnabled(true);
                            cursor.moveToFirst();
                            @SuppressLint("Range") String module = cursor.getString(cursor.getColumnIndex("module_name"));
                            @SuppressLint("Range") String row_id = cursor.getString(cursor.getColumnIndex("_id"));
                            @SuppressLint("Range") String needImprov = cursor.getString(cursor.getColumnIndex("need_improvements"));

                            @SuppressLint("Range") Integer col2 = cursor.getInt(cursor.getColumnIndex("outcome_communicated"));
                            @SuppressLint("Range") Integer col3 = cursor.getInt(cursor.getColumnIndex("achieved_outcomes"));
                            @SuppressLint("Range") Integer col4 = cursor.getInt(cursor.getColumnIndex("relevance_clear"));
                            @SuppressLint("Range") Integer col5 = cursor.getInt(cursor.getColumnIndex("lecture_response"));
                            @SuppressLint("Range") Integer col6 = cursor.getInt(cursor.getColumnIndex("learning_enriched"));

                            data_id.setText(row_id);
                            module_name.setText(module);
                            improvements.setText(needImprov);
                            switch (col2){
                                case 1:
                                    radioButtonOC1.setChecked(true);
                                    radioButtonOC2.setChecked(false);
                                    radioButtonOC3.setChecked(false);
                                    radioButtonOC4.setChecked(false);
                                    radioButtonOC5.setChecked(false);
                                    break;
                                case 2:
                                    radioButtonOC1.setChecked(false);
                                    radioButtonOC2.setChecked(true);
                                    radioButtonOC3.setChecked(false);
                                    radioButtonOC4.setChecked(false);
                                    radioButtonOC5.setChecked(false);
                                    break;
                                case 3:
                                    radioButtonOC1.setChecked(false);
                                    radioButtonOC2.setChecked(false);
                                    radioButtonOC3.setChecked(true);
                                    radioButtonOC4.setChecked(false);
                                    radioButtonOC5.setChecked(false);
                                    break;
                                case 4:
                                    radioButtonOC1.setChecked(false);
                                    radioButtonOC2.setChecked(false);
                                    radioButtonOC3.setChecked(false);
                                    radioButtonOC4.setChecked(true);
                                    radioButtonOC5.setChecked(false);
                                    break;
                                case 5:
                                    radioButtonOC1.setChecked(false);
                                    radioButtonOC2.setChecked(false);
                                    radioButtonOC3.setChecked(false);
                                    radioButtonOC4.setChecked(false);
                                    radioButtonOC5.setChecked(true);
                                    break;
                            }

                            switch (col3){
                                case 1:
                                    radioButtonOA1.setChecked(true);
                                    radioButtonOA2.setChecked(false);
                                    radioButtonOA3.setChecked(false);
                                    radioButtonOA4.setChecked(false);
                                    radioButtonOA5.setChecked(false);
                                    break;
                                case 2:
                                    radioButtonOA1.setChecked(false);
                                    radioButtonOA2.setChecked(true);
                                    radioButtonOA3.setChecked(false);
                                    radioButtonOA4.setChecked(false);
                                    radioButtonOA5.setChecked(false);
                                    break;
                                case 3:
                                    radioButtonOA1.setChecked(false);
                                    radioButtonOA2.setChecked(false);
                                    radioButtonOA3.setChecked(true);
                                    radioButtonOA4.setChecked(false);
                                    radioButtonOA5.setChecked(false);
                                    break;
                                case 4:
                                    radioButtonOA1.setChecked(false);
                                    radioButtonOA2.setChecked(false);
                                    radioButtonOA3.setChecked(false);
                                    radioButtonOA4.setChecked(true);
                                    radioButtonOA5.setChecked(false);
                                    break;
                                case 5:
                                    radioButtonOA1.setChecked(false);
                                    radioButtonOA2.setChecked(false);
                                    radioButtonOA3.setChecked(false);
                                    radioButtonOA4.setChecked(false);
                                    radioButtonOA5.setChecked(true);
                                    break;
                            }

                            switch (col4){
                                case 1:
                                    radioButtonRC1.setChecked(true);
                                    radioButtonRC2.setChecked(false);
                                    radioButtonRC3.setChecked(false);
                                    radioButtonRC4.setChecked(false);
                                    radioButtonRC5.setChecked(false);
                                    break;
                                case 2:
                                    radioButtonRC1.setChecked(false);
                                    radioButtonRC2.setChecked(true);
                                    radioButtonRC3.setChecked(false);
                                    radioButtonRC4.setChecked(false);
                                    radioButtonRC5.setChecked(false);
                                    break;
                                case 3:
                                    radioButtonRC1.setChecked(false);
                                    radioButtonRC2.setChecked(false);
                                    radioButtonRC3.setChecked(true);
                                    radioButtonRC4.setChecked(false);
                                    radioButtonRC5.setChecked(false);
                                    break;
                                case 4:
                                    radioButtonRC1.setChecked(false);
                                    radioButtonRC2.setChecked(false);
                                    radioButtonRC3.setChecked(false);
                                    radioButtonRC4.setChecked(true);
                                    radioButtonRC5.setChecked(false);
                                    break;
                                case 5:
                                    radioButtonRC1.setChecked(false);
                                    radioButtonRC2.setChecked(false);
                                    radioButtonRC3.setChecked(false);
                                    radioButtonRC4.setChecked(false);
                                    radioButtonRC5.setChecked(true);
                                    break;
                            }

                            switch (col5){
                                case 1:
                                    radioButtonLR1.setChecked(true);
                                    radioButtonLR2.setChecked(false);
                                    radioButtonLR3.setChecked(false);
                                    radioButtonLR4.setChecked(false);
                                    radioButtonLR5.setChecked(false);
                                    break;
                                case 2:
                                    radioButtonLR1.setChecked(false);
                                    radioButtonLR2.setChecked(true);
                                    radioButtonLR3.setChecked(false);
                                    radioButtonLR4.setChecked(false);
                                    radioButtonLR5.setChecked(false);
                                    break;
                                case 3:
                                    radioButtonLR1.setChecked(false);
                                    radioButtonLR2.setChecked(false);
                                    radioButtonLR3.setChecked(true);
                                    radioButtonLR4.setChecked(false);
                                    radioButtonLR5.setChecked(false);
                                    break;
                                case 4:
                                    radioButtonLR1.setChecked(false);
                                    radioButtonLR2.setChecked(false);
                                    radioButtonLR3.setChecked(false);
                                    radioButtonLR4.setChecked(true);
                                    radioButtonLR5.setChecked(false);
                                    break;
                                case 5:
                                    radioButtonLR1.setChecked(false);
                                    radioButtonLR2.setChecked(false);
                                    radioButtonLR3.setChecked(false);
                                    radioButtonLR4.setChecked(false);
                                    radioButtonLR5.setChecked(true);
                                    break;
                            }

                            switch (col6){
                                case 1:
                                    radioButtonLE1.setChecked(true);
                                    radioButtonLE2.setChecked(false);
                                    radioButtonLE3.setChecked(false);
                                    radioButtonLE4.setChecked(false);
                                    radioButtonLE5.setChecked(false);
                                    break;
                                case 2:
                                    radioButtonLE1.setChecked(false);
                                    radioButtonLE2.setChecked(true);
                                    radioButtonLE3.setChecked(false);
                                    radioButtonLE4.setChecked(false);
                                    radioButtonLE5.setChecked(false);
                                    break;
                                case 3:
                                    radioButtonLE1.setChecked(false);
                                    radioButtonLE2.setChecked(false);
                                    radioButtonLE3.setChecked(true);
                                    radioButtonLE4.setChecked(false);
                                    radioButtonLE5.setChecked(false);
                                    break;
                                case 4:
                                    radioButtonLE1.setChecked(false);
                                    radioButtonLE2.setChecked(false);
                                    radioButtonLE3.setChecked(false);
                                    radioButtonLE4.setChecked(true);
                                    radioButtonLE5.setChecked(false);
                                    break;
                                case 5:
                                    radioButtonLE1.setChecked(false);
                                    radioButtonLE2.setChecked(false);
                                    radioButtonLE3.setChecked(false);
                                    radioButtonLE4.setChecked(false);
                                    radioButtonLE5.setChecked(true);
                                    break;
                            }

                            Log.println(Log.DEBUG,"debug_cursor", "Values: " +col2+" "+ col3+ " "+ col4 +" "+ col5+ " "+col6);

                        }else{
                            Toast.makeText(getActivity().getApplicationContext(),"Data is empty for given ID", Toast.LENGTH_LONG ).show();
                            module_name.setText("");
                            data_id.setText("");
                            improvements.setText("");
                            createButton.setEnabled(false);
                            radioButtonOC1.setChecked(false);
                            radioButtonOC2.setChecked(false);
                            radioButtonOC3.setChecked(false);
                            radioButtonOC4.setChecked(false);
                            radioButtonOC5.setChecked(false);

                            radioButtonOA1.setChecked(false);
                            radioButtonOA2.setChecked(false);
                            radioButtonOA3.setChecked(false);
                            radioButtonOA4.setChecked(false);
                            radioButtonOA5.setChecked(false);

                            radioButtonRC1.setChecked(false);
                            radioButtonRC2.setChecked(false);
                            radioButtonRC3.setChecked(false);
                            radioButtonRC4.setChecked(false);
                            radioButtonRC5.setChecked(false);

                            radioButtonLR1.setChecked(false);
                            radioButtonLR2.setChecked(false);
                            radioButtonLR3.setChecked(false);
                            radioButtonLR4.setChecked(false);
                            radioButtonLR5.setChecked(false);

                            radioButtonLE1.setChecked(false);
                            radioButtonLE2.setChecked(false);
                            radioButtonLE3.setChecked(false);
                            radioButtonLE4.setChecked(false);
                            radioButtonLE5.setChecked(false);
                            Log.println(Log.DEBUG,"debug_cursor", "Data is empty");
                        }
                    }
                }

            }
        });


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup outcomesCommunicated = (RadioGroup) rootView.findViewById(R.id.outcomes_communicated);
                int outcomesCommunicatedCheckedRadioButtonID = outcomesCommunicated.getCheckedRadioButtonId();
                RadioButton outcomesCommunicatedButton = (RadioButton) outcomesCommunicated.findViewById(outcomesCommunicatedCheckedRadioButtonID);
                outcomesCommunicatedValue =  Integer.parseInt((String) outcomesCommunicatedButton.getText());

                RadioGroup outcomesAchieved = (RadioGroup) rootView.findViewById(R.id.outcomes_achieved);
                int outcomesCommunicatedCheckedRadioButtonId = outcomesAchieved.getCheckedRadioButtonId();
                RadioButton outcomesAchievedID = (RadioButton) outcomesAchieved.findViewById(outcomesCommunicatedCheckedRadioButtonId);
                outcomesAchievedValue = Integer.parseInt((String) outcomesAchievedID.getText());

                RadioGroup relevanceClarity = (RadioGroup) rootView.findViewById(R.id.relevance_clarity);
                int relevanceClarityCheckedRadioButtonId = relevanceClarity.getCheckedRadioButtonId();
                RadioButton relevanceClarityID = (RadioButton) relevanceClarity.findViewById(relevanceClarityCheckedRadioButtonId);
                relevanceClarityValue = Integer.parseInt((String) relevanceClarityID.getText());

                RadioGroup lecturerResponse = (RadioGroup) rootView.findViewById(R.id.lecture_response);
                int lectureResponseCheckedButtonId = lecturerResponse.getCheckedRadioButtonId();
                RadioButton lecturerResponseID = (RadioButton) lecturerResponse.findViewById(lectureResponseCheckedButtonId);
                lecturerResponseValue = Integer.parseInt((String) lecturerResponseID.getText());

                RadioGroup learningEnriched = (RadioGroup) rootView.findViewById(R.id.learning_enriched);
                int learningEnrichedCheckedButtonId = learningEnriched.getCheckedRadioButtonId();
                RadioButton learningEnrichedID = (RadioButton) learningEnriched.findViewById(learningEnrichedCheckedButtonId);
                learningEnrichedValue = Integer.parseInt((String) learningEnrichedID.getText());

                UpdateFeedBack db = new UpdateFeedBack(getActivity().getApplicationContext());

                int success = db.update(id, module_name.getText().toString(), outcomesCommunicatedValue,outcomesAchievedValue, relevanceClarityValue, lecturerResponseValue, learningEnrichedValue, improvements.getText().toString());
                if (success == 1){
                    Toast.makeText(getActivity().getApplicationContext(),"Update successful", Toast.LENGTH_LONG ).show();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Error updating", Toast.LENGTH_LONG ).show();
                }
            }
        });
    }
}