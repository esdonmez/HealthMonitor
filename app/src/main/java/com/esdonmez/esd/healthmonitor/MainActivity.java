package com.esdonmez.esd.healthmonitor;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.esdonmez.esd.healthmonitor.Models.UserModel;
import com.esdonmez.esd.healthmonitor.Views.ActivityView;
import com.esdonmez.esd.healthmonitor.Views.MonitorView;
import com.esdonmez.esd.healthmonitor.Views.RecordsView;

public class MainActivity extends AppCompatActivity {

    public static UserModel user;
    LinearLayout monitorButton, activitiesButton, recordsButton;
    int index;
    MonitorView monitorView;
    ActivityView activityView;
    RecordsView recordsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();

        monitorButton.setOnClickListener(bottomBarListener);
        activitiesButton.setOnClickListener(bottomBarListener);
        recordsButton.setOnClickListener(bottomBarListener);
    }

    private void Initialize()
    {
        monitorButton = (LinearLayout) findViewById(R.id.monitorButton);
        activitiesButton = (LinearLayout) findViewById(R.id.activitiesButton);
        recordsButton = (LinearLayout) findViewById(R.id.recordsButton);

        index = 0;
        monitorButton.setBackgroundColor(getResources().getColor(R.color.barSelected));
        activitiesButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        recordsButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        monitorView = new MonitorView();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, monitorView).commit();
    }

    private View.OnClickListener bottomBarListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            if(v.getId() == R.id.monitorButton && index != 0)
            {
                monitorButton.setBackgroundColor(getResources().getColor(R.color.barSelected));
                activitiesButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                recordsButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                index = 0;
                monitorView = new MonitorView();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, monitorView).commit();
            }

            else if(v.getId() == R.id.activitiesButton && index != 1)
            {
                monitorButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                activitiesButton.setBackgroundColor(getResources().getColor(R.color.barSelected));
                recordsButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                index = 1;
                activityView = new ActivityView();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, activityView).commit();
            }

            else if(v.getId() == R.id.recordsButton && index != 2)
            {
                monitorButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                activitiesButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                recordsButton.setBackgroundColor(getResources().getColor(R.color.barSelected));
                index = 2;
                recordsView = new RecordsView();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, recordsView).commit();
            }
        }
    };
}
