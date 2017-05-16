package com.esdonmez.esd.healthmonitor.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.esdonmez.esd.healthmonitor.Adapters.ActivityAdapter;
import com.esdonmez.esd.healthmonitor.Models.ActivityModel;
import com.esdonmez.esd.healthmonitor.R;

import java.util.ArrayList;
import java.util.List;


public class ActivityView extends Fragment {

    public static List<ActivityModel> activityList = new ArrayList<ActivityModel>();
    GridView activityView;
    ImageView sad;
    ActivityAdapter activityAdapter;

    public ActivityView() {
        // Required empty public constructor
    }


    public static ActivityView newInstance(String param1, String param2) {
        ActivityView fragment = new ActivityView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_activity_view, container, false);

        activityView = (GridView) view.findViewById(R.id.campaignList);
        sad = (ImageView) view.findViewById(R.id.sad);

        ActivityModel activityModel = new ActivityModel();
        activityModel.setCalorieEffect(-100);
        activityModel.setDuration(50);
        activityModel.setName("Running");
        activityModel.setType("Physical");

        if(activityList != null) activityList.clear();
        activityList.add(activityModel);

        if(activityList != null)
        {
            activityAdapter = new ActivityAdapter(getContext(), activityList);
            activityView.setAdapter(activityAdapter);
        }

        return view;
    }
}
