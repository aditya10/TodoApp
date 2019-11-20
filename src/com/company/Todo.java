package com.company;

import java.util.ArrayList;

public class Todo implements Task {

    ArrayList<Step> steps = new ArrayList<Step>();
    String location = "";
    boolean isComplete = false;

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }


    @Override
    public int getTaskId() {
        return 0;
    }

    @Override
    public String getTaskName() {
        return null;
    }

    @Override
    public void setTaskId() {

    }

    @Override
    public void setTaskName() {

    }
}
