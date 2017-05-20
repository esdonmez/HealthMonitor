package com.esdonmez.esd.healthmonitor.Models;

import com.esdonmez.esd.healthmonitor.R;

public class BodyPartModel {

    private String HealthStatus;
    private int HealthValue;
    private String BodyPartName;


    public BodyPartModel(String healthStatus, int healthValue, String bodyPartName) {
        HealthStatus = healthStatus;
        HealthValue = healthValue;
        BodyPartName = bodyPartName;
    }


    public BodyPartModel() {

    }


    public int findColor(String healthStatus) {
        int color = 0;

        if(healthStatus.equals("Healthy"))
        {
            color = R.color.healthy;
        }
        else if(healthStatus.equals("Good"))
        {
            color = R.color.good;
        }
        else if(healthStatus.equals("Moderate"))
        {
            color = R.color.moderate;
        }
        else if(healthStatus.equals("Tired"))
        {
            color = R.color.tired;
        }
        else if(healthStatus.equals("Extremely Tired"))
        {
            color = R.color.extremelyTired;
        }

        return color;
    }


    public String getHealthStatus() {
        return HealthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        HealthStatus = healthStatus;
    }

    public int getHealthValue() {
        return HealthValue;
    }

    public void setHealthValue(int healthValue) {
        HealthValue = healthValue;
    }

    public String getBodyPartName() {
        return BodyPartName;
    }

    public void setBodyPartName(String bodyPartName) {
        BodyPartName = bodyPartName;
    }
}
