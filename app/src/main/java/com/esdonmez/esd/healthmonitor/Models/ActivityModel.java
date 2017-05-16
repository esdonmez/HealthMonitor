package com.esdonmez.esd.healthmonitor.Models;

public class ActivityModel {

    private int ActivityId;
    private int BodyPartId;
    private UserModel User;
    private String Type;
    private String Name;
    private String StartingTime;
    private double Duration;
    private int CalorieEffect;
    private int EnergyEffect;


    public ActivityModel(int activityId, int bodyPartId, UserModel user, String type, String name, String startingTime, double duration, int calorieEffect, int energyEffect) {
        ActivityId = activityId;
        BodyPartId = bodyPartId;
        User = user;
        Type = type;
        Name = name;
        StartingTime = startingTime;
        Duration = duration;
        CalorieEffect = calorieEffect;
        EnergyEffect = energyEffect;
    }


    public ActivityModel() {

    }


    public int changeCalorie(int totalCalorie, int calorieEffect) {
        totalCalorie = totalCalorie - calorieEffect;

        return totalCalorie;
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    public int getBodyPartId() {
        return BodyPartId;
    }

    public void setBodyPartId(int bodyPartId) {
        BodyPartId = bodyPartId;
    }

    public UserModel getUser() {
        return User;
    }

    public void setUser(UserModel user) {
        User = user;
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
