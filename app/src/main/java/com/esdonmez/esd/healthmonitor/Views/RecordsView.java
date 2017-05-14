package com.esdonmez.esd.healthmonitor.Views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esdonmez.esd.healthmonitor.R;

public class RecordsView extends Fragment {


    public RecordsView() {
        // Required empty public constructor
    }


    public static RecordsView newInstance(String param1, String param2) {
        RecordsView fragment = new RecordsView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_records_view, container, false);

        return view;
    }
}
