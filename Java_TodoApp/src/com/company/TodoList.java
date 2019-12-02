package com.company;

public class TodoList {

    int id = 0;
    String name = "";
    TodoManager manager;

    public TodoList(TodoManager manager) {
        this.manager = manager;
    }

    public void setManager(TodoManager manager) {
        this.manager = manager;
    }

    public TodoManager getManager() {
        return manager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
