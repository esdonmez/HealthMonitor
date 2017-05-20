package com.esdonmez.esd.healthmonitor.Views;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.esdonmez.esd.healthmonitor.MainActivity;
import com.esdonmez.esd.healthmonitor.R;

public class MonitorView extends Fragment {

    ProgressBar progressBar;
    TextView energyText, brain, eyes, heart, arms, legs;


    public MonitorView() {
        // Required empty public constructor
    }


    public static MonitorView newInstance(String param1, String param2) {
        MonitorView fragment = new MonitorView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_monitor_view, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        energyText = (TextView) view.findViewById(R.id.energy);
        brain = (TextView) view.findViewById(R.id.brain);
        eyes = (TextView) view.findViewById(R.id.eyes);
        heart = (TextView) view.findViewById(R.id.heart);
        arms = (TextView) view.findViewById(R.id.arms);
        legs = (TextView) view.findViewById(R.id.legs);

        progressBar.setProgress(MainActivity.userFeaturesModel.getEnergyLevel());
        energyText.setText("" + MainActivity.userFeaturesModel.getEnergyLevel());
        for(int i = 0; i < MainActivity.bodyPartList.size(); i++)
        {
            int color = MainActivity.bodyPartList.get(i).findColor(MainActivity.bodyPartList.get(i).getHealthStatus());

            if(MainActivity.bodyPartList.get(i).getBodyPartName().equals("Brain"))
            {
                brain.setText(MainActivity.bodyPartList.get(i).getHealthStatus());
                brain.setTextColor(getResources().getColor(color));
            }
            else if(MainActivity.bodyPartList.get(i).getBodyPartName().equals("Eyes"))
            {
                eyes.setText(MainActivity.bodyPartList.get(i).getHealthStatus());
                eyes.setTextColor(getResources().getColor(color));
            }
            else if(MainActivity.bodyPartList.get(i).getBodyPartName().equals("Heart"))
            {
                heart.setText(MainActivity.bodyPartList.get(i).getHealthStatus());
                heart.setTextColor(getResources().getColor(color));
            }
            else if(MainActivity.bodyPartList.get(i).getBodyPartName().equals("Arms"))
            {
                arms.setText(MainActivity.bodyPartList.get(i).getHealthStatus());
                arms.setTextColor(getResources().getColor(color));
            }
            else if(MainActivity.bodyPartList.get(i).getBodyPartName().equals("Legs"))
            {
                legs.setText(MainActivity.bodyPartList.get(i).getHealthStatus());
                legs.setTextColor(getResources().getColor(color));
            }
        }

        return view;
    }
}
