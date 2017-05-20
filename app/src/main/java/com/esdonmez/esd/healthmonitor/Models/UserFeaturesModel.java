package com.esdonmez.esd.healthmonitor.Models;

import java.util.List;

public class UserFeaturesModel {

    private int EnergyLevel;
    private String HealthStatus;
    private int TotalCalorieChange;


    public UserFeaturesModel(int energyLevel, String healthStatus, int totalCalorieChange) {
        EnergyLevel = energyLevel;
        HealthStatus = healthStatus;
        TotalCalorieChange = totalCalorieChange;
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

    public int getTotalCalorieChange() {
        return TotalCalorieChange;
    }

    public void setTotalCalorie(int totalCalorieChange) {
        TotalCalorieChange = totalCalorieChange;
    }
}
