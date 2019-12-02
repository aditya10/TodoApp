package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class TodoManager {

    ArrayList<Todo> todos = new ArrayList<Todo>();
    JSONArray jsonTodoItems;

    public TodoManager(JSONArray jsonTodoItems) {
        this.jsonTodoItems = jsonTodoItems;
        generateTodoLists();
    }

    private void generateTodoLists() {

        if (jsonTodoItems == null || jsonTodoItems.size() == 0) {
            return;
        }

        for (int i = 0; i < jsonTodoItems.size(); i++) {

            JSONObject currTask = (JSONObject) jsonTodoItems.get(i);

            int taskid = ((Long) currTask.get("taskid")).intValue();
            String taskname = (String) currTask.get("taskname");
            String location = (String) currTask.get("location");
            ArrayList<Step> steps  =  generateStepList((JSONArray) currTask.get("steps"));

            Todo t = new Todo(taskid, taskname, steps, location);

            todos.add(t);
        }

    }

    private ArrayList<Step> generateStepList(JSONArray jsonSteps) {
        ArrayList<Step> steps = new ArrayList<>();
        for (int i = 0; i < jsonSteps.size(); i++) {

            JSONObject currStep = (JSONObject) jsonSteps.get(i);
            int stepId = ((Long) currStep.get("stepId")).intValue();
            String content = (String) currStep.get("stepContent");
            int difficultyRating = ((Long) currStep.get("difficulty")).intValue();
            boolean isStepComplete = (Boolean) currStep.get("stepCompleted");
            Step s = new Step(stepId, content, difficultyRating, isStepComplete);
            steps.add(s);

        }

        return steps;
    }

    public void addTask() {
        //Ignored for simplicity
    }

    public void removeTask() {
        //Ignored for simplicity
    }

    public void addStep(int taskId) {
        //Ignored for simplicity
    }

    public void removeStep(int taskId, int stepId) {
        //Ignored for simplicity
    }

    public void printTodo() {
        for (int i = 0; i < todos.size(); i++) {
            Todo t = todos.get(i);
            System.out.println("   Task Id:  "+t.getTaskId());
            System.out.println("   Task Name: "+t.getTaskName());
            System.out.println("   Task Location: "+t.getLocation());
            System.out.println("   Completion Status: "+t.isComplete());
            System.out.println("   Steps: ");
            for (int j = 0; j < t.steps.size(); j++) {
                System.out.println("       Step: "+t.steps.get(j).getContent());
            }
        }
    }

}
