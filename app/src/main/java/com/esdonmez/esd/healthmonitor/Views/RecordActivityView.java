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
import com.esdonmez.esd.healthmonitor.Models.NonPhysicalActivityModel;
import com.esdonmez.esd.healthmonitor.Models.PhysicalActivityModel;
import com.esdonmez.esd.healthmonitor.Models.RegularActivityModel;
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
    float elapsedTime = 0;

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
                timer.setBase(SystemClock.elapsedRealtime());
                isStopped = false;
                timer.start();
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                    elapsedTime++;
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStopped = true;
                timer.stop();
                ActivityModel activityModel = new ActivityModel();
                activityModel.setName(selectedActivity);
                activityModel.setType(activityModel.findType(activityModel.getName()));
                activityModel.setDuration(elapsedTime - 1);
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

                MainActivity.userFeaturesModel.setTotalCalorie(MainActivity.userFeaturesModel.getTotalCalorieChange() + activityModel.getCalorieEffect());

                if(activityModel.getType().equals("physical"))
                {
                    PhysicalActivityModel  physicalActivityModel = new PhysicalActivityModel(activityModel.getBodyParts(), activityModel.getType(), activityModel.getName(), activityModel.getStartingTime(), activityModel.getDuration(), activityModel.getCalorieEffect(), activityModel.getEnergyEffect());
                    ActivityView.physicalActivityList.add(physicalActivityModel);
                    MainActivity.userFeaturesModel.setEnergyLevel(physicalActivityModel.changeEnergy(MainActivity.userFeaturesModel.getEnergyLevel(), activityModel.getEnergyEffect()));

                    for(int i = 0; i < bodyPartList.size(); i++)
                    {
                        bodyPartList.get(i).setHealthValue(physicalActivityModel.changeHealthValue(bodyPartList.get(i).getHealthValue(), activityModel.getDuration(), activityModel.getEnergyEffect()));
                        bodyPartList.get(i).setHealthStatus(physicalActivityModel.changeHealth(bodyPartList.get(i).getHealthValue()));
                    }
                }
                else if(activityModel.getType().equals("nonphysical"))
                {
                    NonPhysicalActivityModel  nonPhysicalActivityModel = new NonPhysicalActivityModel(activityModel.getBodyParts(), activityModel.getType(), activityModel.getName(), activityModel.getStartingTime(), activityModel.getDuration(), activityModel.getCalorieEffect(), activityModel.getEnergyEffect());
                    ActivityView.nonphysicalActivityList.add(nonPhysicalActivityModel);
                    MainActivity.userFeaturesModel.setEnergyLevel(nonPhysicalActivityModel.changeEnergy(MainActivity.userFeaturesModel.getEnergyLevel(), activityModel.getEnergyEffect()));

                    for(int i = 0; i < bodyPartList.size(); i++)
                    {
                        bodyPartList.get(i).setHealthValue(nonPhysicalActivityModel.changeHealthValue(bodyPartList.get(i).getHealthValue(), activityModel.getDuration(), activityModel.getEnergyEffect()));
                        bodyPartList.get(i).setHealthStatus(nonPhysicalActivityModel.changeHealth(bodyPartList.get(i).getHealthValue()));
                    }
                }
                else if(activityModel.getType().equals("regular"))
                {
                    RegularActivityModel  regularActivityModel = new RegularActivityModel(activityModel.getBodyParts(), activityModel.getType(), activityModel.getName(), activityModel.getStartingTime(), activityModel.getDuration(), activityModel.getCalorieEffect(), activityModel.getEnergyEffect());
                    ActivityView.regularActivityList.add(regularActivityModel);
                    MainActivity.userFeaturesModel.setEnergyLevel(regularActivityModel.changeEnergy(MainActivity.userFeaturesModel.getEnergyLevel(), activityModel.getEnergyEffect()));

                    for(int i = 0; i < bodyPartList.size(); i++)
                    {
                        bodyPartList.get(i).setHealthValue(regularActivityModel.changeHealthValue(bodyPartList.get(i).getHealthValue(), activityModel.getDuration(), activityModel.getEnergyEffect()));
                        bodyPartList.get(i).setHealthStatus(regularActivityModel.changeHealth(bodyPartList.get(i).getHealthValue()));
                    }
                }

                timer.setBase(SystemClock.elapsedRealtime());

                ActivityView activityView = new ActivityView();
                getFragmentManager().beginTransaction().replace(R.id.fragment, activityView).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
