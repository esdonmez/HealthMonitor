package com.esdonmez.esd.healthmonitor.Models;

public class UserFeaturesModel {

    private int UserFeaturesId;
    private int UserId;
    private int EnergyLevel;
    private String HealthStatus;
    private int TotalCalorie;


    public UserFeaturesModel(int userFeaturesId, int userId, int energyLevel, String healthStatus, int totalCalorie) {
        UserFeaturesId = userFeaturesId;
        UserId = userId;
        EnergyLevel = energyLevel;
        HealthStatus = healthStatus;
        TotalCalorie = totalCalorie;
    }


    public UserFeaturesModel() {

    }


    public int getUserFeaturesId() {
        return UserFeaturesId;
    }

    public void setUserFeaturesId(int userFeaturesId) {
        UserFeaturesId = userFeaturesId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getEnergyLevel() {
        return EnergyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        EnergyLevel = energyLevel;
    }

    public String getHealthStatus() {
        return HealthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        HealthStatus = healthStatus;
    }

    public int getTotalCalorie() {
        return TotalCalorie;
    }

    public void setTotalCalorie(int totalCalorie) {
        TotalCalorie = totalCalorie;
    }
}
