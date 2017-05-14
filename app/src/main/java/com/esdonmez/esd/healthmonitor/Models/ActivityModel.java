package com.esdonmez.esd.healthmonitor.Models;

public class ActivityModel {

    private int ActivityId;
    private int BodyPartId;
    private int UserId;
    private String Type;
    private String Name;
    private String StartingTime;
    private int Duration;
    private int CalorieEffect;


    public ActivityModel(int activityId, int bodyPartId, int userId, String type, String name, String startingTime, int duration, int calorieEffect) {
        ActivityId = activityId;
        BodyPartId = bodyPartId;
        UserId = userId;
        Type = type;
        Name = name;
        StartingTime = startingTime;
        Duration = duration;
        CalorieEffect = calorieEffect;
    }


    public ActivityModel() {

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

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
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

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public int getCalorieEffect() {
        return CalorieEffect;
    }

    public void setCalorieEffect(int calorieEffect) {
        CalorieEffect = calorieEffect;
    }
}
