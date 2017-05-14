package com.esdonmez.esd.healthmonitor.Models;

public class BodyPartModel {

    private int BodyPartId;
    private String HealthStatus;
    private String BodyPartName;


    public BodyPartModel(int bodyPartId, String healthStatus, String bodyPartName) {
        BodyPartId = bodyPartId;
        HealthStatus = healthStatus;
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

    public String getHealthStatus() {
        return HealthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        HealthStatus = healthStatus;
    }

    public String getBodyPartName() {
        return BodyPartName;
    }

    public void setBodyPartName(String bodyPartName) {
        BodyPartName = bodyPartName;
    }
}
