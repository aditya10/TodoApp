package com.company;

public class TodoList {

    String name = "";
    TodoManager manager = new TodoManager();

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

}
