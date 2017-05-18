package com.esdonmez.esd.healthmonitor.Models;

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
