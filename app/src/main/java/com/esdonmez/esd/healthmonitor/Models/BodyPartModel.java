package com.esdonmez.esd.healthmonitor.Models;

public class BodyPartModel {

    private int BodyPartId;
    private int UserId;
    private String HealthStatus;
    private int HealthValue;
    private String BodyPartName;


    public BodyPartModel(int bodyPartId, int userId, String healthStatus, int healthValue, String bodyPartName) {
        BodyPartId = bodyPartId;
        UserId = userId;
        HealthStatus = healthStatus;
        HealthValue = healthValue;
        BodyPartName = bodyPartName;
    }


    public BodyPartModel() {

    }


    public int getBodyPartId() {
        return BodyPartId;
    }

    public void setBodyPartId(int bodyPartId) {
        BodyPartId = bodyPartId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
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
