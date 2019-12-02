package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;


public class TodoListManager {

    ArrayList<TodoList> todoLists = new ArrayList<TodoList>();
    JSONArray jsonTodoLists;

    public TodoListManager(JSONArray jsonTodoLists) {
        this.jsonTodoLists = jsonTodoLists;
        generateTodoLists();
    }

    public void createList() {
        //Ignored for simplicity
    }

    public void deleteList() {
        //Ignored for simplicity
    }

    public ArrayList<TodoList> getTodoLists() {
        return todoLists;
    }

    public TodoList getTodoList(int id) {
        for (int i = 0; i < todoLists.size(); i++) {
            TodoList t = todoLists.get(i);
            if (t.id == id) {
             return t;
            }
        }
        return null;
    }

    private void generateTodoLists() {

        if (jsonTodoLists == null || jsonTodoLists.size() == 0) {
            return;
        }

        for (int i = 0; i < jsonTodoLists.size(); i++) {
            JSONObject currList = (JSONObject) jsonTodoLists.get(i);
            TodoManager manager = new TodoManager((JSONArray) currList.get("todos"));
            TodoList t = new TodoList(manager);
            t.setId(((Long) currList.get("id")).intValue());
            t.setName(((String) currList.get("name")).concat(" -- List " + t.getId()));
            todoLists.add(t);
        }
    }

    public void printTasks() {
        for (int i = 0; i < todoLists.size(); i++) {
            TodoList t = todoLists.get(i);
            System.out.println("Todo List: "+t.getName());
            t.getManager().printTodo();
        }
    }
}
