package com.esdonmez.esd.healthmonitor.Models;

import java.util.List;

public class PhysicalActivityModel extends ActivityModel {


    public PhysicalActivityModel(List<BodyPartModel> bodyParts, String type, String name, String startingTime, double duration, int calorieEffect, int energyEffect) {
        super(bodyParts, type, name, startingTime, duration, calorieEffect, energyEffect);
    }

    public PhysicalActivityModel() {
    }


    public int changeEnergy(int totalEnergy, double duration, int energyEffect) {
        totalEnergy = (int) (totalEnergy - (duration*energyEffect*100));

        return totalEnergy;
    }

    public String changeHealth (int healthValue, double duration, int energyEffect) {
        String healthStatus = "";
        healthValue = (int) (healthValue - duration * energyEffect);

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

    @Override
    public int changeCalorie(int totalCalorie, int calorieEffect) {
        return super.changeCalorie(totalCalorie, calorieEffect);
    }
}
