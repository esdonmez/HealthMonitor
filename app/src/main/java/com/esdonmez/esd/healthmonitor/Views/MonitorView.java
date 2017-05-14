package com.esdonmez.esd.healthmonitor.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.esdonmez.esd.healthmonitor.R;

public class MonitorView extends Fragment {


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

        return view;
    }
}
