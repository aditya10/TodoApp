package com.company

import org.json.simple.JSONArray
import org.json.simple.JSONObject

import java.util.ArrayList


class TodoListManager(internal var jsonTodoLists: JSONArray?) {

    var todoLists = ArrayList<TodoList>()
        internal set

    init {
        generateTodoLists()
    }

    fun createList() {
        //Ignored for simplicity
    }

    fun deleteList() {
        //Ignored for simplicity
    }

    fun getTodoList(id: Int): TodoList? {
        for (i in todoLists.indices) {
            val t = todoLists[i]
            if (t.id == id) {
                return t
            }
        }
        return null
    }

    private fun generateTodoLists() {

        if (jsonTodoLists == null || jsonTodoLists!!.size == 0) {
            return
        }

        for (i in jsonTodoLists!!.indices) {
            val currList = jsonTodoLists!![i] as JSONObject
            val manager = TodoManager(currList["todos"] as JSONArray)
            val t = TodoList(manager)
            t.id = (currList["id"] as Long).toInt()
            t.name = currList["name"] as String + (" -- List " + t.id)
            todoLists.add(t)
        }
    }

    fun printTasks() {
        for (i in todoLists.indices) {
            val t = todoLists[i]
            println("Todo List: " + t.name)
            t.manager.printTodo()
        }
    }
}
