package com.esdonmez.esd.healthmonitor.Models;

import java.util.List;

public class NonPhysicalActivityModel extends ActivityModel {


    public NonPhysicalActivityModel(List<BodyPartModel> bodyParts, String type, String name, String startingTime, float duration, int calorieEffect, int energyEffect) {
        super(bodyParts, type, name, startingTime, duration, calorieEffect, energyEffect);
    }


    public NonPhysicalActivityModel() {

    }


    public int changeEnergy(int totalEnergy, int energyEffect) {
        totalEnergy = (int) (totalEnergy + energyEffect);

        return totalEnergy;
    }

    public String changeHealth(int healthValue) {
        String healthStatus = "";

        if(healthValue >= 100)
            healthStatus = "Healthy";
        else if(60 < healthValue && healthValue <= 80)
            healthStatus = "Good";
        else if(40 < healthValue && healthValue <= 60)
            healthStatus = "Moderate";
        else if(20 < healthValue && healthValue <= 40)
            healthStatus = "Tired";
        else if(healthValue <= 20)
            healthStatus = "Extremely Tired";

        return healthStatus;
    }

    public int changeHealthValue (int healthValue, double duration, int energyEffect) {
        healthValue = (int) (healthValue - duration * energyEffect);
        return healthValue;
    }
}
