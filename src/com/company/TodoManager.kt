package com.company

import org.json.simple.JSONArray
import org.json.simple.JSONObject

import java.util.ArrayList

class TodoManager(internal var jsonTodoItems: JSONArray?) {

    public var todos = ArrayList<Todo>()

    init {
        generateTodoLists()
    }

    private fun generateTodoLists() {

        if (jsonTodoItems == null || jsonTodoItems!!.size == 0) {
            return
        }

        for (i in jsonTodoItems!!.indices) {

            val currTask = jsonTodoItems!![i] as JSONObject

            val taskid = (currTask["taskid"] as Long).toInt()
            val taskname = currTask["taskname"] as String
            val location = currTask["location"] as String
            val steps = generateStepList(currTask["steps"] as JSONArray)

            val t = Todo(taskid, taskname, steps, location)

            todos.add(t)
        }

    }

    private fun generateStepList(jsonSteps: JSONArray): ArrayList<Step> {
        val steps = ArrayList<Step>()
        for (i in jsonSteps.indices) {

            val currStep = jsonSteps[i] as JSONObject
            val stepId = (currStep["stepId"] as Long).toInt()
            val content = currStep["stepContent"] as String
            val difficultyRating = (currStep["difficulty"] as Long).toInt()
            val isStepComplete = currStep["stepCompleted"] as Boolean
            val s = Step(stepId, content, difficultyRating, isStepComplete)
            steps.add(s)

        }

        return steps
    }

    fun addTask() {
        //Ignored for simplicity
    }

    fun removeTask() {
        //Ignored for simplicity
    }

    fun addStep(taskId: Int) {
        //Ignored for simplicity
    }

    fun removeStep(taskId: Int, stepId: Int) {
        //Ignored for simplicity
    }

    fun printTodo() {
        for (i in todos.indices) {
            val t = todos[i]
            println("   Task Id:  " + t.getTaskId())
            println("   Task Name: " + t.getTaskName())
            println("   Task Location: " + t.location)
            println("   Completion Status: " + t.isComplete)
            println("   Steps: ")
            for (j in 0 until t.steps.size) {
                println("       Step: " + t.steps[j].content)
            }
        }
    }

}
