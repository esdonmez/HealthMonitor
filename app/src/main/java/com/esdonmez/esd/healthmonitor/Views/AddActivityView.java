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
import com.esdonmez.esd.healthmonitor.Models.NonPhysicalActivityModel;
import com.esdonmez.esd.healthmonitor.Models.PhysicalActivityModel;
import com.esdonmez.esd.healthmonitor.Models.RegularActivityModel;
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
                    activityModel.setDuration(Float.parseFloat(durationText.toString()));
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

                    ActivityView activityView = new ActivityView();
                    getFragmentManager().beginTransaction().replace(R.id.fragment, activityView).addToBackStack(null).commit();
                }
            }
        });

        return view;
    }
}
