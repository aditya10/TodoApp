package com.company;

import java.util.ArrayList;

public class Todo implements Task {

    int taskId;
    String taskName;
    ArrayList<Step> steps;
    String location;

    public Todo(int taskId, String taskName, ArrayList<Step> steps, String location) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.steps = steps;
        this.location = location;
    }


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
        for (int i = 0; i < steps.size(); i++) {
            if (!steps.get(i).isStepComplete()){
                return false;
            }
        }
        return true;
    }


    @Override
    public int getTaskId() {
        return taskId;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
