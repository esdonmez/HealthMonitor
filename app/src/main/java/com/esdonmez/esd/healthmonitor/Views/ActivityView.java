package com.esdonmez.esd.healthmonitor.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esdonmez.esd.healthmonitor.R;


public class ActivityView extends Fragment {


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

        return view;
    }
}
