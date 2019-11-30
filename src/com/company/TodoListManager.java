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

    }

    public void deleteList() {

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
            TodoList t = new TodoList();
            JSONObject currList = (JSONObject) jsonTodoLists.get(i);
            t.id = ((Long) currList.get("id")).intValue();
            t.name = (String) currList.get("name");
            t.manager = new TodoManager((JSONArray) currList.get("todos"));
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
