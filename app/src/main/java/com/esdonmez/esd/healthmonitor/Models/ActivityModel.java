package com.esdonmez.esd.healthmonitor.Models;

import java.util.ArrayList;
import java.util.List;

public class ActivityModel {

    private List<BodyPartModel> BodyParts;
    private String Type;
    private String Name;
    private String StartingTime;
    private double Duration;
    private int CalorieEffect;
    private int EnergyEffect;


    public ActivityModel(List<BodyPartModel> bodyParts, String type, String name, String startingTime, double duration, int calorieEffect, int energyEffect) {
        BodyParts = bodyParts;
        Type = type;
        Name = name;
        StartingTime = startingTime;
        Duration = duration;
        CalorieEffect = calorieEffect;
        EnergyEffect = energyEffect;
    }


    public ActivityModel() {

    }


    public List<String> BodyParts(String activity) {
        List<String> bodyParts = new ArrayList<String>();
        if(activity.toLowerCase().equals("jogging") || activity.toLowerCase().equals("cycling") || activity.toLowerCase().equals("football"))
        {
            bodyParts.add("Leg");
            bodyParts.add("Heart");
            bodyParts.add("Arm");
            return bodyParts;
        }

        else if(activity.toLowerCase().equals("attending a course") || activity.toLowerCase().equals("going to cinema") || activity.toLowerCase().equals("listenin to music"))
        {
            bodyParts.add("Eye");
            bodyParts.add("Brain");
            return bodyParts;
        }

        else if(activity.toLowerCase().equals("eating") && activity.toLowerCase().equals("sleeping"))
        {
            bodyParts.add("Leg");
            bodyParts.add("Heart");
            bodyParts.add("Arm");
            bodyParts.add("Eye");
            bodyParts.add("Brain");
            return bodyParts;
        }

        return bodyParts;
    }

    public int findEnergyEffect(String activity) {
        if(activity.toLowerCase().equals("jogging") || activity.toLowerCase().equals("cycling") || activity.toLowerCase().equals("football"))
        {
            return -5;
        }

        else if(activity.toLowerCase().equals("attending a course") || activity.toLowerCase().equals("going to cinema") || activity.toLowerCase().equals("listenin to music"))
        {
            return -1;
        }

        else if(activity.toLowerCase().equals("eating") && activity.toLowerCase().equals("sleeping"))
        {
            return +3;
        }

        return 0;
    }

    public int findCalorieEffect(String activity) {
        if(activity.toLowerCase().equals("jogging") || activity.toLowerCase().equals("cycling") || activity.toLowerCase().equals("football"))
        {
            return -5;
        }

        else if(activity.toLowerCase().equals("attending a course") || activity.toLowerCase().equals("going to cinema") || activity.toLowerCase().equals("listenin to music"))
        {
            return -1;
        }

        else if(activity.toLowerCase().equals("eating") && activity.toLowerCase().equals("sleeping"))
        {
            return +2;
        }

        return 0;
    }

    public String findType(String activity) {
        if(activity.toLowerCase().equals("jogging") || activity.toLowerCase().equals("cycling") || activity.toLowerCase().equals("football"))
        {
            return "physical";
        }

        else if(activity.toLowerCase().equals("attending a course") || activity.toLowerCase().equals("going to cinema") || activity.toLowerCase().equals("listenin to music"))
        {
            return "nonphysical";
        }

        else if(activity.toLowerCase().equals("eating") && activity.toLowerCase().equals("sleeping"))
        {
            return "regular";
        }

        return "undefined";
    }

    public int changeCalorie(int totalCalorie, int calorieEffect) {
        totalCalorie = totalCalorie - calorieEffect;

        return totalCalorie;
    }

    public List<BodyPartModel> getBodyParts() {
        return BodyParts;
    }

    public void setBodyParts(List<BodyPartModel> bodyParts) {
        BodyParts = bodyParts;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartingTime() {
        return StartingTime;
    }

    public void setStartingTime(String startingTime) {
        StartingTime = startingTime;
    }

    public double getDuration() {
        return Duration;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

    public int getCalorieEffect() {
        return CalorieEffect;
    }

    public void setCalorieEffect(int calorieEffect) {
        CalorieEffect = calorieEffect;
    }

    public int getEnergyEffect() {
        return EnergyEffect;
    }

    public void setEnergyEffect(int energyEffect) {
        EnergyEffect = energyEffect;
    }
}
