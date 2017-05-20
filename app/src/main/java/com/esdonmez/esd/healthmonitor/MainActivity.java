package com.esdonmez.esd.healthmonitor;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.esdonmez.esd.healthmonitor.Models.BodyPartModel;
import com.esdonmez.esd.healthmonitor.Models.UserFeaturesModel;
import com.esdonmez.esd.healthmonitor.Models.UserModel;
import com.esdonmez.esd.healthmonitor.Views.ActivityView;
import com.esdonmez.esd.healthmonitor.Views.MonitorView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static UserModel user;
    public static UserFeaturesModel userFeaturesModel;
    public static List<BodyPartModel> bodyPartList = new ArrayList<BodyPartModel>();
    List<String> bodyParts = new ArrayList<String>();
    LinearLayout monitorButton, activitiesButton;
    int index;
    MonitorView monitorView;
    ActivityView activityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();

        monitorButton.setOnClickListener(bottomBarListener);
        activitiesButton.setOnClickListener(bottomBarListener);
    }

    private void Initialize()
    {
        monitorButton = (LinearLayout) findViewById(R.id.monitorButton);
        activitiesButton = (LinearLayout) findViewById(R.id.activitiesButton);

        index = 0;
        monitorButton.setBackgroundColor(getResources().getColor(R.color.barSelected));
        activitiesButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        monitorView = new MonitorView();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, monitorView).commit();

        userFeaturesModel = new UserFeaturesModel();
        userFeaturesModel.setEnergyLevel(100);
        userFeaturesModel.setHealthStatus("Healthy");
        userFeaturesModel.setTotalCalorie(0);

        if(bodyParts != null) bodyParts.clear();

        bodyParts.add("Legs");
        bodyParts.add("Heart");
        bodyParts.add("Arms");
        bodyParts.add("Brain");
        bodyParts.add("Eyes");

        if(bodyPartList != null) bodyPartList.clear();

        for(int i = 0; i < 5; i++)
        {
            BodyPartModel bodyPartModel = new BodyPartModel();
            bodyPartModel.setBodyPartName(bodyParts.get(i));
            bodyPartModel.setHealthStatus("Healthy");
            bodyPartModel.setHealthValue(100);
            bodyPartList.add(bodyPartModel);
        }
    }

    private View.OnClickListener bottomBarListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            if(v.getId() == R.id.monitorButton && index != 0)
            {
                monitorButton.setBackgroundColor(getResources().getColor(R.color.barSelected));
                activitiesButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                index = 0;
                monitorView = new MonitorView();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, monitorView).commit();
            }

            else if(v.getId() == R.id.activitiesButton && index != 1)
            {
                monitorButton.setBackgroundColor(getResources().getColor(R.color.barBackground));
                activitiesButton.setBackgroundColor(getResources().getColor(R.color.barSelected));
                index = 1;
                activityView = new ActivityView();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, activityView).commit();
            }
        }
    };
}
