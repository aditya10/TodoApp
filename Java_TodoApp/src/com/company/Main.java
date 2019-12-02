package com.company;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        TodoListManager masterManager = parseTasks();
        try {
            masterManager.printTasks();
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        }
    }

    public static TodoListManager parseTasks() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("./tasks.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray jsonTodoLists = (JSONArray) obj;

            return new TodoListManager(jsonTodoLists);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printTodoLocation(Object obj){
        if (obj instanceof Todo) {
            Todo todo = (Todo) obj;
            System.out.println(todo.getLocation());
        }

    }
}
