package com.esdonmez.esd.healthmonitor.Models;

import java.util.List;

public class UserFeaturesModel {

    private int EnergyLevel;
    private String HealthStatus;
    private int TotalCalorie;


    public UserFeaturesModel(int energyLevel, String healthStatus, int totalCalorie) {
        EnergyLevel = energyLevel;
        HealthStatus = healthStatus;
        TotalCalorie = totalCalorie;
    }


    public UserFeaturesModel() {

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
