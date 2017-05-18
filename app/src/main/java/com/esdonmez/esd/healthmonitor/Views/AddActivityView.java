package com.esdonmez.esd.healthmonitor.Views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.esdonmez.esd.healthmonitor.MainActivity;
import com.esdonmez.esd.healthmonitor.Models.ActivityModel;
import com.esdonmez.esd.healthmonitor.Models.BodyPartModel;
import com.esdonmez.esd.healthmonitor.R;

import java.util.ArrayList;
import java.util.List;

public class AddActivityView extends Fragment {

    Spinner spinner;
    String selectedActivity;
    LinearLayout addButton;
    EditText duration, startTime;
    Editable startTimeText, durationText;
    List<BodyPartModel> bodyPartList = new ArrayList<BodyPartModel>();


    public AddActivityView() {
        // Required empty public constructor
    }


    public static AddActivityView newInstance(String param1, String param2) {
        AddActivityView fragment = new AddActivityView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_activity_view, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        addButton = (LinearLayout) view.findViewById(R.id.addButton);
        duration = (EditText) view.findViewById(R.id.duration);
        startTime = (EditText) view.findViewById(R.id.startTime);

        startTimeText = startTime.getText();
        durationText = duration.getText();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.activities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedActivity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startTimeText != null && durationText != null)
                {
                    ActivityModel activityModel = new ActivityModel();
                    activityModel.setName(selectedActivity);
                    activityModel.setType(activityModel.findType(activityModel.getName()));
                    activityModel.setDuration(Double.parseDouble(durationText.toString()));
                    activityModel.setStartingTime(startTimeText.toString());
                    activityModel.setCalorieEffect((int) (activityModel.findCalorieEffect(activityModel.getName()) * activityModel.getDuration()));
                    activityModel.setEnergyEffect((int) (activityModel.findEnergyEffect(activityModel.getName()) * activityModel.getDuration()));
                    for (String bodyPart:activityModel.BodyParts(activityModel.getName())) {
                        for(int i = 0; i < MainActivity.bodyPartList.size(); i++)
                        {
                            if(bodyPart.equals(MainActivity.bodyPartList.get(i).getBodyPartName()))
                            {
                                bodyPartList.add(MainActivity.bodyPartList.get(i));
                                break;
                            }
                        }
                    };
                    activityModel.setBodyParts(bodyPartList);
                    ActivityView.activityList.add(activityModel);

                    ActivityView activityView = new ActivityView();
                    getFragmentManager().beginTransaction().replace(R.id.fragment, activityView).addToBackStack(null).commit();
                }
            }
        });

        return view;
    }
}
