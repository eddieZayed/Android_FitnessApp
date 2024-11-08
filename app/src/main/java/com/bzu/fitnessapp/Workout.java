package com.bzu.fitnessapp;

public class Workout {
    private String name;
    private String type; //Cardio, Gym
    private int duration; //in minutes
    private int caloriesBurned;
    private String difficulty; // Easy, Medium, Hard
    private String targetedMuscles; //Chest, Legs, Back , Shoulders ,  etc...

    public Workout(String name, String type, int duration, int caloriesBurned, String difficulty, String targetedMuscles) {
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.difficulty = difficulty;
        this.targetedMuscles = targetedMuscles;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTargetedMuscles() {
        return targetedMuscles;
    }

    @Override
    public String toString() {
        return name + " (" + duration + " mins, " + caloriesBurned + " cal, Targets: " + targetedMuscles + ")";
    }
}
