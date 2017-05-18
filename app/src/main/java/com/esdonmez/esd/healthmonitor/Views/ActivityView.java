package com.esdonmez.esd.healthmonitor.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.esdonmez.esd.healthmonitor.Adapters.ActivityAdapter;
import com.esdonmez.esd.healthmonitor.Models.ActivityModel;
import com.esdonmez.esd.healthmonitor.Models.NonPhysicalActivityModel;
import com.esdonmez.esd.healthmonitor.Models.PhysicalActivityModel;
import com.esdonmez.esd.healthmonitor.Models.RegularActivityModel;
import com.esdonmez.esd.healthmonitor.R;

import java.util.ArrayList;
import java.util.List;


public class ActivityView extends Fragment {

    public static List<ActivityModel> activityList = new ArrayList<ActivityModel>();
    public static List<PhysicalActivityModel> physicalActivityList = new ArrayList<PhysicalActivityModel>();
    public static List<NonPhysicalActivityModel> nonphysicalActivityList = new ArrayList<NonPhysicalActivityModel>();
    public static List<RegularActivityModel> regularActivityList = new ArrayList<RegularActivityModel>();
    GridView activityView;
    ImageView sad;
    ActivityAdapter activityAdapter;
    RelativeLayout addButton, recordButton;

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
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_activity_view, container, false);

        activityView = (GridView) view.findViewById(R.id.campaignList);
        sad = (ImageView) view.findViewById(R.id.sad);
        addButton = (RelativeLayout) view.findViewById(R.id.addButton);
        recordButton = (RelativeLayout) view.findViewById(R.id.recordButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddActivityView addActivityView = new AddActivityView();
                getFragmentManager().beginTransaction().replace(R.id.fragment, addActivityView).addToBackStack(null).commit();
            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecordActivityView recordActivityView = new RecordActivityView();
                getFragmentManager().beginTransaction().replace(R.id.fragment, recordActivityView).addToBackStack(null).commit();
            }
        });

        if(activityList != null)
        {
            activityAdapter = new ActivityAdapter(getContext(), activityList);
            activityView.setAdapter(activityAdapter);
        }

        return view;
    }
}
