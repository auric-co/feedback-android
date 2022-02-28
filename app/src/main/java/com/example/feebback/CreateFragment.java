package com.example.feebback;

import android.content.Context;
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
import com.example.feebback.db.PreCreateDb;

import org.jetbrains.annotations.NotNull;

public class CreateFragment extends Fragment {
    private View rootView;
    EditText module_name, improvements;
    Integer outcomesCommunicatedValue,outcomesAchievedValue, relevanceClarityValue,lecturerResponseValue,learningEnrichedValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create, container, false);
        return  rootView;
    }

    public void onViewCreated(@NotNull View rootView, Bundle savedInstanceState){
        super.onViewCreated(rootView, savedInstanceState);
        final View v = rootView;
        Button createButton = (Button) rootView.findViewById(R.id.create_new);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                module_name = (EditText) rootView.findViewById(R.id.module_name);
                improvements = (EditText) rootView.findViewById(R.id.improvement_needed);
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
                int lectureReponseCheckedButtonId = lecturerResponse.getCheckedRadioButtonId();
                RadioButton lecturerResponseID = (RadioButton) lecturerResponse.findViewById(lectureReponseCheckedButtonId);
                lecturerResponseValue = Integer.parseInt((String) lecturerResponseID.getText());

                RadioGroup learningEnriched = (RadioGroup) rootView.findViewById(R.id.learning_enriched);
                int learningEnrichedCheckedButtonId = learningEnriched.getCheckedRadioButtonId();
                RadioButton learningEnrichedID = (RadioButton) learningEnriched.findViewById(learningEnrichedCheckedButtonId);
                learningEnrichedValue = Integer.parseInt((String) learningEnrichedID.getText());
                CreateFeedBack db = new CreateFeedBack(getActivity().getApplicationContext());
                boolean success = db.insert(module_name.getText().toString(), outcomesCommunicatedValue,outcomesAchievedValue, relevanceClarityValue, lecturerResponseValue, learningEnrichedValue, improvements.getText().toString());
                if (success){
                    Toast.makeText(getActivity().getApplicationContext(),"Saved successfully", Toast.LENGTH_LONG ).show();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Error saving feedback", Toast.LENGTH_LONG ).show();
                }
            }
        });
    }
}