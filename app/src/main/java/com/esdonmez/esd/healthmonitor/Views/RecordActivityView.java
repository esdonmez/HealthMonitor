package com.esdonmez.esd.healthmonitor.Views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.esdonmez.esd.healthmonitor.MainActivity;
import com.esdonmez.esd.healthmonitor.Models.ActivityModel;
import com.esdonmez.esd.healthmonitor.Models.BodyPartModel;
import com.esdonmez.esd.healthmonitor.R;

import java.util.ArrayList;
import java.util.List;

public class RecordActivityView extends Fragment {

    Chronometer timer;
    LinearLayout startButton, stopButton;
    Spinner spinner;
    String selectedActivity;
    List<BodyPartModel> bodyPartList = new ArrayList<BodyPartModel>();
    Boolean isStopped = false;
    double elapsedTime = 0.0;

    public RecordActivityView() {
        // Required empty public constructor
    }


    public static RecordActivityView newInstance(String param1, String param2) {
        RecordActivityView fragment = new RecordActivityView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_activity_view, container, false);

        timer = (Chronometer) view.findViewById(R.id.timer);
        startButton = (LinearLayout) view.findViewById(R.id.startButton);
        stopButton = (LinearLayout) view.findViewById(R.id.stopButton);
        spinner = (Spinner) view.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.activities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        stopButton.setEnabled(false);
        startButton.setEnabled(true);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedActivity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                isStopped = false;
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(isStopped == false)
                {
                    elapsedTime++;
                }
                else if(isStopped == true)
                {
                    elapsedTime = (elapsedTime/1000)/60;
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                isStopped = true;
                ActivityModel activityModel = new ActivityModel();
                activityModel.setName(selectedActivity);
                activityModel.setType(activityModel.findType(activityModel.getName()));
                activityModel.setDuration(elapsedTime);
                activityModel.setStartingTime(timer.getText().toString());
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
        });

        return view;
    }
}
